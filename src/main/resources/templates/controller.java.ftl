package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ${package.Service}.${table.serviceName};
<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.ResponseBody;
    import org.springframework.web.bind.annotation.CrossOrigin;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>
<#if swagger2>
    import io.swagger.annotations.Api;
</#if>

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import javax.servlet.http.HttpServletRequest;

/**
* @Date ${cfg.date}
* @author ${author}
*/
<#if restControllerStyle>
    @RestController
<#else>
    @Controller
    @ResponseBody
    @CrossOrigin(origins = "*")
</#if>
<#if swagger2>
    @Api(description="${table.comment!}")
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
        public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
        public class ${table.controllerName} {


    </#if>
    @Autowired
    @Qualifier("${"${table.serviceImplName}"?uncap_first}")
    private ${table.serviceName} ${"${table.serviceName}"?uncap_first};

    /**
    * 新增
    */
    @RequestMapping(value = "/add", produces = "application/json")
    public ResultData add(HttpServletRequest request,String param){
    return null;
    }

    /**
    * 查询
    */
    @RequestMapping(value = "/list", produces = "application/json")
    public ResultData list(HttpServletRequest request,String param){
    return null;
    }

    /**
    * 修改
    */
    @RequestMapping(value = "/modify", produces = "application/json")
    public ResultData modify(HttpServletRequest request,String param){
    return null;
    }

    /**
    * 删除
    */
    @RequestMapping(value = "/remove", produces = "application/json")
    public ResultData remove(HttpServletRequest request,String param){
    return null;
    }


    }
</#if>
