package com.cn.ag.data.dao.interf;

import com.cn.ag.data.domain.sd.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-06-14 16:52:26
 */
public interface UserRoleMapper {

    int insert(UserRole record);

    int insertSelective(UserRole record);

    int insertBatch(List<UserRole> recordList);

    int countSize(Map<String, Object> map);

    List<UserRole> selectByPaging(Map<String, Object> map);

    List<UserRole> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
