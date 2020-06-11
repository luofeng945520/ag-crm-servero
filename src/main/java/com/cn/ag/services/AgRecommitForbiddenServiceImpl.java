package com.cn.ag.services;

import com.cn.ag.data.dao.interf.AgRecommitForbiddenMapper;
import com.cn.ag.data.domain.sd.AgRecommitForbidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AgRecommitForbiddenServiceImpl
 * @Description: TODO
 * @Author Amber
 * @Date 2019/11/25 14:54
 * @Version 1.0
 */
@Service
public class AgRecommitForbiddenServiceImpl implements AgRecommitForbiddenService {

    @Autowired
    @Qualifier("agRecommitForbiddenMapperImpl")
    private AgRecommitForbiddenMapper agRecommitForbiddenMapper;

    @Override
    public AgRecommitForbidden get(String id) {
        return agRecommitForbiddenMapper.selectByPrimaryKey(id);
    }

    @Override
    public AgRecommitForbidden get(Long id) {
        return null;
    }

    @Override
    public List<AgRecommitForbidden> list(Map<String, Object> map) {
        return agRecommitForbiddenMapper.selectByPaging(map);
    }

    @Override
    public int statisticalNumber(Map<String, Object> map) {
        return agRecommitForbiddenMapper.countSize(map);
    }

    @Override
    public boolean add(AgRecommitForbidden agRecommitForbidden) throws Exception {
        int i = agRecommitForbiddenMapper.insertSelective(agRecommitForbidden);
        return i != 0;
    }

    @Override
    public boolean batchAdd(List<AgRecommitForbidden> list) throws Exception {
        return false;
    }

    @Override
    public boolean modifyByPrimaryKeySelective(AgRecommitForbidden agRecommitForbidden) {
        int i = agRecommitForbiddenMapper.updateByPrimaryKeySelective(agRecommitForbidden);
        return i != 0;
    }

    @Override
    public boolean removeByPrimaryKey(AgRecommitForbidden agRecommitForbidden) {
        int i = agRecommitForbiddenMapper.deleteByPrimaryKey(agRecommitForbidden.getId());
        return i != 0;
    }
}
