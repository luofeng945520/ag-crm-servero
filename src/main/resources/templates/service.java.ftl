package ${package.Service};

import ${package.Entity}.${entity};
<#if cfg.extend>
    import ${superServiceClassPackage};
</#if>
/**
* @Date ${cfg.date}
* @author ${author}
*/
<#if kotlin>
    interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
    public interface ${table.serviceName} <#if cfg.extend>extends ${superServiceClass}<${entity}></#if> {

    }
</#if>
