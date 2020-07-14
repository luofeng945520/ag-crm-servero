package com.cn.ag.services.qx.impl;

import com.cn.ag.data.domain.sd.qx.Resource;
import com.cn.ag.data.dao.interf.qx.ResourceMapper;
import com.cn.ag.services.qx.ResourceService;
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
@Service("resourceServiceImpl")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    @Qualifier("resourceMapperImpl")
    private ResourceMapper resourceMapper;


    /**
     * 获取单个对象
     */
    public Resource get(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(Resource resource) {
        return resourceMapper.updateByPrimaryKeySelective(resource) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(Long id) {
        return resourceMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<Resource> list(Map<String, Object> map) {
        return resourceMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(Resource resource) {
        return resourceMapper.insertSelective(resource) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<Resource> resourceList) {
        //一次全部插入 若是数据过多 需要重写
        return resourceMapper.insertBatch(resourceList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
