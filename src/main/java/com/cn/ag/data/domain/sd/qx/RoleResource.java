package com.cn.ag.data.domain.sd.qx;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


/**
 * 角色资源表
 *
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 资源ID
     */
    private Long resourceId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }


    @Override
    public String toString() {
        return "RoleResource{" +
                "roleId=" + roleId +
                ", resourceId=" + resourceId +
                "}";
    }
}