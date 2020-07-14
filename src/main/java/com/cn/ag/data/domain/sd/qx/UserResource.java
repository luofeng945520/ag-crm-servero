package com.cn.ag.data.domain.sd.qx;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


/**
 * 用户资源表
 *
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public class UserResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 资源ID
     */
    private Long resourceId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }


    @Override
    public String toString() {
        return "UserResource{" +
                "userId=" + userId +
                ", resourceId=" + resourceId +
                "}";
    }
}