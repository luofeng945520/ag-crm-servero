package com.cn.ag.data.dao.impl;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.UserResource;
import com.cn.ag.data.dao.interf.UserResourceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-06-14 16:52:25
 */
@Repository("userResourceMapperImpl")
public class UserResourceMapperImpl extends MapperHelper<UserResource> implements UserResourceMapper {

    public int insert(UserResource record) {
        return insertHelper(record);
    }

    public int insertSelective(UserResource record) {
        return insertHelper(record);
    }

    public int insertBatch(List<UserResource> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<UserResource> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<UserResource> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
