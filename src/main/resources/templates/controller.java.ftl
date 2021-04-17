package ${package.Controller};

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rhineetam.ag.entity.AgUsers;
import com.rhineetam.ag.utils.UtilTools;
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
    import io.swagger.annotations.ApiOperation;
    import springfox.documentation.annotations.ApiIgnore;
</#if>

import java.util.ArrayList;
import java.util.List;

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
    @Api(description="${table.comment!}",value="${table.comment!}", tags="${table.comment!}控制层")
</#if>
@RequestMapping(value = "<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>", produces = "application/json")
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
    <#if swagger2>
        @ApiOperation(
        value = "新增${table.comment!}",
        notes = "参数->${table.comment!}对象"
        )
    </#if>
    @PostMapping(value = "/add", produces = "application/json")
    public ResultData<${cfg.String}> add(@RequestHeader <#if swagger2> @ApiIgnore </#if> String token, @RequestBody ${entity} ${"${entity}"?uncap_first}){
    AgUsers user = UtilTools.getUserFromToken(token);
    ${"${entity}"?uncap_first}.setCreatedBy(user.getId());
    if (${"${table.serviceName}"?uncap_first}.save(${"${entity}"?uncap_first})) {
    return ResultData.ok("新增成功");
    }
    return ResultData.ok("新增失败");
    }

    /**
    * 查询
    */
    <#if swagger2>
        @ApiOperation(
        value = "分页查询${table.comment!}",
        notes = "参数->查询参数"
        )
    </#if>
    @PostMapping(value = "/list", produces = "application/json")
    public ResultData< IPage <${entity}>> list(@RequestBody ReqParamPlus<${entity}> proFrontReqParamPlus){
    QueryWrapper<${entity}> parse = ReqParamParser.parse(proFrontReqParamPlus, ${entity}.class);
    IPage<${entity}> page = agQuotationStrategyService.page(proFrontReqParamPlus, parse);
        return ResultData.ok(page);
    }

    /**
    * 修改
    */
    <#if swagger2>
        @ApiOperation(
        value = "修改${table.comment!}",
        notes = "参数->${table.comment!}对象"
        )
    </#if>
    @PostMapping(value = "/modify", produces = "application/json")
    public ResultData<${cfg.String}> modify(@RequestHeader @ApiIgnore String token, @RequestBody ${entity} ${"${entity}"?uncap_first}){
    AgUsers user = UtilTools.getUserFromToken(token);
    ${"${entity}"?uncap_first}.setModifiedBy(user.getId());
    ${"${entity}"?uncap_first}.setModifiedTime(System.currentTimeMillis());
    if (${"${table.serviceName}"?uncap_first}.updateById(${"${entity}"?uncap_first})) {
    return ResultData.ok("修改成功");
    }
    return ResultData.ok("修改失败");
    }

<#list table.fields as field>
    <#if field.keyFlag>
    /**
    * 删除
    */
    <#if swagger2>
        @ApiOperation(
        value = "删除${table.comment!}",
        notes = "参数->${table.comment!}id集合"
        )
    </#if>
    @PostMapping(value = "/remove", produces = "application/json")
    public ResultData<${cfg.String}> remove(@RequestParam List<${field.propertyType}> ids){
        if (${"${table.serviceName}"?uncap_first}.removeByIds(ids)) {
        return ResultData.ok("删除成功");
        }
        return ResultData.ok("删除失败");
        }
    </#if>
</#list>



    }
</#if>
