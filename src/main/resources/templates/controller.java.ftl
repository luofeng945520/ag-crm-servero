package ${package.Controller};


import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
        public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
        public class ${table.controllerName} {
    </#if>

    }
</#if>
