package com.cn.ag.data.domain.sd.qx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class UsersRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增序列号
     */
    private Long id;
    /**
     * 关联用户表ID
     */
    private Long usersId;
    /**
     * 角色ID
     */
    private Long rolesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Long getRolesId() {
        return rolesId;
    }

    public void setRolesId(Long rolesId) {
        this.rolesId = rolesId;
    }


    @Override
    public String toString() {
        return "UsersRoles{" +
                "id=" + id +
                ", usersId=" + usersId +
                ", rolesId=" + rolesId +
                "}";
    }
}