package com.cn.ag.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.cn.ag.generator.config.MyTypeConvert;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;

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
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/ag_sd_test?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useNewIO=true&useSSL=true";
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
     *
     */
    public static final String PASSWORD = "abc-123";
    /**
     * 表前缀
     */
    public static final String TABLE_PREFIX = "ag_";
    /**
     * 是否需要XML实现基础方法
     */
    public static final boolean NEED_XML = false;

    /**
     * 父包名
     */
    public static final String PARENT_PATH = "com.rhineetam.ag";
    /**
     * 实体类
     */
    public static final String DOMAIN_PATH = "entity";
    /**
     * Mapper接口
     */
    public static final String MAPPER_PATH = "mapper";
    /**
     * MapperImpl
     */
    public static final String MAPPER_IMPL_PATH = "mapper.impl";
    /**
     * MapperXML
     */
    public static final String MAPPER_XML_PATH = "mapper";
    /**
     * Service接口
     */
    public static final String SERVICE_PATH = "service";
    /**
     * Service实现类
     */
    public static final String SERVICE_IMPL_PATH = "service.impl";
    /**
     * Controller
     */
    public static final String CONTROL_PATH = "controller";

    /**
     * 实体类 文件模板
     */
    public static final String DOMAIN_TEMPLATE_PATH = "templates/domain.java";
    /**
     * Mapper接口 文件模板
     */
    public static final String MAPPER_TEMPLATE_PATH = "templates/mapper.java";
    /**
     * MapperImpl 文件模板
     */
    public static final String MAPPER_IMPL_TEMPLATE_PATH = "templates/mapperImpl.java.ftl";
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
        userDir = "/Users/luofeng/Desktop/";// + PROJECT_DIR
//        userDir += PROJECT_DIR;
        generator(userDir);

    }

    /**
     * @Description: 生成器
     * @Param [dir]
     * @Return void
     * @throws
     * 2020/6/12 0:42
     * @Author milk
     */
    public static void generator(String dir) {
        //代码生成器
        AutoGenerator generator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //设置文件输出目录
        globalConfig.setOutputDir(dir)
                //覆盖文件
                .setFileOverride(true)
                //作者
                .setAuthor("milk")
                //是否打开输出目录
                .setOpen(false)
                //开启 BaseResultMap
                .setBaseResultMap(true)
                //开启 BaseColumnList
                .setBaseColumnList(true)
                //设置Service层名称
                .setServiceName("%sService")
                //继承Mybatis plus 的Model类
                .setActiveRecord(false)
                //开启Swagger2  仅限controller
                .setSwagger2(true)
                //设置ServiceImpl层名称
                .setServiceImplName("%sServiceImpl");
        generator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig sourceConfig = new DataSourceConfig();
        //设置数据库类型
        sourceConfig.setDbType(DbType.MYSQL)
                //设置数据库
                .setUrl(URL)
                .setDriverName(DRIVER_NAME)
                .setUsername(USERNAME)
                .setPassword(PASSWORD)
                //设置自己的类型转换
                .setTypeConvert(new MyTypeConvert());
        generator.setDataSource(sourceConfig);

        //配置 包路径
        PackageConfig packageConfig = new PackageConfig();
        //父包名
        packageConfig.setParent(PARENT_PATH)
                //实体类 包路径
                .setEntity(DOMAIN_PATH)
                //Mapper接口 包路径
                .setMapper(MAPPER_PATH)
                //MapperXML 包路径
                .setXml(MAPPER_XML_PATH)
                //Service接口 包路径
                .setService(SERVICE_PATH)
                //Service实现类 包路径
                .setServiceImpl(SERVICE_IMPL_PATH)
                //Controller 包路径
                .setController(CONTROL_PATH);
//        packageConfig.setPathInfo();
        generator.setPackageInfo(packageConfig);

        //配置自定义代码模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(DOMAIN_TEMPLATE_PATH)
                .setMapper(MAPPER_TEMPLATE_PATH)
                .setXml(MAPPER_XML_TEMPLATE_PATH)
                .setService(SERVICE_TEMPLATE_PATH)
                .setServiceImpl(SERVICE_IMPL_TEMPLATE_PATH)
                .setController(CONTROL_TEMPLATE_PATH);
        generator.setTemplate(templateConfig);

        //配置 策略
        StrategyConfig strategy = new StrategyConfig();
        //表名 下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel)
                //字段名 下划线转驼峰命名
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //设置父类类型
                //        strategy.setSuper...Class()
                //使用 lombok 插件
                .setEntityLombokModel(false)
                //Controller层 使用RestController注解
                .setRestControllerStyle(false)
                //需要包含的表名
                .setInclude(scanner("表名").split(","))
                //需要排除的表名
                //        strategy.setExclude();
                //驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                //表名前缀  生成类文件会去掉表前缀
//                .setTablePrefix(TABLE_PREFIX)
                //设置实体类的父类
                .setSuperEntityClass("");
        generator.setStrategy(strategy);



        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("extendMapper", "BaseMapper");
                map.put("String", "String");
                map.put("prefix", "#{");
                map.put("suffix", "}");
                map.put("whereParam", "${whereParam}");
                map.put("startIndex", "${startIndex}");
                map.put("endIndex", "${endIndex}");
                map.put("jointable", "${jointable}");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                map.put("date", dateTimeFormatter.format(LocalDateTime.now()));
                //mapperImpl 包路径
                map.put("MapperImpl", PARENT_PATH + "." + MAPPER_IMPL_PATH);
                //mapperImpl 父类
                map.put("superMapperImpl", true);
                //mapperImpl
                map.put("superMapperImplPkg", "com.cn.ag.data.dao.MapperHelper;");
                //继承 mybatis plus 的类
                map.put("extend", true);
                //是否需要XML实现基础方法
                map.put("needXML", NEED_XML);
                this.setMap(map);
            }
        };

        injectionConfig.setFileCreate((configBuilder, fileType, filePath) -> {
            // 全局判断【默认】
            File file = new File(filePath);
            boolean exist = file.exists();
            if (!exist) {
                file.getParentFile().mkdirs();
            }
            return !exist || configBuilder.getGlobalConfig().isFileOverride();
        });

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();

        FileOutConfig mapperImplTemplate = new FileOutConfig(MAPPER_IMPL_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return dir + File.separator + PARENT_PATH.replaceAll("\\.", Matcher.quoteReplacement(File.separator)) +
                        File.separator + MAPPER_IMPL_PATH.replaceAll("\\.", Matcher.quoteReplacement(File.separator)) +
                        File.separator + tableInfo.getMapperName() + "Impl.java";
            }
        };

        focList.add(mapperImplTemplate);
        // 自定义配置会被优先输出
        injectionConfig.setFileOutConfigList(focList);

        generator.setCfg(injectionConfig);

        //设置模板引擎
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        generator.execute();
    }

}
