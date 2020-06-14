package com.cn.ag.services.order.impl;

import com.cn.ag.data.domain.sd.Resources;
import com.cn.ag.data.dao.interf.ResourcesMapper;
import com.cn.ag.services.order.ResourcesService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-06-14 16:52:25
 */
@Service("resourcesServiceImpl")
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    @Qualifier("resourcesMapperImpl")
    private ResourcesMapper resourcesMapper;


    /**
     * 获取单个对象
     */
    public Resources get(Long id) {
        return resourcesMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(Resources resources) {
        return resourcesMapper.updateByPrimaryKeySelective(resources) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(Long id) {
        return resourcesMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<Resources> list(Map<String, Object> map) {
        return resourcesMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(Resources resources) {
        return resourcesMapper.insertSelective(resources) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<Resources> resourcesList) {
        //一次全部插入 若是数据过多 需要重写
        return resourcesMapper.insertBatch(resourcesList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
