package com.cn.ag.data.dao.interf;

import com.cn.ag.data.domain.sd.RoleResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-06-14 16:52:25
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
