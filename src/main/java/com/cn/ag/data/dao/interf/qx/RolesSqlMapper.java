package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.RolesSql;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface RolesSqlMapper {

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(RolesSql record);

    RolesSql selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolesSql record);

    int insert(RolesSql record);

    int insertSelective(RolesSql record);

    int insertBatch(List<RolesSql> recordList);

    int countSize(Map<String, Object> map);

    List<RolesSql> selectByPaging(Map<String, Object> map);

    List<RolesSql> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
