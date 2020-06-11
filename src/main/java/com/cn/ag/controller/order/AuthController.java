package com.cn.ag.controller.order;

import com.cn.ag.annotation.PassToken;
import com.cn.ag.data.domain.sd.AgUsers;
import com.cn.ag.services.order.UsersService;
import com.cn.ag.utils.UtilParm;
import com.cn.ag.utils.UtilTools;
import com.cn.ff.utils.comm.support.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/auth")
@ResponseBody
@PassToken
public class AuthController {

    @Autowired
    @Qualifier("usersServiceImpl")
    private UsersService usersService;


    @RequestMapping(value = "/get-token", produces = "application/json")
    @ResponseBody
    public ResultData getToken(String param) throws Exception {
        AgUsers qxUser = UtilTools.getObject(param, AgUsers.class);
        AgUsers extUser = UtilTools.getObject(param, AgUsers.class);

        /*------------------------------------检查用户是否可登陆-----------------------------------*/
        AgUsers checkQxUser = usersService.login(qxUser);

        if (checkQxUser.getStat() == 2){
            return UtilParm.resultData(0, "用户被冻结", "用户被冻结");
        }

        /*------------------------------------获取用户角色权限信息----------------------------------*/



        return UtilParm.resultData(0,"fail");
    }
}