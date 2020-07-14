package com.cn.ag.data.dao.impl.qx;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.qx.Users;
import com.cn.ag.data.dao.interf.qx.UsersMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Repository("usersMapperImpl")
public class UsersMapperImpl extends MapperHelper<Users> implements UsersMapper {

    public int deleteByPrimaryKey(Long id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(Users record) {
        return updateHelper(record);
    }

    public Users selectByPrimaryKey(Long id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(Users record) {
        return updateHelper(record);
    }

    public int insert(Users record) {
        return insertHelper(record);
    }

    public int insertSelective(Users record) {
        return insertHelper(record);
    }

    public int insertBatch(List<Users> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<Users> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<Users> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
