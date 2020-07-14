package com.cn.ag.data.domain.sd.qx;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


/**
 * 字典表
 *
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    private Long id;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 键
     */
    private Integer dictKey;
    /**
     * 值
     */
    private String dictValue;
    /**
     * 字段名称
     */
    private String fieldName;
    /**
     * 表名
     */
    private String tableName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getDictKey() {
        return dictKey;
    }

    public void setDictKey(Integer dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    @Override
    public String toString() {
        return "Dict{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", dictKey=" + dictKey +
                ", dictValue=" + dictValue +
                ", fieldName=" + fieldName +
                ", tableName=" + tableName +
                "}";
    }
}