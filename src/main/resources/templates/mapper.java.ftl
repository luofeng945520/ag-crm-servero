package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

import java.util.List;
import java.util.Map;

/**
* @Date ${cfg.date}
* @author ${author}
*/
<#if kotlin>
    interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
    public interface ${table.mapperName} <#if cfg.extend>extends ${superMapperClass}<${entity}></#if> {

    <#list table.fields as field>
        <#if field.keyFlag>
            int deleteByPrimaryKey(${field.propertyType} id);

            int updateByPrimaryKey(${entity} record);

            ${entity} selectByPrimaryKey(${field.propertyType} id);

            int updateByPrimaryKeySelective(${entity} record);

        </#if>
    </#list>
    int insert(${entity} record);

    int insertSelective(${entity} record);

    int insertBatch(List<${entity}> recordList);

    int countSize(Map<${cfg.String},Object> map);

    List<${entity}> selectByPaging(Map<${cfg.String},Object> map);

    List<${entity}> selectByPagingFromContinuous(Map<${cfg.String}, Object> map);

    int countSizeFromContinuous(Map<${cfg.String}, Object> map);
    }
</#if>