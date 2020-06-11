package com.cn.ag.data.dao.impl.qx;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.dao.interf.qx.QxFactoryMapper;
import com.cn.ag.data.domain.sd.qx.QxFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QxFactoryMapperImpl extends MapperHelper<QxFactory> implements QxFactoryMapper {

	@Override
	public int deleteByPrimaryKey(String id) {
		return deleteHelper(id);
	}

	@Override
	public int insert(QxFactory record) {
		return insertHelper(record);
	}

	@Override
	public int insertSelective(QxFactory record) {
		return insertHelper(record);
	}

	@Override
	public QxFactory selectByPrimaryKey(String id) {
		return selectOneHelper(id);
	}

	@Override
	public int updateByPrimaryKeySelective(QxFactory record) {
		return updateHelper(record);
	}

	@Override
	public int updateByPrimaryKey(QxFactory record) {
		return updateHelper(record);
	}
	
	public List<QxFactory> selectAll(){
		return selectAllHelper();
	}

	/**
	 * 
	 * @Title: conditionSelect
	 * @Description: 通过条件分页查询
	 * @param map
	 * @return List<QxFactory>    返回类型
	 * @date 2019年3月23日 上午10:22:29
	 * @throws
	 */
	public List<QxFactory> conditionSelect(Map<String, Object> map){
		return selectListHelper(map);
	}
	
	/**
	 * 
	 * @Title: conditionSelectNum
	 * @Description: 条件查询总条数
	 * @param map
	 * @return int    返回类型
	 * @date 2019年3月23日 上午10:23:09
	 * @throws
	 */
	public int conditionSelectNum(Map<String, Object> map){
		return countHelper(map);
	}
}
