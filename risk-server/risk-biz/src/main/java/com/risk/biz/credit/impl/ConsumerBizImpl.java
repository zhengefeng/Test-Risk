package com.risk.biz.credit.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.codec.Md5Utils;
import com.common.utils.page.Pagination;
import com.risk.biz.credit.ConsumerBiz;
import com.risk.dal.credit.entity.Consumer;
import com.risk.dal.credit.mapper.ConsumerMapper;

@Service("consumerBiz")
public class ConsumerBizImpl implements ConsumerBiz {

	@Autowired
	private ConsumerMapper consumerMapper;

	@Override
	public int insert(Consumer consumer) {
		int result = 0;
		if (consumer.getId() == null) {
			consumer.setCreatetime(new Date());
			consumer.setStatus(new Short("1"));
			consumer.setPassword(Md5Utils.md5Encrypt(consumer.getPassword()));
			result = consumerMapper.insert(consumer);
		} else {
			result = consumerMapper.updateByPrimaryKeySelective(consumer);
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return consumerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Consumer selectByPrimaryKey(Integer id) {
		return consumerMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Consumer> queryConsumers(Consumer consumer) {
//		return consumerMapper.queryConsumers(consumer, new RowBounds());
		return consumerMapper.queryConsumers(consumer);
	}

	@Override
	public Pagination<Consumer, Consumer> queryConsumers(Pagination<Consumer, Consumer> pagination) {
		int count = consumerMapper.queryConsumersCount(pagination.getParam());
		pagination.setTotalCount(count);
		if (count > 0) {
			pagination.setDataList(consumerMapper.queryConsumers(pagination.getParam(), new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}

}
