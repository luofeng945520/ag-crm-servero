package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.UserResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface UserResourceMapper {

    int insert(UserResource record);

    int insertSelective(UserResource record);

    int insertBatch(List<UserResource> recordList);

    int countSize(Map<String, Object> map);

    List<UserResource> selectByPaging(Map<String, Object> map);

    List<UserResource> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
