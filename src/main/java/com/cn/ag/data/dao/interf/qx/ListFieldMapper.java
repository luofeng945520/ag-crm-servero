package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.ListField;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface ListFieldMapper {

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(ListField record);

    ListField selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ListField record);

    int insert(ListField record);

    int insertSelective(ListField record);

    int insertBatch(List<ListField> recordList);

    int countSize(Map<String, Object> map);

    List<ListField> selectByPaging(Map<String, Object> map);

    List<ListField> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
