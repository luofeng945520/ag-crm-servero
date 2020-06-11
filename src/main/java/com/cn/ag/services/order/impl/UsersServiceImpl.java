package com.cn.ag.services.order.impl;

import com.cn.ag.data.dao.interf.AgUsersMapper;
import com.cn.ag.data.domain.sd.AgUsers;
import com.cn.ag.exception.QueryFailedException;
import com.cn.ag.exception.UpdateFailedException;
import com.cn.ag.services.order.UsersService;
import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.RequestParam;
import com.cn.ff.utils.comm.support.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName:UsersServiceImpl
 * @Description: 用户Service层
 * @Author: milk
 * @Date: 2020/5/26 20:49
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    @Qualifier("agUsersMapperImpl")
    private AgUsersMapper agUsersMapper;

    @Override
    public AgUsers login(AgUsers users) {
        AgUsers agUsers = agUsersMapper.selectQxUserByNameAndPass(users);
        if (agUsers == null){
            throw new QueryFailedException("用户名密码错误");
        }
        return agUsers;
    }

    @Override
    public AgUsers selectPhone(String phone) {
        return null;
    }

    @Override
    public int create(AgUsers user, AgUsers tokenUser, String id) {
        return 0;
    }

    @Override
    public int setData(AgUsers user) throws UpdateFailedException {
        return 0;
    }

    @Override
    public AgUsers selectByUserName(String name) {
        return null;
    }

    @Override
    public AgUsers createToken(AgUsers user, RequestParam paramObj) {
        return null;
    }

    @Override
    public AgUsers listUser(Long id) {
        return null;
    }

    @Override
    public ResultData listUsers(FrontRequestParam frontRequestParam, AgUsers tokenUser) {
        return null;
    }
}
