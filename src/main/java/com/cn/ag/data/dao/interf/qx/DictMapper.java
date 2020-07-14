package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface DictMapper {

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Dict record);

    Dict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dict record);

    int insert(Dict record);

    int insertSelective(Dict record);

    int insertBatch(List<Dict> recordList);

    int countSize(Map<String, Object> map);

    List<Dict> selectByPaging(Map<String, Object> map);

    List<Dict> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
