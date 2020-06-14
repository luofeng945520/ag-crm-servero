package com.cn.ag.data.dao.interf;

import com.cn.ag.data.domain.sd.Resources;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-06-14 16:52:25
 */
public interface ResourcesMapper {

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Resources record);

    Resources selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resources record);

    int insert(Resources record);

    int insertSelective(Resources record);

    int insertBatch(List<Resources> recordList);

    int countSize(Map<String, Object> map);

    List<Resources> selectByPaging(Map<String, Object> map);

    List<Resources> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
