package com.risk.biz.credit;

import java.util.List;
import java.util.Map;

import com.common.utils.page.PageDto;
import com.common.utils.page.Pagination;
import com.risk.dal.credit.dto.ConsumerTemplateDetailDto;
import com.risk.dal.credit.dto.StatisticsPersonDto;
import com.risk.dal.credit.entity.ConsumerTemplateDetail;
import org.apache.ibatis.session.RowBounds;

/**
 * Created by zhenge.feng.
 */
public interface ConsumerTemplateDetailBiz {
	/**
	 * 保存
	 */
	int insert(ConsumerTemplateDetail consumerTemplateDetail);

	/**
	 * 根据ID删除
	 */
	int delete(Integer id);

	/**
	 * 通过主键ID查询
	 * 
	 * @param id
	 * @return
	 */
	ConsumerTemplateDetail selectByPrimaryKey(Integer id);

	/**
	 * 查询模板调用流水列表，不分页
	 * 
	 * @param company
	 * @return
	 */
	List<ConsumerTemplateDetail> queryConsumerTemplateDetails(ConsumerTemplateDetail consumerTemplateDetail);
	
	/**
	 * 查询费用明细
	 */
	Object queryTemplateSearchDetail(Map<String,Object> paramMap);

	/**
	 * 分页查询模板调用流水
	 * 
	 * @param pagination
	 * @return
	 */
	Pagination<ConsumerTemplateDetail, ConsumerTemplateDetail> queryConsumerTemplateDetails(Pagination<ConsumerTemplateDetail, ConsumerTemplateDetail> pagination);

	/**
	 * 分页查询模板流水
	 * @param dto
	 * @param rowBounds
	 * @return
	 */
    PageDto<ConsumerTemplateDetail> queryPage(ConsumerTemplateDetailDto dto, RowBounds rowBounds);

	StatisticsPersonDto queryStatisticsPerson(String name);
}
