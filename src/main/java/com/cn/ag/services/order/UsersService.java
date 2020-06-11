package com.cn.ag.services.order;

import com.cn.ag.data.domain.sd.AgUsers;
import com.cn.ag.exception.UpdateFailedException;
import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.RequestParam;
import com.cn.ff.utils.comm.support.ResultData;

public interface UsersService {


    AgUsers login(AgUsers users);

    /**
     * @Description: 通过手机查询用户
     * @param phone
     * @Return com.cn.ag.data.domain.sd.AgUsers
     * @throws
     * 2020/5/26 20:50
     * @Author milk
     */
    AgUsers selectPhone(String phone);

    /**
     * @Description: 新增用户
     * @param user 新增的用户
     * @param tokenUser 新增用户的用户
     * @param id
     * @Return int
     * @throws
     * 2020/5/26 20:50
     * @Author milk
     */
    int create(AgUsers user, AgUsers tokenUser, String id);

    /**
     * @Description: 修改用户信息
     * @param user
     * @Return int
     * @throws
     * 2020/5/26 20:52
     * @Author milk
     */
    int setData(AgUsers user) throws UpdateFailedException;

    /**
     * @Description: 通过实名查询用户
     * @param name
     * @Return com.cn.ag.data.domain.sd.AgUsers
     * @throws
     * 2020/5/26 20:52
     * @Author milk
     */
    AgUsers selectByUserName(String name);

    ;/**
     * @Description: 生成Token
     * @param user
     * @param paramObj
     * @Return com.cn.ag.data.domain.sd.AgUsers
     * @throws
     * 2020/5/26 20:54
     * @Author milk
     */
    AgUsers createToken(AgUsers user, RequestParam paramObj);

    /**
     * @Description: 通过ID 获取用户信息
     * @param id
     * @Return com.cn.ag.data.domain.sd.AgUsers
     * @throws
     * 2020/5/26 20:54
     * @Author milk
     */
    AgUsers listUser(Long id);

    /**
     * @Description: 查询用户
     * @param frontRequestParam 条件
     * @param tokenUser 当前用户
     * @Return com.cn.ff.utils.comm.support.ResultData
     * @throws
     * 2020/5/26 20:55
     * @Author milk
     */
    ResultData listUsers(FrontRequestParam frontRequestParam, AgUsers tokenUser);
}
