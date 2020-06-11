package com.cn.ag.data.dao.impl;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.dao.interf.AgUsersMapper;
import com.cn.ag.data.domain.sd.AgUsers;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AgUsersMapperImpl extends MapperHelper<AgUsers> implements AgUsersMapper {

	@Override
	public int deleteByPrimaryKey(Long id) {
		return deleteHelper(id);
	}

	@Override
	public int insert(AgUsers record) {
		return insertHelper(record);
	}

	@Override
	public int insertSelective(AgUsers record) {
		return insertHelper(record);
	}

	@Override
	public AgUsers selectByPrimaryKey(Long id) {
		return selectOneHelper(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AgUsers record) {
		return updateHelper(record);
	}

	@Override
	public int updateByPrimaryKey(AgUsers record) {
		return updateHelper(record);
	}

	@Override
	public AgUsers selectByUserName(String userName) {
		return selectOneHelper(userName);
	}


	@Override
	public int getDataTotalOfContions(Map<String, Object> args) {
		return countHelper(args);
	}
	@Override
	public AgUsers selectPrimaryKeySelective(AgUsers record) {
		return selectOneHelper(record);
	}




	// 查询区域负责人
	@Override
	public List<AgUsers> selectListAgUsers(String[] arry) {
		return selectListHelper(arry);
	}

	@Override
	public List<AgUsers> getListResident(Map<String, Object> args){
		return selectListHelper(args);
	}
	@Override
	public int getListResidentNum(Map<String, Object> args) {
		return countHelper(args);
	}

	@Override
	public List<AgUsers> getListResidents(Map<String, Object> args){
		return selectListHelper(args);
	}
	@Override
	public int getListResidentNums(Map<String, Object> args) {
		return countHelper(args);
	}

	@Override
	public List<AgUsers> selectAgUsersIn(){
		return selectAllHelper();
	}

	@Override
	public AgUsers selectPhone(String phone){
		return selectOneHelper(phone);
	}

	@Override
	public AgUsers selectQxUserByNameAndPass(AgUsers record) {
		return selectOneHelper(record);
	}


	@Override
	public List<AgUsers> selectDealerId(String id){
		return selectListHelper(id);
	}

	@Override
	public String selectFullNameById(Long id) {
		return selectOneHelperCustom(id);
	}
	

	@Override
	public String selectAgUsersFullNameByddid(String ddid) {
		return selectOneHelperCustom(ddid);
	}

	@Override
	public List<AgUsers> selectShopownerDdIdByOrderCode(String orderCode) {
		return selectListHelper(orderCode);
	}

	@Override
	public AgUsers selectByDealerIdAndPhone(String id) {
		return selectOneHelper(id);
	}

	@Override
	public AgUsers selectStoreManager(Long storeId){
		return selectOneHelper(storeId);
	}


}
