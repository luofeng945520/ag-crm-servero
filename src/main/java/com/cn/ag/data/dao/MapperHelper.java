package com.cn.ag.data.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MapperHelper
 * @Description: TODO
 * @Author Amber
 * @Date 2019/11/30 9:24
 * @Version 1.0
 */
@Component
public class MapperHelper<T> extends SqlSessionDaoSupport {


    @Override
    @Autowired
    @Qualifier("sqlSessionFactoryBeanM")
    //如果子类需要其他的数据源则在子类中重写此方法并重新注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }




    private static final String METHOD_SPLIT = ".";

    protected int deleteHelper(Object deleteParam){
        return getSqlSession().delete(getMethodName(),deleteParam);
    }

    protected int updateHelper(Object updateParam){
        return getSqlSession().update(getMethodName(),updateParam);
    }

    protected int insertHelper(Object insertParam){
        return getSqlSession().insert(getMethodName(),insertParam);
    }

    protected T selectOneHelper(Object selectParam){
        return getSqlSession().selectOne(getMethodName(),selectParam);
    }

    protected T selectOneHelper(){
        return getSqlSession().selectOne(getMethodName());
    }

    protected List<T>  selectListHelper(Object selectParam){
        return getSqlSession().selectList(getMethodName(),selectParam);
    }

    protected <E> List<E>  selectListHelperCustom(Object selectParam){
        return getSqlSession().selectList(getMethodName(),selectParam);
    }

    protected List<T> selectAllHelper(){
        return getSqlSession().selectList(getMethodName());
    }

    protected int countHelper(Object countParam){
        return getSqlSession().selectOne(getMethodName(),countParam);
    }

    protected <E> E selectOneHelperCustom(Object selectParam){
        return getSqlSession().selectOne(getMethodName(),selectParam);
    }

    private String getMethodName(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String className = stackTrace[3].getClassName();
        String methodName = stackTrace[3].getMethodName();
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class[] interfaces = null;
        if (clazz != null) {
            interfaces = clazz.getInterfaces();
        }
        if ((interfaces != null ? interfaces.length : 0) ==0){
            throw new NullPointerException("No interfaces implemented");
        }
        Class firstInterface = interfaces[0];

        return firstInterface.getName().concat(METHOD_SPLIT).concat(methodName);
    }




}
