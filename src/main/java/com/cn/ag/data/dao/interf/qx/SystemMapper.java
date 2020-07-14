package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.System;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface SystemMapper {

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(System record);

    System selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(System record);

    int insert(System record);

    int insertSelective(System record);

    int insertBatch(List<System> recordList);

    int countSize(Map<String, Object> map);

    List<System> selectByPaging(Map<String, Object> map);

    List<System> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
