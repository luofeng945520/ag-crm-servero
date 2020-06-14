package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
<#if cfg.extend>
    import ${superServiceImplClassPackage};
</#if>
import org.springframework.stereotype.Service;

/**
* @Date ${cfg.date}
* @author ${author}
*/
@Service
<#if kotlin>
    open class ${table.serviceImplName} : <#if cfg.extend>${superServiceImplClass}<${table.mapperName}, ${entity}>(),</#if> ${table.serviceName} {

    }
<#else>
    public class ${table.serviceImplName} <#if cfg.extend>extends ${superServiceImplClass}<${table.mapperName}, ${entity}></#if> implements ${table.serviceName} {

    }
</#if>
