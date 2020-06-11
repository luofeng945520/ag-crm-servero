package com.cn.ag.data.domain.sd;

import com.cn.ag.data.domain.sd.qx.QxFactory;

import java.util.List;

public class AgUsers {
	private Long id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 昵称
	 */
	private String fullname;
	/**
	 * 电话号码
	 */
	private String phone;

	private String token;

	private Long regTime;

	private Long lastLoginTime;
	/**
	 * 状态
	 */
	private Integer stat;

	private String roleIds;

	private String userCode;

	private String storeIds;
	/**
	 * 经销商ID
	 */
	private Long dealerId;

	private String responsibleAreaIds;
	/**
	 * 钉钉 用户ID
	 */
	private String ddUserId;
	/**
	 * 创建人ID
	 */
	private Long creatorId;

	private Integer responsibleDealerType;

	private Integer isMyselfOperation;
	
	private String position;

	/*        虚拟字段        */
	private String roleName;
	/**
	 * 工厂名称
	 */
	private String factoryName;
	/**
	 * 门店类型：0-普通版； 1-mini版
	 */
	private Integer storeType;
	/**
	 * 角色
	 */
	private AgRoles role;
	/**
	 * 门店
	 */
	private List<AgStore> store;
	/**
	 * 经销商
	 */
	private AgDealerBody dealer;

	/*--------------------------------------------------------------*
	|						  		角色集合							|
	|								权限集合							|
	*--------------------------------------------------------------*/


	private boolean authorized;
	
	private List<QxFactory> factory;

	


	public String getUserName() {
		return userName;
	}

	public AgUsers setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public AgUsers setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getFullname() {
		return fullname;
	}

	public AgUsers setFullname(String fullname) {
		this.fullname = fullname;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public AgUsers setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getToken() {
		return token;
	}

	public AgUsers setToken(String token) {
		this.token = token;
		return this;
	}

	public Long getRegTime() {
		return regTime;
	}

	public AgUsers setRegTime(Long regTime) {
		this.regTime = regTime;
		return this;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public AgUsers setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		return this;
	}

	public Integer getStat() {
		return stat;
	}

	public AgUsers setStat(Integer stat) {
		this.stat = stat;
		return this;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public AgUsers setRoleIds(String roleIds) {
		this.roleIds = roleIds;
		return this;
	}

	public String getUserCode() {
		return userCode;
	}

	public AgUsers setUserCode(String userCode) {
		this.userCode = userCode;
		return this;
	}

	public String getStoreIds() {
		return storeIds;
	}

	public AgUsers setStoreIds(String storeIds) {
		this.storeIds = storeIds;
		return this;
	}

	public Long getDealerId() {
		return dealerId;
	}

	public AgUsers setDealerId(Long dealerId) {
		this.dealerId = dealerId;
		return this;
	}

	public String getResponsibleAreaIds() {
		return responsibleAreaIds;
	}

	public AgUsers setResponsibleAreaIds(String responsibleAreaIds) {
		this.responsibleAreaIds = responsibleAreaIds;
		return this;
	}

	public String getDdUserId() {
		return ddUserId;
	}

	public AgUsers setDdUserId(String ddUserId) {
		this.ddUserId = ddUserId;
		return this;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public AgUsers setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
		return this;
	}

	public Integer getResponsibleDealerType() {
		return responsibleDealerType;
	}

	public AgUsers setResponsibleDealerType(Integer responsibleDealerType) {
		this.responsibleDealerType = responsibleDealerType;
		return this;
	}

	public Integer getIsMyselfOperation() {
		return isMyselfOperation;
	}

	public AgUsers setIsMyselfOperation(Integer isMyselfOperation) {
		this.isMyselfOperation = isMyselfOperation;
		return this;
	}

	public String getPosition() {
		return position;
	}

	public AgUsers setPosition(String position) {
		this.position = position;
		return this;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public AgUsers setFactoryName(String factoryName) {
		this.factoryName = factoryName;
		return this;
	}

	public Integer getStoreType() {
		return storeType;
	}

	public AgUsers setStoreType(Integer storeType) {
		this.storeType = storeType;
		return this;
	}

	public AgRoles getRole() {
		return role;
	}

	public AgUsers setRole(AgRoles role) {
		this.role = role;
		return this;
	}

	public List<AgStore> getStore() {
		return store;
	}

	public AgUsers setStore(List<AgStore> store) {
		this.store = store;
		return this;
	}

	public Long getId() {
		return id;
	}

	public AgUsers setId(Long id) {
		this.id = id;
		return this;
	}

	public AgDealerBody getDealer() {
		return dealer;
	}

	public AgUsers setDealer(AgDealerBody dealer) {
		this.dealer = dealer;
		return this;
	}

	public List<QxFactory> getFactory() {
		return factory;
	}

	public AgUsers setFactory(List<QxFactory> factory) {
		this.factory = factory;
		return this;
	}

	public String getRoleName() {
		return roleName;
	}

	public AgUsers setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}
}