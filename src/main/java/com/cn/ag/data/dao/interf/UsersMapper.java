package com.cn.ag.data.dao.interf;

import com.cn.ag.data.domain.sd.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-06-14 16:52:26
 */
public interface UsersMapper {

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int insert(Users record);

    int insertSelective(Users record);

    int insertBatch(List<Users> recordList);

    int countSize(Map<String, Object> map);

    List<Users> selectByPaging(Map<String, Object> map);

    List<Users> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
