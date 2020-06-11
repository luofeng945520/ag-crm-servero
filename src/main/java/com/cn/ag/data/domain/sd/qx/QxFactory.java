package com.cn.ag.data.domain.sd.qx;

import java.io.Serializable;
import java.util.UUID;

public class QxFactory implements Serializable {
	private String id;
    /**
	 * 
	 */
	private static final long serialVersionUID = -3267705183999332629L;

	private String factoryName;

    private String factoryCode;
    
    private String address;

    private Integer factoryType;

    private String resolveAddress;

	public QxFactory() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public QxFactory setId(String id) {
		this.id = id;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode == null ? null : factoryCode.trim();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((factoryCode == null) ? 0 : factoryCode.hashCode());
		result = prime * result + ((factoryName == null) ? 0 : factoryName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QxFactory other = (QxFactory) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (factoryCode == null) {
			if (other.factoryCode != null)
				return false;
		} else if (!factoryCode.equals(other.factoryCode))
			return false;
		if (factoryName == null) {
			if (other.factoryName != null)
				return false;
		} else if (!factoryName.equals(other.factoryName))
			return false;
		return true;
	}

	public Integer getFactoryType() {
		return factoryType;
	}

	public QxFactory setFactoryType(Integer factoryType) {
		this.factoryType = factoryType;
		return this;
	}

	public String getResolveAddress() {
		return resolveAddress;
	}

	public QxFactory setResolveAddress(String resolveAddress) {
		this.resolveAddress = resolveAddress;
		return this;
	}
}