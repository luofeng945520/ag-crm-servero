package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
<#if cfg.extend>
    import ${superServiceImplClassPackage};
</#if>
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
<#--import org.springframework.beans.factory.annotation.Autowired;-->
<#--import org.springframework.beans.factory.annotation.Qualifier;-->

<#--import com.cn.ff.utils.comm.support.FrontRequestParam;-->
<#--import com.cn.ff.utils.comm.support.ResultData;-->
<#--import com.cn.ag.utils.UtilParm;-->
<#--import com.cn.ag.utils.UtilTools;-->

import java.util.List;
import java.util.Map;

/**
* @Date ${cfg.date}
* @author ${author}
*/
@Service("${"${table.serviceImplName}"?uncap_first}")
<#if kotlin>
    open class ${table.serviceImplName} : <#if cfg.extend>${superServiceImplClass}<${table.mapperName}, ${entity}>(),</#if> ${table.serviceName} {

    }
<#else>
    public class ${table.serviceImplName} <#if cfg.extend>extends ${superServiceImplClass}<${table.mapperName}, ${entity}></#if> implements ${table.serviceName} {

<#--    @Autowired-->
<#--    @Qualifier("${"${table.mapperName}Impl"?uncap_first}")-->
    @Resource
    private ${table.mapperName} ${"${table.mapperName}"?uncap_first};
    <#if cfg.needXML>
        <#list table.fields as field>
            <#if field.keyFlag>
                /**
                * 获取单个对象
                */
                @Override
                public ${entity} get(${field.propertyType} id){
                return ${"${table.mapperName}"?uncap_first}.selectByPrimaryKey(id);
                }

                /**
                * 通过主键选择性修改
                */
                @Override
                public boolean modifyByPrimaryKeySelective(${entity} ${"${entity}"?uncap_first}){
                return ${"${table.mapperName}"?uncap_first}.updateByPrimaryKeySelective(${"${entity}"?uncap_first}) > 0;
                }

                /**
                * 通过主键删除
                */
                @Override
                public boolean removeByPrimaryKey(${field.propertyType} id){
                return ${"${table.mapperName}"?uncap_first}.deleteByPrimaryKey(id) > 0;
                }
            </#if>
        </#list>

        /**
        * 获取多个对象
        */
        @Override
        public List<${entity}> list(Map<${"String"},Object> map){
        return ${"${table.mapperName}"?uncap_first}.selectByPaging(map);
        }

        /**
        * 添加单个
        */
        @Override
        public boolean add(${entity} ${"${entity}"?uncap_first}){
        return  ${"${table.mapperName}"?uncap_first}.insertSelective(${"${entity}"?uncap_first}) > 0;
        }

        /**
        * 批量添加
        */
        @Override
        public boolean addBatch(List<${entity}> ${"${entity}"?uncap_first}List){
        //一次全部插入 若是数据过多 需要重写
        return  ${"${table.mapperName}"?uncap_first}.insertBatch(${"${entity}"?uncap_first}List) > 0;
        }

        /**
        * 获取结果
        */
        @Override
        public ResultData lists(FrontRequestParam frontRequestParam){
        return null;
        }
    </#if>



    }
</#if>
