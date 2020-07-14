package com.cn.ag.data.dao.impl.qx;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.qx.UsersRoles;
import com.cn.ag.data.dao.interf.qx.UsersRolesMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Repository("usersRolesMapperImpl")
public class UsersRolesMapperImpl extends MapperHelper<UsersRoles> implements UsersRolesMapper {

    public int deleteByPrimaryKey(Long id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(UsersRoles record) {
        return updateHelper(record);
    }

    public UsersRoles selectByPrimaryKey(Long id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(UsersRoles record) {
        return updateHelper(record);
    }

    public int insert(UsersRoles record) {
        return insertHelper(record);
    }

    public int insertSelective(UsersRoles record) {
        return insertHelper(record);
    }

    public int insertBatch(List<UsersRoles> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<UsersRoles> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<UsersRoles> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
