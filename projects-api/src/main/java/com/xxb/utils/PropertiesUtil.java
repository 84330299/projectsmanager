package com.xxb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Properties props;
    private URI uri;

    public PropertiesUtil(String fileName) {
        this.readProperties(fileName);
    }

    private void readProperties(String fileName) {
        try {
            this.props = new Properties();
            InputStream fis = this.getClass().getResourceAsStream(fileName);
            this.props.load(fis);
            this.uri = this.getClass().getResource(fileName).toURI();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public String getProperty(String key) {
        String res = this.props.getProperty(key);
        logger.debug("读取：" + key + " ===> " + res);
        return res;
    }

    public Map<String, String> getAllProperty() {
        Map<String, String> map = new HashMap();
        Enumeration enu = this.props.propertyNames();

        while(enu.hasMoreElements()) {
            String key = (String)enu.nextElement();
            String value = this.props.getProperty(key);
            map.put(key, value);
        }

        return map;
    }

    public void printProperties() {
        this.props.list(System.out);
    }

    public void writeProperties(String key, String value) {
        logger.debug("写入： " + key + " ===> " + value);

        try {
            OutputStream fos = new FileOutputStream(new File(this.uri));
            this.props.setProperty(key, value);
            this.props.store(fos, (String)null);
        } catch (Exception var4) {
            logger.debug("写入： " + key + " ===> " + value + " 失败！");
            var4.printStackTrace();
        }

    }
}