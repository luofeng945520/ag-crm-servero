package com.cn.ag.services;

import com.cn.ag.config.FileConfig;
import com.cn.ag.utils.OkHttp;
import com.cn.ff.utils.BeanConversion.Json.GsonManager;
import com.cn.ff.utils.comm.support.RequestParam;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:UrlService
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/5/20 22:51
 */
@Service
public class RequestInterfaceService {

    @Autowired
    FileConfig fileConfig;

    /**
     * @Description: 获取工单号对应的XML的结构树
     * @param projectid 工单号
     * @Return java.lang.String
     * @throws
     * 2020/5/20 22:53
     * @Author milk
     */
    public String getPanelCombinationFromUrl(String projectid){
        Map<String,Object> map = new HashMap<>();
        JsonObject jo = new JsonObject();
        jo.addProperty("projectid",projectid);
        RequestParam r = new RequestParam();
        r.setValue(jo);
        map.put("param", GsonManager.getIns().objectToJsonStr(r));
        return OkHttp.post(fileConfig.getGetPanelCombination(), map);
    }

}
