package com.cn.ag.component;

import com.cn.ag.annotation.LoginToken;
import com.cn.ag.annotation.PassToken;
import com.cn.ag.data.dao.impl.AgUsersMapperImpl;
import com.cn.ag.data.domain.sd.AgStore;
import com.cn.ag.data.domain.sd.AgUsers;
import com.cn.ag.utils.JwtUtil;
import com.cn.ff.utils.BeanConversion.Json.GsonManager;
import com.cn.ff.utils.comm.support.RequestParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

/**
 * @ClassName:TokenAop
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/5/19 22:33
 */
public class TokenAop extends HandlerInterceptorAdapter {

    GsonManager gm = GsonManager.getIns();

    @Autowired
    private AgUsersMapperImpl agUsersMapperImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod=(HandlerMethod) handler;
        Method method=handlerMethod.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        if (!declaringClass.getPackage().getName().startsWith("com.cn.ag.controller")){
            return false;
        }

        boolean pass = false;
        //检查类是否有PassToken注解
        if (declaringClass.isAnnotationPresent(PassToken.class)){
            //类是否跳过验证
            pass = declaringClass.getAnnotation(PassToken.class).required();
        }

        //检查是否有PassToken注解，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            //方法是否跳过验证
            pass = method.getAnnotation(PassToken.class).required();
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(LoginToken.class)) {
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            pass = !loginToken.required();
        }

        if (!pass) {
            // 执行认证
            RequestParam param = gm.jsonToAnyObject(request.getParameter("param"), RequestParam.class);
            if (param == null || StringUtils.isBlank(param.getToken())){
                throw new RuntimeException("【TokenAop】缺少TOKEN参数");
            }
            String token;
            String[] tokenSment;
            // 先反base64

            token = new String(Base64.getDecoder().decode(param.getToken()), StandardCharsets.UTF_8);

            tokenSment = token.split("&");
            token = tokenSment[0];

            AgUsers agUsers = JwtUtil.unsign(token, AgUsers.class);
            if (agUsers == null) {
                throw new RuntimeException("【TokenAop异常】token失效");
            }

            AgUsers users = agUsersMapperImpl.selectPrimaryKeySelective(agUsers);
            agUsers.setRoleIds(users.getRole().getId()+"");
            agUsers.setStoreIds(dealStoreId(users.getStore()));
            agUsers.setRoleName(users.getRole().getRoleName());

            agUsers.setRole(users.getRole());
            agUsers.setStore(users.getStore());
            agUsers.setDealer(users.getDealer());

            request.setAttribute("tokenUser", agUsers);
        }


        return true;
    }


    private String dealStoreId(List<AgStore> stores){
        if (stores == null || stores.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (AgStore store : stores) {
            if (store == null){
                continue;
            }
            //拼接
            if(store.getId()!=null){
                if (sb.length() == 0){
                    sb.append(store.getId());
                }else{
                    sb.append(",").append(store.getId());
                }
            }
        }
        return sb.toString();
    }
}
