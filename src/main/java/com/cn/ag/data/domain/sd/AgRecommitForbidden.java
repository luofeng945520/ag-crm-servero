package com.cn.ag.data.domain.sd;

import com.cn.ag.utils.UtilTools;

public class AgRecommitForbidden {

    public static final String REDIS_KEY_PREFIX = "recommitForbidden:";

    private String id = UtilTools.getUUID();

    private String requestAddress;

    private Long expireTime;

    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress == null ? null : requestAddress.trim();
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}