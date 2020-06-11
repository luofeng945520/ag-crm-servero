package com.cn.ag.controller;

import com.cn.ag.data.domain.sd.AgRecommitForbidden;
import com.cn.ag.services.AgRecommitForbiddenService;
import com.cn.ag.utils.UtilParm;
import com.cn.ag.utils.UtilTools;
import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AgRecommitForbiddenController
 * @Description: TODO 禁止重复提交配置controller
 * @Author Amber
 * @Date 2019/11/25 14:57
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/recommit-forbidden",produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
@Api(tags = "禁止重复提交配置接口")
public class AgRecommitForbiddenController {

    @Autowired
    @Qualifier("agRecommitForbiddenServiceImpl")
    private AgRecommitForbiddenService agRecommitForbiddenService;

    @ApiOperation(
            value = "新增禁止重复提交的配置",
            notes = "参数->requestAddress[要拦截的请求地址],expireTime[限制多长时间内不能重复请求]，remarks[备注]",
            httpMethod = "POST"
    )
    @RequestMapping("/add")
    public ResultData add(String param){
        try {
            AgRecommitForbidden agRecommitForbidden = UtilTools.getObject(param,AgRecommitForbidden.class);
            agRecommitForbidden.setRequestAddress(agRecommitForbidden.getRequestAddress().trim());
            boolean add = agRecommitForbiddenService.add(agRecommitForbidden);
            if (!add){
                return UtilParm.resultData(0,"新增失败！");
            }
            return UtilParm.resultData(1,"新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return UtilParm.resultData(0,"新增失败！",e.getMessage());
        }
    }

    @ApiOperation(
            value = "分页查询",
            notes = "参数->分页查询参数",
            httpMethod = "POST"
    )
    @RequestMapping("/get-by-paging")
    public ResultData getByPaging(String param){
        try {
            FrontRequestParam frontRequestParam = UtilTools.getObject(param,FrontRequestParam.class);
            Map<String, Object> args = UtilTools.pagingHelper(frontRequestParam);
            int dataCount = agRecommitForbiddenService.statisticalNumber(args);
            if (dataCount==0){
                return UtilParm.resultData(0,"暂无数据");
            }
            List<AgRecommitForbidden> list = agRecommitForbiddenService.list(args);
            Map<String, Object> returnMap = UtilTools.pagingReturnMapGenerator(dataCount, frontRequestParam, list);
            return UtilParm.resultData(1,"查询成功！",returnMap);
        } catch (Exception e) {
            e.printStackTrace();
            return UtilParm.resultData(0,"查询失败！",e.getMessage());
        }
    }

    @ApiOperation(
            value = "修改禁止重复提交的配置",
            notes = "参数->需要修改的字段和主键id",
            httpMethod = "POST"
    )
    @RequestMapping("/modify")
    public ResultData modify(String param){
        try {
            AgRecommitForbidden agRecommitForbidden = UtilTools.getObject(param,AgRecommitForbidden.class);
            boolean b = agRecommitForbiddenService.modifyByPrimaryKeySelective(agRecommitForbidden);
            if (!b){
                return UtilParm.resultData(0,"修改失败！");
            }
            return UtilParm.resultData(1,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return UtilParm.resultData(0,"修改失败",e.getMessage());
        }
    }

    @ApiOperation(
            value = "删除禁止提价的配置",
            notes = "参数->要删除配置的主键id",
            httpMethod = "POST"
    )
    @RequestMapping("/remove")
    public ResultData remove(String param){
        try {
            AgRecommitForbidden agRecommitForbidden = UtilTools.getObject(param,AgRecommitForbidden.class);
            boolean b = agRecommitForbiddenService.removeByPrimaryKey(agRecommitForbidden);
            if (!b){
                return UtilParm.resultData(0,"删除失败！");
            }
            return UtilParm.resultData(1,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return UtilParm.resultData(0,"删除失败！",e.getMessage());
        }
    }

}
