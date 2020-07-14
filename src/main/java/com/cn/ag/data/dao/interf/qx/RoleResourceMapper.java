package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.RoleResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface RoleResourceMapper {

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    int insertBatch(List<RoleResource> recordList);

    int countSize(Map<String, Object> map);

    List<RoleResource> selectByPaging(Map<String, Object> map);

    List<RoleResource> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
