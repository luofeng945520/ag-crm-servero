package com.cn.ag.data.domain.sd.qx;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class RolesSql implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    private String id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 模块名
     */
    private String moduleName;
    /**
     * 条件
     */
    private String presetSql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getPresetSql() {
        return presetSql;
    }

    public void setPresetSql(String presetSql) {
        this.presetSql = presetSql;
    }


    @Override
    public String toString() {
        return "RolesSql{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", moduleName=" + moduleName +
                ", presetSql=" + presetSql +
                "}";
    }
}