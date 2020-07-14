package com.cn.ag.services.qx.impl;

import com.cn.ag.data.domain.sd.qx.Dict;
import com.cn.ag.data.dao.interf.qx.DictMapper;
import com.cn.ag.services.qx.DictService;
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
@Service("dictServiceImpl")
public class DictServiceImpl implements DictService {

    @Autowired
    @Qualifier("dictMapperImpl")
    private DictMapper dictMapper;


    /**
     * 获取单个对象
     */
    public Dict get(Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(Dict dict) {
        return dictMapper.updateByPrimaryKeySelective(dict) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(Long id) {
        return dictMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<Dict> list(Map<String, Object> map) {
        return dictMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(Dict dict) {
        return dictMapper.insertSelective(dict) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<Dict> dictList) {
        //一次全部插入 若是数据过多 需要重写
        return dictMapper.insertBatch(dictList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
