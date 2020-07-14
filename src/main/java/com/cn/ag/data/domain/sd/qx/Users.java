package com.cn.ag.data.domain.sd.qx;

import java.io.Serializable;


/**
 * @author milk
 * @Date 2020-06-14 16:52:26
 */
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增序列号
     */
    private Long id;
    /**
     * 账号
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String fullname;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 令牌
     */
    private String token;
    /**
     * 注册时间
     */
    private Long regTime;
    /**
     * 编辑时间
     */
    private Long modifyTime;
    /**
     * 最后一次登录日期
     */
    private Long lastLoginTime;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 用户自编码
     */
    private String userCode;
    /**
     * 创建人ID
     */
    private Long creatorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getRegTime() {
        return regTime;
    }

    public void setRegTime(Long regTime) {
        this.regTime = regTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName=" + userName +
                ", password=" + password +
                ", fullname=" + fullname +
                ", phone=" + phone +
                ", token=" + token +
                ", regTime=" + regTime +
                ", modifyTime=" + modifyTime +
                ", lastLoginTime=" + lastLoginTime +
                ", state=" + state +
                ", userCode=" + userCode +
                ", creatorId=" + creatorId +
                "}";
    }
}