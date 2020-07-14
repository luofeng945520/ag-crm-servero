package com.cn.ag.controller.qx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.cn.ag.services.qx.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.annotations.Api;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import javax.servlet.http.HttpServletRequest;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Controller
@ResponseBody
@CrossOrigin(origins = "*")
@Api(description = "")
@RequestMapping("/users")
public class UsersController {


    @Autowired
    @Qualifier("usersServiceImpl")
    private UsersService usersService;

    /**
     * 新增
     */
    @RequestMapping(value = "/add", produces = "application/json")
    public ResultData add(HttpServletRequest request, String param) {
        return null;
    }

    /**
     * 查询
     */
    @RequestMapping(value = "/list", produces = "application/json")
    public ResultData list(HttpServletRequest request, String param) {
        return null;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/modify", produces = "application/json")
    public ResultData modify(HttpServletRequest request, String param) {
        return null;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/remove", produces = "application/json")
    public ResultData remove(HttpServletRequest request, String param) {
        return null;
    }


}
