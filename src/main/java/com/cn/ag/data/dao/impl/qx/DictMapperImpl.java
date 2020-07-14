package com.cn.ag.data.dao.impl.qx;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.qx.Dict;
import com.cn.ag.data.dao.interf.qx.DictMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Repository("dictMapperImpl")
public class DictMapperImpl extends MapperHelper<Dict> implements DictMapper {

    public int deleteByPrimaryKey(Long id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(Dict record) {
        return updateHelper(record);
    }

    public Dict selectByPrimaryKey(Long id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(Dict record) {
        return updateHelper(record);
    }

    public int insert(Dict record) {
        return insertHelper(record);
    }

    public int insertSelective(Dict record) {
        return insertHelper(record);
    }

    public int insertBatch(List<Dict> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<Dict> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<Dict> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
