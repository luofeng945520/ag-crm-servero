package com.cn.ag.data.dao.impl;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.dao.interf.AgRecommitForbiddenMapper;
import com.cn.ag.data.domain.sd.AgRecommitForbidden;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AgRecommitForbiddenMapperImpl
 * @Description: TODO
 * @Author Amber
 * @Date 2019/11/25 11:48
 * @Version 1.0
 */
@Repository
public class AgRecommitForbiddenMapperImpl extends MapperHelper<AgRecommitForbidden> implements AgRecommitForbiddenMapper {

    @Override
    public int deleteByPrimaryKey(String id) {
        return deleteHelper(id);
    }

    @Override
    public int insert(AgRecommitForbidden record) {
        return insertHelper(record);
    }

    @Override
    public int insertSelective(AgRecommitForbidden record) {
        return insertHelper(record);
    }

    @Override
    public AgRecommitForbidden selectByPrimaryKey(String id) {
        return selectOneHelper(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AgRecommitForbidden record) {
        return updateHelper(record);
    }

    @Override
    public int updateByPrimaryKey(AgRecommitForbidden record) {
        return updateHelper(record);
    }

    @Override
    public List<AgRecommitForbidden> selectAll() {
        return selectAllHelper();
    }

    @Override
    public AgRecommitForbidden selectByRequestAddr(String requestAddr) {
        return selectOneHelper(requestAddr);
    }


    @Override
    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    @Override
    public List<AgRecommitForbidden> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }
}
