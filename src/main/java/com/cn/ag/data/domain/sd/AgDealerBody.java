package com.cn.ag.data.domain.sd;

public class AgDealerBody {
    private Long id;

    private String dealerName;

    private String phone;

    private Long areaId;

    private String address;

    private Long areaPrincipalId;

    private Integer type;

    private Double creditLimit;

    private Double creditMomeny;

    private Double accountMomeny;

    private Long createTime;

    private Long createUserId;

    private Integer brand;
    
    private String bigAreaId;
    
    

    public String getBigAreaId() {
		return bigAreaId;
	}

	public void setBigAreaId(String bigAreaId) {
		this.bigAreaId = bigAreaId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getAreaPrincipalId() {
        return areaPrincipalId;
    }

    public void setAreaPrincipalId(Long areaPrincipalId) {
        this.areaPrincipalId = areaPrincipalId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getCreditMomeny() {
        return creditMomeny;
    }

    public void setCreditMomeny(Double creditMomeny) {
        this.creditMomeny = creditMomeny;
    }

    public Double getAccountMomeny() {
        return accountMomeny;
    }

    public void setAccountMomeny(Double accountMomeny) {
        this.accountMomeny = accountMomeny;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }
}