package com.cn.ag.data.domain.sd.qx;

import java.io.Serializable;


/**
 * 系统表
 *
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class System implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    private String id;
    /**
     * 系统名称
     */
    private String systemName;
    /**
     * 创建时间
     */
    private Long createTime;

    /*  虚拟字段  */


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "System{" +
                "id=" + id +
                ", systemName=" + systemName +
                ", createTime=" + createTime +
                "}";
    }
}