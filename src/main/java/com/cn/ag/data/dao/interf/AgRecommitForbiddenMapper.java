package com.cn.ag.data.dao.interf;

import com.cn.ag.data.domain.sd.AgRecommitForbidden;

import java.util.List;
import java.util.Map;

public interface AgRecommitForbiddenMapper {
    int deleteByPrimaryKey(String id);

    int insert(AgRecommitForbidden record);

    int insertSelective(AgRecommitForbidden record);

    AgRecommitForbidden selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AgRecommitForbidden record);

    int updateByPrimaryKey(AgRecommitForbidden record);

    List<AgRecommitForbidden> selectAll();

    AgRecommitForbidden selectByRequestAddr(String requestAddr);

    /**
     * 统计条数
     * @param map
     * @return int
     */
    int countSize(Map<String,Object> map);

    /**
     * 分页查询
     * @param map
     * @return int
     */
    List<AgRecommitForbidden> selectByPaging(Map<String,Object> map);
}