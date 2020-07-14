package com.cn.ag.services.qx.impl;

import com.cn.ag.data.domain.sd.qx.ListField;
import com.cn.ag.data.dao.interf.qx.ListFieldMapper;
import com.cn.ag.services.qx.ListFieldService;
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
@Service("listFieldServiceImpl")
public class ListFieldServiceImpl implements ListFieldService {

    @Autowired
    @Qualifier("listFieldMapperImpl")
    private ListFieldMapper listFieldMapper;


    /**
     * 获取单个对象
     */
    public ListField get(String id) {
        return listFieldMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(ListField listField) {
        return listFieldMapper.updateByPrimaryKeySelective(listField) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(String id) {
        return listFieldMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<ListField> list(Map<String, Object> map) {
        return listFieldMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(ListField listField) {
        return listFieldMapper.insertSelective(listField) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<ListField> listFieldList) {
        //一次全部插入 若是数据过多 需要重写
        return listFieldMapper.insertBatch(listFieldList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
