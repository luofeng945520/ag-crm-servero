package com.cn.ag.data.domain.sd;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


/**
 * 资源表
 *
 * @author milk
 * @Date 2020-06-14 16:52:25
 */
public class Resources implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增序列号
     */
    private Long id;
    /**
     * 上级资源ID
     */
    private Long pid;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 对应路由
     */
    private String path;
    /**
     * 对应组件
     */
    private String component;
    /**
     * (权限)标识
     */
    private String perms;
    /**
     * 图标
     */
    private String icon;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 修改时间
     */
    private Long modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
        return "Resources{" +
                "id=" + id +
                ", pid=" + pid +
                ", resourceName=" + resourceName +
                ", path=" + path +
                ", component=" + component +
                ", perms=" + perms +
                ", icon=" + icon +
                ", type=" + type +
                ", orderNum=" + orderNum +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                "}";
    }
}