package com.cn.ag.data.domain.sd;

public class AgRoles {
    private Long id;

    private String roleName;

    private Long pid;

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
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    
    
    /*--------------------------------------------------------------*
    |						  	权限对象集合							|
    *--------------------------------------------------------------*/
}