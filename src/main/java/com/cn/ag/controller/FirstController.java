package com.cn.ag.controller;

import com.cn.ag.annotation.PassToken;
import com.cn.ag.data.dao.interf.AgRecommitForbiddenMapper;
import com.cn.ag.utils.PackageClassesScanner;
import com.cn.ag.utils.UtilParm;
import com.cn.ff.utils.comm.support.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:FirstController
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/5/13 20:50
 */
@Controller
@CrossOrigin(origins = "*")
@ResponseBody
@RequestMapping(value = "/test",produces = "application/json")
@PassToken
public class FirstController {

    Logger logger = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    private AgRecommitForbiddenMapper agRecommitForbiddenMapper;

    @RequestMapping(value = "/tests", produces = "application/json")
    @ResponseBody
    public ResultData tests(HttpServletRequest request, HttpServletResponse response, String param) throws Exception {
        return UtilParm.resultData(0,"fail",FirstController.getMvcRequestMappingList(new String[]{"com.cn.ag.controller"}));
    }

    public static List<String> getMvcRequestMappingList(String[] packagesToScan){
        PackageClassesScanner packageClassesScaner=new PackageClassesScanner(packagesToScan,Controller.class);
        return getMvcRequestMappingList(packageClassesScaner.getClassesNameList());
    }


    public static List<String> getMvcRequestMappingList(List<String> classNameList){

        List<String> retVal=new ArrayList<String>();
        for(String className:classNameList){
            getMvcRequestMappingListByClass(retVal, className);
        }
        return retVal;

    }


    private static void getMvcRequestMappingListByClass(List<String> retVal, String className) {
        try {

            Class<?> cls=Class.forName(className);

            Annotation[] classAnnotations=cls.getAnnotations();//得到类级别的所有注解

            int classRequestMappingCount=0;//类级别的RequestMapping统计

            for (Annotation classAnnotation : classAnnotations) {

                if (classAnnotation instanceof RequestMapping) {

                    classRequestMappingCount = classRequestMappingCount + 1;

                    Method annotationMethod = classAnnotation.getClass().getDeclaredMethod("value", null);

                    String[] annotationValues = (String[]) annotationMethod.invoke(classAnnotation, null);

                    for (String classRequestMappingPath : annotationValues) {
                        getMvcRequestMappingListByMethod(retVal, cls, classRequestMappingPath);
                    }

                }
            }

            if(classRequestMappingCount==0){//如果没有类级别的RequestMapping
                getMvcRequestMappingListByMethod(retVal, cls,"");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private static void getMvcRequestMappingListByMethod(List<String> retVal, Class<?> cls, String classRequestMappingPath) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InvocationTargetException {
        Method[] methods =cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RequestMapping.class)) {
                Annotation methodAnnotation = method.getAnnotation(RequestMapping.class);
                Method   methodAnnotationMethod=methodAnnotation.getClass().getDeclaredMethod("value", null);
                String[] values=(String[]) methodAnnotationMethod.invoke(methodAnnotation, null);
                for (String methodRequestMappingPath : values) {
                    methodRequestMappingPath=classRequestMappingPath.concat(methodRequestMappingPath).replace("*", "").replace("//", "/");
                    retVal.add(methodRequestMappingPath.replaceFirst("/",""));
                }
            }
        }
    }


}
