package com.cn.ag.data.dao.impl;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.UserRole;
import com.cn.ag.data.dao.interf.UserRoleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-06-14 16:52:26
 */
@Repository("userRoleMapperImpl")
public class UserRoleMapperImpl extends MapperHelper<UserRole> implements UserRoleMapper {

    public int insert(UserRole record) {
        return insertHelper(record);
    }

    public int insertSelective(UserRole record) {
        return insertHelper(record);
    }

    public int insertBatch(List<UserRole> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<UserRole> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<UserRole> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
