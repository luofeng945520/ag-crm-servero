package com.cn.ag.data.dao.impl.qx;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.qx.RolesSql;
import com.cn.ag.data.dao.interf.qx.RolesSqlMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Repository("rolesSqlMapperImpl")
public class RolesSqlMapperImpl extends MapperHelper<RolesSql> implements RolesSqlMapper {

    public int deleteByPrimaryKey(String id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(RolesSql record) {
        return updateHelper(record);
    }

    public RolesSql selectByPrimaryKey(String id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(RolesSql record) {
        return updateHelper(record);
    }

    public int insert(RolesSql record) {
        return insertHelper(record);
    }

    public int insertSelective(RolesSql record) {
        return insertHelper(record);
    }

    public int insertBatch(List<RolesSql> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<RolesSql> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<RolesSql> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
