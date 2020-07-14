package com.cn.ag.services.qx.impl;

import com.cn.ag.data.domain.sd.qx.ResourceType;
import com.cn.ag.data.dao.interf.qx.ResourceTypeMapper;
import com.cn.ag.services.qx.ResourceTypeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Service("resourceTypeServiceImpl")
public class ResourceTypeServiceImpl implements ResourceTypeService {

    @Autowired
    @Qualifier("resourceTypeMapperImpl")
    private ResourceTypeMapper resourceTypeMapper;


    /**
     * 获取单个对象
     */
    public ResourceType get(Integer id) {
        return resourceTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(ResourceType resourceType) {
        return resourceTypeMapper.updateByPrimaryKeySelective(resourceType) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(Integer id) {
        return resourceTypeMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<ResourceType> list(Map<String, Object> map) {
        return resourceTypeMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(ResourceType resourceType) {
        return resourceTypeMapper.insertSelective(resourceType) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<ResourceType> resourceTypeList) {
        //一次全部插入 若是数据过多 需要重写
        return resourceTypeMapper.insertBatch(resourceTypeList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
