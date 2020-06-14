package com.cn.ag.data.domain.sd;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


/**
 * @author milk
 * @Date 2020-06-14 16:52:25
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