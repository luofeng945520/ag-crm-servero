package com.cn.ag.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName:CodeGenerator
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/6/11 13:11
 */
public class CodeGenerator {

    /**
     * 项目路径
     */
    public static final String PROJECT_DIR = "/src/main/java";
    /**
     * 数据库 URL
     */
    public static final String URL = "jdbc:mysql://192.168.200.27:3306/sd_test?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useNewIO=true&useSSL=true";
    /**
     * 数据库驱动
     */
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    /**
     * 数据库 账号
     */
    public static final String USERNAME = "root";
    /**
     * 数据库 密码
     */
    public static final String PASSWORD = "abc-123";

    public static final String TABLE_PREFIX = "ag_";


    /**
     * 父包名
     */
    public static final String PARENT_PATH = "com.cn.ag";
    /**
     * 实体类
     */
    public static final String DOMAIN_PATH = "data.domain.sd";
    /**
     * Mapper接口
     */
    public static final String MAPPER_PATH = "data.dao.interf";
    /**
     * MapperXML
     */
    public static final String MAPPER_XML_PATH = "data.dao.xml";
    /**
     * Service接口
     */
    public static final String SERVICE_PATH = "services.order";
    /**
     * Service实现类
     */
    public static final String SERVICE_IMPL_PATH = "services.order.impl";
    /**
     * Controller
     */
    public static final String CONTROL_PATH = "controller.order";

    /**
     * 实体类 文件模板
     */
    public static final String DOMAIN_TEMPLATE_PATH = "templates/domain.java";
    /**
     * Mapper接口 文件模板
     */
    public static final String MAPPER_TEMPLATE_PATH = "templates/mapper.java";
    /**
     * MapperXML 文件模板
     */
    public static final String MAPPER_XML_TEMPLATE_PATH = "templates/mapper.xml";
    /**
     * Service接口 文件模板
     */
    public static final String SERVICE_TEMPLATE_PATH = "templates/service.java";
    /**
     * Service实现类 文件模板
     */
    public static final String SERVICE_IMPL_TEMPLATE_PATH = "templates/serviceImpl.java";
    /**
     * Controller 文件模板
     */
    public static final String CONTROL_TEMPLATE_PATH = "templates/controller.java";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        System.out.println("项目所处目录：" + userDir);
        userDir = "G:/";
        //代码生成器
        AutoGenerator generator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //设置文件输出目录
        globalConfig.setOutputDir(userDir + PROJECT_DIR);
        //作者
        globalConfig.setAuthor("milk");
        //是否打开输出目录
        globalConfig.setOpen(false);
        //开启 BaseResultMap
        globalConfig.setBaseResultMap(true);
        //开启 BaseColumnList
        globalConfig.setBaseColumnList(true);
        generator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig sourceConfig = new DataSourceConfig();
        //设置数据库类型
        sourceConfig.setDbType(DbType.MYSQL);
        //设置数据库
        sourceConfig.setUrl(URL);
        sourceConfig.setDriverName(DRIVER_NAME);
        sourceConfig.setUsername(USERNAME);
        sourceConfig.setPassword(PASSWORD);
        generator.setDataSource(sourceConfig);

        //配置 包路径
        PackageConfig packageConfig = new PackageConfig();
        //父包名
        packageConfig.setParent(PARENT_PATH);
        //实体类 包路径
        packageConfig.setEntity(DOMAIN_PATH);
        //Mapper接口 包路径
        packageConfig.setMapper(MAPPER_PATH);
        //MapperXML 包路径
        packageConfig.setXml(MAPPER_XML_PATH);
        //Service接口 包路径
        packageConfig.setService(SERVICE_PATH);
        //Service实现类 包路径
        packageConfig.setServiceImpl(SERVICE_IMPL_PATH);
        //Controller 包路径
        packageConfig.setController(CONTROL_PATH);
//        packageConfig.setPathInfo();
        generator.setPackageInfo(packageConfig);

        //配置自定义代码模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(DOMAIN_TEMPLATE_PATH);
        templateConfig.setMapper(MAPPER_TEMPLATE_PATH);
        templateConfig.setXml(MAPPER_XML_TEMPLATE_PATH);
        templateConfig.setService(SERVICE_TEMPLATE_PATH);
        templateConfig.setServiceImpl(SERVICE_IMPL_TEMPLATE_PATH);
        templateConfig.setController(CONTROL_TEMPLATE_PATH);
        generator.setTemplate(templateConfig);

        //配置 策略
        StrategyConfig strategy = new StrategyConfig();
        //表名 下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段名 下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //设置父类类型
//        strategy.setSuper...Class()
        //使用 lombok 插件
        strategy.setEntityLombokModel(false);
        //Controller层 使用RestController注解
        strategy.setRestControllerStyle(false);
        //需要包含的表名
        strategy.setInclude(scanner("表名").split(","));
        //需要排除的表名
//        strategy.setExclude();
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //表名前缀  生成类文件会去掉表前缀
        strategy.setTablePrefix(TABLE_PREFIX);
        generator.setStrategy(strategy);



        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("z", "字符串");
                map.put("x", true);
                map.put("c", 2);
                this.setMap(map);
            }
        };
        generator.setCfg(injectionConfig);

        //设置模板引擎
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        generator.execute();


    }


}
