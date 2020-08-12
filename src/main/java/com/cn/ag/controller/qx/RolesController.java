package com.cn.ag.controller.qx;

import com.cn.ag.data.domain.sd.qx.Roles;
import com.cn.ag.data.domain.sd.qx.Users;
import com.cn.ag.utils.UtilParm;
import com.cn.ag.utils.UtilTools;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.cn.ag.services.qx.RolesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.annotations.Api;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Controller
@ResponseBody
@CrossOrigin(origins = "*")
@Api(description = "角色表")
@RequestMapping("/roles")
public class RolesController {


    @Autowired
    @Qualifier("rolesServiceImpl")
    private RolesService rolesService;

    /**
     * 新增
     */
    @ApiOperation(
            value = "新增角色",
            notes = "{\"value\":{\"roleName\":\"角色名称\",\"asName\":\"角色别名\",\"side\":1（门店方）/2（工厂方）}}",
            httpMethod = "POST",
            produces = "application/json"
    )
    @RequestMapping(value = "/add", produces = "application/json")
    public ResultData add(HttpServletRequest request, String param) throws Exception {
        Roles roles = UtilTools.getObject(param, Roles.class);
        boolean add = rolesService.add(roles);
        if (add) {
            return UtilParm.resultData(1, "新增成功", null);
        }
        return UtilParm.resultData(0, "新增失败", null);
    }

    /**
     * 查询
     */
    @ApiOperation(
            value = "查询角色",
            notes = "{\"frontRequestParam\":{\"page\":0,\"pageDataNumber\":0,\"pagesCount\":0,\"wheres\":[{\"op\":\"WOP0x\",\"key\":\"role_name\",\"setup\":\"setup\",\"valueType\":\"valueType\",\"value\":\"角色名称\"},{\"op\":\"WOP0x\",\"key\":\"as_name\",\"setup\":\"setup\",\"valueType\":\"valueType\",\"value\":\"别名\"},{\"op\":\"WOP0x\",\"key\":\"side\",\"setup\":\"setup\",\"valueType\":\"valueType\",\"value\":\"分边(1 门店/ 2 工厂/...)\"},{\"op\":\"WOP0x\",\"key\":\"id\",\"setup\":\"setup\",\"valueType\":\"valueType\",\"value\":\"角色ID\"}]}}",
            httpMethod = "POST",
            produces = "application/json"
    )
    @RequestMapping(value = "/list", produces = "application/json")
    public ResultData list(HttpServletRequest request, String param) {
        // 获取请求参数中的user实体
        Users tokenUser = (Users) request.getAttribute("tokenUser");
        FrontRequestParam frontRequestParam = UtilTools.getObject(param, FrontRequestParam.class);
        return rolesService.lists(frontRequestParam, tokenUser);
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
