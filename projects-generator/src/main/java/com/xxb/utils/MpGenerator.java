package com.xxb.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Chen
 * @Date: 2018/7/4 10:09
 */
public class MpGenerator {

    /**
     * @param packagePath 包路径
     * @param savePath    保存路径
     */
    public static void generator(String packagePath, String savePath) {
        String FULL_PATH = savePath + "/" + packagePath + "/";
        String CONTROLLER_PATH = FULL_PATH + "web/controller/";
        String ENTITY_PATH = FULL_PATH + "model/entity/";
        String DTO_PATH = FULL_PATH + "web/dto/";
        String MAPPER_PATH = FULL_PATH + "model/mapper/";
        String MAPPER_XML_PATH = FULL_PATH + "model/mapper/xml/";
        String SERVICE_PATH = FULL_PATH + "model/service/";
        String SERVICE_IMPL_PATH = FULL_PATH + "model/service/impl/";

        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(savePath);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setAuthor("陈亮");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("xuexunbao!@#.");
        dsc.setUrl("jdbc:mysql://47.104.11.3:3306/app-version?characterEncoding=UTF8");
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.xxb");
        pc.setEntity("model.entity");
        pc.setController("com.xxb.web.controller");
        pc.setService("model.service");
        pc.setServiceImpl("model.service.impl");
        pc.setMapper("model.mapper");
        pc.setXml("model.mapper");
        mpg.setPackageInfo(pc);


        //注入自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        //关闭自身模板生成
        TemplateConfig tc = new TemplateConfig();
        tc.setController(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        tc.setEntity(null);
        tc.setMapper(null);
        tc.setXml(null);
        mpg.setTemplate(tc);

        //生成文件
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/template/controller.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return CONTROLLER_PATH + tableInfo.getControllerName() + ".java";
            }
        });

        focList.add(new FileOutConfig("/template/entity.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return ENTITY_PATH + tableInfo.getEntityName() + ".java";
            }
        });

        focList.add(new FileOutConfig("/template/dto.java.vm") {

            @Override
            public String outputFile(TableInfo tableInfo) {
                return DTO_PATH + tableInfo.getEntityName() + "Dto" + ".java";
            }
        });

        focList.add(new FileOutConfig("/template/mapper.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MAPPER_PATH + tableInfo.getMapperName() + ".java";
            }
        });

        focList.add(new FileOutConfig("/template/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MAPPER_XML_PATH + tableInfo.getXmlName() + ".xml";
            }
        });

        focList.add(new FileOutConfig("/template/service.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_PATH + tableInfo.getServiceName() + ".java";
            }
        });

        focList.add(new FileOutConfig("/template/serviceImpl.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return SERVICE_IMPL_PATH + tableInfo.getServiceImplName() + ".java";
            }
        });


        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


        //执行生成操作
        mpg.execute();
    }

}
