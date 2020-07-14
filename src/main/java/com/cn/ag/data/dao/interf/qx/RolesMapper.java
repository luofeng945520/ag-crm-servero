package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.Roles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface RolesMapper {

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Roles record);

    Roles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Roles record);

    int insert(Roles record);

    int insertSelective(Roles record);

    int insertBatch(List<Roles> recordList);

    int countSize(Map<String, Object> map);

    List<Roles> selectByPaging(Map<String, Object> map);

    List<Roles> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
