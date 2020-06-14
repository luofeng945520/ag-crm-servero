package com.cn.ag.data.dao.impl;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.Roles;
import com.cn.ag.data.dao.interf.RolesMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-06-14 16:48:48
 */
@Repository("rolesMapperImpl")
public class RolesMapperImpl extends MapperHelper<Roles> implements RolesMapper {

    public int deleteByPrimaryKey(Long id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(Roles record) {
        return updateHelper(record);
    }

    public Roles selectByPrimaryKey(Long id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(Roles record) {
        return updateHelper(record);
    }

    public int insert(Roles record) {
        return insertHelper(record);
    }

    public int insertSelective(Roles record) {
        return insertHelper(record);
    }

    public int insertBatch(List<Roles> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<Roles> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<Roles> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
