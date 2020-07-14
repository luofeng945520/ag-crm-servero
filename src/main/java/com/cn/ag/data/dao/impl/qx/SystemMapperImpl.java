package com.cn.ag.data.dao.impl.qx;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.qx.System;
import com.cn.ag.data.dao.interf.qx.SystemMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Repository("systemMapperImpl")
public class SystemMapperImpl extends MapperHelper<System> implements SystemMapper {

    public int deleteByPrimaryKey(String id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(System record) {
        return updateHelper(record);
    }

    public System selectByPrimaryKey(String id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(System record) {
        return updateHelper(record);
    }

    public int insert(System record) {
        return insertHelper(record);
    }

    public int insertSelective(System record) {
        return insertHelper(record);
    }

    public int insertBatch(List<System> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<System> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<System> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
