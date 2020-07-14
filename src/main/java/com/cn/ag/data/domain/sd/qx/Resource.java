package com.cn.ag.data.domain.sd.qx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;


/**
 * 资源表
 *
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    private Long id;
    /**
     * 父级ID
     */
    private Long parentId;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 修改时间
     */
    private Long modifyTime;
    /**
     * 名称
     */
    private String resourceName;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 图标
     */
    private String icon;
    /**
     * 控件ID(html中的ID)
     */
    private String controlId;
    /**
     * 路由
     */
    private String path;
    /**
     * 资源URL
     */
    private String resourceUrl;
    /**
     * 排序
     */
    private Long orderNum;
    /**
     * 系统标识
     */
    private String projectSystemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getProjectSystemId() {
        return projectSystemId;
    }

    public void setProjectSystemId(String projectSystemId) {
        this.projectSystemId = projectSystemId;
    }


    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", resourceName=" + resourceName +
                ", type=" + type +
                ", icon=" + icon +
                ", controlId=" + controlId +
                ", path=" + path +
                ", resourceUrl=" + resourceUrl +
                ", orderNum=" + orderNum +
                ", projectSystemId=" + projectSystemId +
                "}";
    }
}