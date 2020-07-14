package com.cn.ag.data.domain.sd.qx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;


/**
 * 资源类型表
 *
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class ResourceType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 图标
     */
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    @Override
    public String toString() {
        return "ResourceType{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", typeName=" + typeName +
                ", icon=" + icon +
                "}";
    }
}