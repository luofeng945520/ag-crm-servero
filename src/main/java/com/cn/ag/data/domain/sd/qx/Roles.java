package com.cn.ag.data.domain.sd.qx;

import java.io.Serializable;
import java.util.List;


/**
 * 角色表
 *
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 父级ID
     */
    private Long pid;
    /**
     * 别名
     */
    private String asName;
    /**
     * 分边(门店/工厂/...)
     */
    private Integer side;

    /*  虚拟字段  */
    /**
     * 系统
     */
    private List<System> systemList;

    public List<System> getSystemList() {
        return systemList;
    }

    public Roles setSystemList(List<System> systemList) {
        this.systemList = systemList;
        return this;
    }

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getAsName() {
        return asName;
    }

    public void setAsName(String asName) {
        this.asName = asName;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }


    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roleName=" + roleName +
                ", pid=" + pid +
                ", asName=" + asName +
                ", side=" + side +
                "}";
    }
}