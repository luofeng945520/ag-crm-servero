package com.cn.ag.data.domain.sd;

import java.util.List;
import java.util.UUID;

public class AgBaseArea {
	
    private Integer id;
    /**
     * 中文名称
     */
    private String text;
    /**
     * 父级ID
     */
    private Integer pid;
    
    private List<AgBaseArea> agBaseAreaList;


    public List<AgBaseArea> getAgBaseAreaList() {
		return agBaseAreaList;
	}

	public void setAgBaseAreaList(List<AgBaseArea> agBaseAreaList) {
		this.agBaseAreaList = agBaseAreaList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}