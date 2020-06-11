package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.QxFactory;

import java.util.List;
import java.util.Map;

public interface QxFactoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(QxFactory record);

    int insertSelective(QxFactory record);

    QxFactory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(QxFactory record);

    int updateByPrimaryKey(QxFactory record);

    List<QxFactory> selectAll();

    List<QxFactory> conditionSelect(Map<String, Object> map);

    int conditionSelectNum(Map<String, Object> map);
}