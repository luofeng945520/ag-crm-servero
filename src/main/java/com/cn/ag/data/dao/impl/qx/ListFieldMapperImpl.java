package com.cn.ag.data.dao.impl.qx;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.qx.ListField;
import com.cn.ag.data.dao.interf.qx.ListFieldMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Repository("listFieldMapperImpl")
public class ListFieldMapperImpl extends MapperHelper<ListField> implements ListFieldMapper {

    public int deleteByPrimaryKey(String id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(ListField record) {
        return updateHelper(record);
    }

    public ListField selectByPrimaryKey(String id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(ListField record) {
        return updateHelper(record);
    }

    public int insert(ListField record) {
        return insertHelper(record);
    }

    public int insertSelective(ListField record) {
        return insertHelper(record);
    }

    public int insertBatch(List<ListField> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<ListField> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<ListField> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
