/**
 * xletou-base com.xletou.base.db IParentMapper.java
 * 2015年9月10日 下午3:18:28
 */
package com.common.utils.db;

/**
 * 父Mapper接口
 * 
 * @author Super Jens Wang
 * @version 1.0 $id: IParentMapper.java 2015年9月10日 下午3:18:28 Wang Le $
 */
public interface IParentMapper<T> {

	int deleteByPrimaryKey(Integer id);

	int insert(T record);

	T selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(T record);

}
