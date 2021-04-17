<#if kotlin>
<#else>
    package ${cfg.MapperImpl};

    <#if cfg.superMapperImpl>
        import ${cfg.superMapperImplPkg}
    </#if>
    import ${package.Entity}.${entity};
    import ${package.Mapper}.${table.mapperName};
    import org.springframework.stereotype.Repository;

    import java.util.List;
    import java.util.Map;


    /**
    * @Date ${cfg.date}
    * @author ${author}
    */
    @Repository("${"${table.mapperName}Impl"?uncap_first}")
    public class ${table.mapperName}Impl <#if cfg.superMapperImpl>extends MapperHelper<${entity}></#if>  implements ${table.mapperName} {
 <#if cfg.needXML>
     <#list table.fields as field>
         <#if field.keyFlag>
             public int deleteByPrimaryKey(${field.propertyType} id){
             <#if cfg.superMapperImpl>
                 return deleteHelper(id);
             <#else>
                 return 0;
             </#if>
             }

             public int updateByPrimaryKey(${entity} record){
             <#if cfg.superMapperImpl>
                 return updateHelper(record);
             <#else>
                 return 0;
             </#if>
             }

             public ${entity} selectByPrimaryKey(${field.propertyType} id){
             <#if cfg.superMapperImpl>
                 return selectOneHelper(id);
             <#else>
                 return null;
             </#if>
             }

             public int updateByPrimaryKeySelective(${entity} record){
             <#if cfg.superMapperImpl>
                 return updateHelper(record);
             <#else>
                 return 0;
             </#if>
             }

         </#if>
     </#list>
     public int insert(${entity} record){
     <#if cfg.superMapperImpl>
         return insertHelper(record);
     <#else>
         return 0;
     </#if>
     }

     public int insertSelective(${entity} record){
     <#if cfg.superMapperImpl>
         return insertHelper(record);
     <#else>
         return 0;
     </#if>
     }

     public int insertBatch(List<${entity}> recordList){
     <#if cfg.superMapperImpl>
         return insertHelper(recordList);
     <#else>
         return 0;
     </#if>
     }

     public int countSize(Map<${cfg.String},Object> map){
     <#if cfg.superMapperImpl>
         return countHelper(map);
     <#else>
         return 0;
     </#if>
     }

     public List<${entity}> selectByPaging(Map<${cfg.String},Object> map){
     <#if cfg.superMapperImpl>
         return selectListHelper(map);
     <#else>
         return null;
     </#if>
     }

     public List<${entity}> selectByPagingFromContinuous(Map<${cfg.String}, Object> map){
     <#if cfg.superMapperImpl>
         return selectListHelper(map);
     <#else>
         return null;
     </#if>
     }

     public int countSizeFromContinuous(Map<${cfg.String}, Object> map){
     <#if cfg.superMapperImpl>
         return countHelper(map);
     <#else>
         return 0;
     </#if>
     }
 </#if>


    }
</#if>