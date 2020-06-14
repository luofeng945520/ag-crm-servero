package ${package.Service};

import ${package.Entity}.${entity};
<#if cfg.extend>
    import ${superServiceClassPackage};
</#if>

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
* @Date ${cfg.date}
* @author ${author}
*/
<#if kotlin>
    interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
    public interface ${table.serviceName} <#if cfg.extend>extends ${superServiceClass}<${entity}></#if> {

    <#list table.fields as field>
        <#if field.keyFlag>
            /**
            * 获取单个对象
            */
            ${entity} get(${field.propertyType} id);

            /**
            * 通过主键选择性修改
            */
            boolean modifyByPrimaryKeySelective(${entity} ${"${entity}"?uncap_first});

            /**
            * 通过主键删除
            */
            boolean removeByPrimaryKey(${field.propertyType} id);
        </#if>
    </#list>

    /**
    * 获取多个对象
    */
    List<${entity}> list(Map<${"String"},Object> map);

    /**
    * 添加单个
    */
    boolean add(${entity} ${"${entity}"?uncap_first});

    /**
    * 批量添加
    */
    boolean addBatch(List<${entity}> ${"${entity}"?uncap_first}List);

    /**
    * 获取结果
    */
    ResultData lists(FrontRequestParam frontRequestParam);
    }
</#if>
