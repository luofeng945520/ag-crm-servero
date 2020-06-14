package com.cn.ag.data.domain.sd;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;


/**
 * @author milk
 * @Date 2020-06-14 16:48:48
 */
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增序列号
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 角色自编码
     */
    private String roleCode;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 编辑时间
     */
    private Long modifyTime;
    /**
     * 角色限制人数
     */
    private Long limitNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Long getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Long limitNum) {
        this.limitNum = limitNum;
    }


    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roleName=" + roleName +
                ", state=" + state +
                ", roleCode=" + roleCode +
                ", remark=" + remark +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", limitNum=" + limitNum +
                "}";
    }
}