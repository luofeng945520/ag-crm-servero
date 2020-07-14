package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface ResourceMapper {

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int insert(Resource record);

    int insertSelective(Resource record);

    int insertBatch(List<Resource> recordList);

    int countSize(Map<String, Object> map);

    List<Resource> selectByPaging(Map<String, Object> map);

    List<Resource> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
