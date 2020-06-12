<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">
    <#if enableCache>
        <!-- 开启二级缓存 -->
        <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>
    </#if>

    <#if baseResultMap>
        <!-- 通用查询映射结果 -->
        <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
            <#list table.fields as field>
                <#if field.keyFlag><#--生成主键排在第一位-->
                    <id column="${field.name}" property="${field.propertyName}" jdbcType="${field.columnType}" />
                </#if>
            </#list>
            <#list table.commonFields as field><#--生成公共字段 -->
                <result column="${field.name}" property="${field.propertyName}" jdbcType="${field.columnType}"  />
            </#list>
            <#list table.fields as field>
                <#if !field.keyFlag><#--生成普通字段 -->
                    <result column="${field.name}" property="${field.propertyName}" jdbcType="${field.columnType}"  />
                </#if>
            </#list>
        </resultMap>
    </#if>

    <#if baseColumnList>
        <!-- 通用查询结果列 -->
        <sql id="Base_Column_List">
            <#list table.commonFields as field>
                ${field.name},
            </#list>
            ${table.fieldNames}
        </sql>
    </#if>

    <#list table.fields as field>
        <#if field.keyFlag>
            <delete id="deleteByPrimaryKey" parameterType="${field.propertyType}" >
                delete from ${table.name}
                where ${field.name} = ${cfg.prefix}${field.name},jdbcType=${field.columnType}${cfg.suffix}
            </delete>
        </#if>
    </#list>

    <#list table.fields as field>
        <#if field.keyFlag>
            <update id="updateByPrimaryKey" parameterType="${package.Entity}.${entity}" >
                update ${table.name}
                set
                <#list table.fields as fieldup><#if !fieldup.keyFlag>${fieldup.name} = ${cfg.prefix}${fieldup.propertyName},jdbcType=${fieldup.columnType}${cfg.suffix}<#sep>,</#sep></#if></#list>
                where ${field.name} = ${cfg.prefix}${field.propertyName},jdbcType=${field.columnType}${cfg.suffix}
            </update>
        </#if>
    </#list>

    <#list table.fields as field>
        <#if field.keyFlag>
            <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="${field.propertyType}" >
                select
                <#if baseColumnList>
                    <include refid="Base_Column_List" />
                <#else>
                    <#list table.commonFields as field1>
                        ${field1.name},
                    </#list>
                    ${table.fieldNames}
                </#if>
                from ${table.name}
                where ${field.name} = ${cfg.prefix}${field.propertyName},jdbcType=${field.columnType}${cfg.suffix}
            </select>
        </#if>
    </#list>

    <#list table.fields as field>
        <#if field.keyFlag>
            <update id="updateByPrimaryKeySelective" parameterType="${package.Entity}.${entity}" >
                update ${table.name}
                <set >
                    <#list table.fields as fieldup>
                        <#if !fieldup.keyFlag>
                    <if test="${fieldup.propertyName} != null" >
                            ${fieldup.name} = ${cfg.prefix}${fieldup.propertyName},jdbcType=${fieldup.columnType}${cfg.suffix},
                    </if>
                        </#if>
                    </#list>
                </set>
                where ${field.name} = ${cfg.prefix}${field.propertyName},jdbcType=${field.columnType}${cfg.suffix}
            </update>
        </#if>
    </#list>

    <insert id="insert" parameterType="${package.Entity}.${entity}" >
        insert into ${table.name}
        (<#list table.commonFields as field1>${field1.name},</#list>
        ${table.fieldNames})
        values (<#list table.fields as field>${cfg.prefix}${field.propertyName},jdbcType=${field.columnType}${cfg.suffix}<#sep>,</#sep></#list>)
    </insert>

    <insert id="insertSelective" parameterType="${package.Entity}.${entity}" >
        insert into ${table.fieldNames}
        <trim prefix="(" suffix=")" suffixOverrides="," >
            <#list table.fields as field>
                <if test="${field.propertyName} != null" >
                    ${field.name},
                </if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
            <#list table.fields as field>
                <if test="${field.propertyName} != null" >
                    ${cfg.prefix}${field.propertyName},jdbcType=${field.columnType}${cfg.suffix},
                </if>
            </#list>
        </trim>
    </insert>

    <insert id="insertBatch" parameterType="List" >
        insert into ${table.name}
        (<#list table.commonFields as field1>${field1.name},</#list>${table.fieldNames})
        values
        <foreach collection="list" item="item" index="index" separator=",">
            (<#list table.fields as field>${cfg.prefix}item.${field.propertyName},jdbcType=${field.columnType}${cfg.suffix}<#sep>,</#sep></#list>)
        </foreach>
    </insert>

    <select id="countSize" parameterType="map" resultType="int">
        select count(1) from ${table.name}
        <where>
            <if test="whereParam!=null and whereParam!=''">
                ${cfg.whereParam}
            </if>
        </where>
    </select>

    <select id="selectByPaging" parameterType="map" resultMap="BaseResultMap">
        select <#if baseColumnList><include refid="Base_Column_List" /><#else>
            <#list table.commonFields as field1>${field1.name},</#list>${table.fieldNames}</#if> from ${table.name}
        <where>
            <if test="whereParam!=null and whereParam!=''">
                ${cfg.whereParam}
            </if>
        </where>
        <if test="startIndex!=null and endIndex !=null">
            limit ${cfg.startIndex},${cfg.endIndex}
        </if>
    </select>
</mapper>