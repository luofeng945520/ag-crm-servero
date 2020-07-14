package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.UsersRoles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface UsersRolesMapper {

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(UsersRoles record);

    UsersRoles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersRoles record);

    int insert(UsersRoles record);

    int insertSelective(UsersRoles record);

    int insertBatch(List<UsersRoles> recordList);

    int countSize(Map<String, Object> map);

    List<UsersRoles> selectByPaging(Map<String, Object> map);

    List<UsersRoles> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
