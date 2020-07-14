package com.cn.ag.services.qx.impl;

import com.cn.ag.data.domain.sd.qx.Users;
import com.cn.ag.data.dao.interf.qx.UsersMapper;
import com.cn.ag.services.qx.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService {

    @Autowired
    @Qualifier("usersMapperImpl")
    private UsersMapper usersMapper;


    /**
     * 获取单个对象
     */
    public Users get(Long id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(Long id) {
        return usersMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<Users> list(Map<String, Object> map) {
        return usersMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(Users users) {
        return usersMapper.insertSelective(users) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<Users> usersList) {
        //一次全部插入 若是数据过多 需要重写
        return usersMapper.insertBatch(usersList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
