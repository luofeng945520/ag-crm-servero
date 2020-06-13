package com.cn.ag.generator;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * @ClassName:MyTypeConvert
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/6/13 22:52
 */
public class MyTypeConvert implements ITypeConvert {

    @Override
    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        String t = fieldType.toLowerCase();
        if (t.contains("char")) {
            return MyColumnType.VARCHAR;
        } else if (t.contains("bigint")) {
            return MyColumnType.BIGINT;
        } else if (t.contains("tinyint(1)")) {
            return MyColumnType.BOOLEAN;
        } else if (t.contains("int")) {
            return MyColumnType.INTEGER;
        } else if (t.contains("text")) {
            return MyColumnType.VARCHAR;
        } else if (t.contains("bit")) {
            return MyColumnType.BOOLEAN;
        } else if (t.contains("decimal")) {
            return MyColumnType.BIG_DECIMAL;
        } else if (t.contains("clob")) {
            return MyColumnType.CLOB;
        } else if (t.contains("blob")) {
            return MyColumnType.BLOB;
        } else if (t.contains("binary")) {
            return MyColumnType.BYTE_ARRAY;
        } else if (t.contains("float")) {
            return MyColumnType.FLOAT;
        } else if (t.contains("double")) {
            return MyColumnType.DOUBLE;
        } else if (t.contains("json") || t.contains("enum")) {
            return MyColumnType.VARCHAR;
        } else if (t.contains("date") || t.contains("time") || t.contains("year")) {
            switch (globalConfig.getDateType()) {
                case ONLY_DATE:
                    return MyColumnType.DATE;
                case SQL_PACK:
                    switch (t) {
                        case "date":
                            return MyColumnType.DATE_SQL;
                        case "time":
                            return MyColumnType.TIME;
                        case "year":
                            return MyColumnType.DATE_SQL;
                        default:
                            return MyColumnType.TIMESTAMP;
                    }
                case TIME_PACK:
                    switch (t) {
                        case "date":
                            return MyColumnType.LOCAL_DATE;
                        case "time":
                            return MyColumnType.LOCAL_TIME;
                        case "year":
                            return MyColumnType.YEAR;
                        default:
                            return MyColumnType.LOCAL_DATE_TIME;
                    }
            }
        }
        return MyColumnType.VARCHAR;
    }
}
