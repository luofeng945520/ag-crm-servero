package com.cn.ag.data.dao.impl.qx;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.qx.Resource;
import com.cn.ag.data.dao.interf.qx.ResourceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Repository("resourceMapperImpl")
public class ResourceMapperImpl extends MapperHelper<Resource> implements ResourceMapper {

    public int deleteByPrimaryKey(Long id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(Resource record) {
        return updateHelper(record);
    }

    public Resource selectByPrimaryKey(Long id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(Resource record) {
        return updateHelper(record);
    }

    public int insert(Resource record) {
        return insertHelper(record);
    }

    public int insertSelective(Resource record) {
        return insertHelper(record);
    }

    public int insertBatch(List<Resource> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<Resource> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<Resource> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
