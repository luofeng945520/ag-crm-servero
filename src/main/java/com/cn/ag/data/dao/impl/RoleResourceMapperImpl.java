package com.cn.ag.data.dao.impl;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.RoleResource;
import com.cn.ag.data.dao.interf.RoleResourceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-06-14 16:52:25
 */
@Repository("roleResourceMapperImpl")
public class RoleResourceMapperImpl extends MapperHelper<RoleResource> implements RoleResourceMapper {

    public int insert(RoleResource record) {
        return insertHelper(record);
    }

    public int insertSelective(RoleResource record) {
        return insertHelper(record);
    }

    public int insertBatch(List<RoleResource> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<RoleResource> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<RoleResource> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
