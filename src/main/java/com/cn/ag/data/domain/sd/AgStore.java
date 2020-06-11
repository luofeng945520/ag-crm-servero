package com.cn.ag.data.domain.sd;

import com.cn.ag.data.domain.sd.qx.QxFactory;

import java.util.List;

public class AgStore {
    private Long id;
    /**
     * 店名
     */
    private String storeName;
    /**
     * 门店自编码
     */
    private String dealerStoreCode;
    /**
     * 地址
     */
    private String address;
    /**
     * 经销商主体ID
     */
    private Long dealerBodyId;
    /**
     * 省 编号
     */
    private Integer province;
    /**
     * 市 编号
     */
    private Integer city;
    /**
     * 县 编号
     */
    private Integer county;
    /**
     * 状态
     */
    private Integer stat;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 创建人ID
     */
    private Long createUserId;
    /**
     * 收货地址
     */
    private String deliveryAddress;
    /**
     * 区域负责人
     */
    private String areaPrincipalId;
    /**
     * 大区负责人
     */
    private String bigAreaId;
    /**
     * 工厂code
     */
    private String factoryCode;
    /**
     * 发货地址
     */
    private String shipAddress;
    /**
     * 商川经销商（门店）id
     */
    private String scCustomerId;

    private String logistics;

    private String logisticsPhone;
    /**
     * 门店类型： 0-普通版【默认】；1-mini版
     */
    private Integer storeType;


    /*      虚拟字段     */
    /**
     * 经销商主体
     */
    private AgDealerBody dealerBody;
    /**
     * 省
     */
    private AgBaseArea provinceArea;
    /**
     * 市
     */
    private AgBaseArea cityArea;
    /**
     * 县
     */
    private AgBaseArea countyArea;
    /**
     * 创建人
     */
    private AgUsers createUser;
    /**
     * 区域负责人
     */
    private AgUsers areaPrincipal;
    /**
     * 大区负责人
     */
    private AgUsers bigArea;
    /**
     * 工厂
     */
    private QxFactory factory;
    /**
     * 门店驻场设计师
     */
    private List<AgUsers> residentDesigner;
    /**
     * 店长
     */
    private AgUsers shopManager;
    /**
     * 运营管理员
     */
    private AgUsers operationManager;

    public AgUsers getShopManager() {
        return shopManager;
    }

    public void setShopManager(AgUsers shopManager) {
        this.shopManager = shopManager;
    }

    public AgUsers getOperationManager() {
        return operationManager;
    }

    public void setOperationManager(AgUsers operationManager) {
        this.operationManager = operationManager;
    }

    public List<AgUsers> getResidentDesigner() {
        return residentDesigner;
    }

    public void setResidentDesigner(List<AgUsers> residentDesigner) {
        this.residentDesigner = residentDesigner;
    }

    public AgDealerBody getDealerBody() {
        return dealerBody;
    }

    public void setDealerBody(AgDealerBody dealerBody) {
        this.dealerBody = dealerBody;
    }

    public AgBaseArea getProvinceArea() {
        return provinceArea;
    }

    public void setProvinceArea(AgBaseArea provinceArea) {
        this.provinceArea = provinceArea;
    }

    public AgBaseArea getCityArea() {
        return cityArea;
    }

    public void setCityArea(AgBaseArea cityArea) {
        this.cityArea = cityArea;
    }

    public AgBaseArea getCountyArea() {
        return countyArea;
    }

    public void setCountyArea(AgBaseArea countyArea) {
        this.countyArea = countyArea;
    }

    public AgUsers getCreateUser() {
        return createUser;
    }

    public void setCreateUser(AgUsers createUser) {
        this.createUser = createUser;
    }

    public AgUsers getAreaPrincipal() {
        return areaPrincipal;
    }

    public void setAreaPrincipal(AgUsers areaPrincipal) {
        this.areaPrincipal = areaPrincipal;
    }

    public AgUsers getBigArea() {
        return bigArea;
    }

    public void setBigArea(AgUsers bigArea) {
        this.bigArea = bigArea;
    }

    public QxFactory getFactory() {
        return factory;
    }

    public void setFactory(QxFactory factory) {
        this.factory = factory;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public String getLogisticsPhone() {
        return logisticsPhone;
    }

    public void setLogisticsPhone(String logisticsPhone) {
        this.logisticsPhone = logisticsPhone;
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public String getScCustomerId() {
		return scCustomerId;
	}

	public void setScCustomerId(String scCustomerId) {
		this.scCustomerId = scCustomerId;
	}

	public String getFactoryCode() {
		return factoryCode;
	}

	public void setFactoryCode(String factoryCode) {
		this.factoryCode = factoryCode;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getAreaPrincipalId() {
		return areaPrincipalId;
	}

	public void setAreaPrincipalId(String areaPrincipalId) {
		this.areaPrincipalId = areaPrincipalId;
	}

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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getDealerStoreCode() {
        return dealerStoreCode;
    }

    public void setDealerStoreCode(String dealerStoreCode) {
        this.dealerStoreCode = dealerStoreCode == null ? null : dealerStoreCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getDealerBodyId() {
        return dealerBodyId;
    }

    public void setDealerBodyId(Long dealerBodyId) {
        this.dealerBodyId = dealerBodyId;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }
}