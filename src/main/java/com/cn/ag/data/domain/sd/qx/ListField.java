package com.cn.ag.data.domain.sd.qx;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


/**
 * 列表字段表  (资源类型为列表类型时)
 *
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class ListField implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    private String id;
    /**
     * 资源ID
     */
    private Long resourceId;
    /**
     * 显示属性
     */
    private String displayProperty;
    /**
     * 类属性
     */
    private String classProperty;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 修改时间
     */
    private Long modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getDisplayProperty() {
        return displayProperty;
    }

    public void setDisplayProperty(String displayProperty) {
        this.displayProperty = displayProperty;
    }

    public String getClassProperty() {
        return classProperty;
    }

    public void setClassProperty(String classProperty) {
        this.classProperty = classProperty;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }


    @Override
    public String toString() {
        return "ListField{" +
                "id=" + id +
                ", resourceId=" + resourceId +
                ", displayProperty=" + displayProperty +
                ", classProperty=" + classProperty +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                "}";
    }
}