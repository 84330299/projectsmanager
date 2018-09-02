package com.xxb.utils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.PutObjectRequest;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 阿里云OSS工具类
 *
 * @author rickliu
 * @since 2017/11/18/13:31
 */
public final class AliOSSUtil {

    /**
     * OSS Bucket名称
     */
    public static final String BUCKET_NAME = "t3-imgs";

    /**
     * rickliu-oss-client Access Key ID
     */
    private static final String ACCESS_KEY_ID = "LTAIHDv9ijSScQi0";

    /**
     * rickliu-oss-client Access Key Secret
     */
    private static final String ACCESS_KEY_SECRET = "alyCLDk547XrQHlvJj80vFFj42QggZ";

    /**
     * OSS EndPoint
     */
    private static final String OSS_ENDPOINT = "http://oss-cn-beijing.aliyuncs.com";

    /**
     * OSS RICHN BUCKET_NAME BASE URL
     */
    private static final String OSS_RICHN_BASE_URL = "http://t3-imgs.oss-cn-beijing.aliyuncs.com";

    /**
     * OSS RICHN BUCKET_NAME IMAGES
     */
    private static final String OSS_RICHN_IMAGES = "images";

    private static final String OSS_RICHN_APPS = "apps";

    /**
     * 创建OSSClient配置信息对象
     *
     * @return ClientConfiguration
     */
    public static ClientConfiguration createOssClientConf() {
        ClientConfiguration conf = new ClientConfiguration();
        // 设置OSSClient使用的最大连接数，默认1024
        conf.setMaxConnections(200);
        // 设置请求超时时间，默认50秒
        conf.setSocketTimeout(10000);
        // 设置失败请求重试次数，默认3次
        conf.setMaxErrorRetry(5);
        return conf;
    }

    /**
     * 根据配置信息创建OssClient对象
     *
     * @param clientConfiguration OSSClient配置信息, 若clientConfiguration为null 则会使用使用默认配置
     * @return OSSClient
     */
    public static OSSClient createOssClient(ClientConfiguration clientConfiguration) {
        return new OSSClient(OSS_ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET, clientConfiguration);
    }

    public static String uploadFile2OSS(File file) {
        if (file == null || !file.isFile()) {
            return null;
        }
        try {
            return uploadFile2OSSByByte(FileUtils.readFileToByteArray(file), file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String uploadFile2OSSByByte(byte[] fileByte, String fileName) {
        OSSClient ossClient = createOssClient(null);

        String fileKey = createOssFileKey(fileName);
        ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileKey, new ByteArrayInputStream(fileByte)));
        ossClient.setObjectAcl(BUCKET_NAME, fileKey, CannedAccessControlList.PublicRead);
        ossClient.shutdown();

        return fileKey;
    }

    public static String uploadImage2OSS(File file) {
        if (file == null || !file.isFile()) {
            return null;
        }
        try {
            return uploadImage2OSSByByte(FileUtils.readFileToByteArray(file), file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 上传图片
     *
     * @param fileByte
     * @param fileName
     * @return
     */
    public static String uploadImage2OSSByByte(byte[] fileByte, String fileName) {
        OSSClient ossClient = createOssClient(null);
        String fileKey = createOssImageKey(fileName);
        ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileKey, new ByteArrayInputStream(fileByte)));
        ossClient.setObjectAcl(BUCKET_NAME, fileKey, CannedAccessControlList.PublicRead);
        ossClient.shutdown();

        return OSS_RICHN_BASE_URL + "/" + fileKey;
    }

    private static String createOssFileKey(String fileName) {
        String fileSuffix = fileName.substring(fileName.indexOf("."));
        return DateUtils.getTimeString("yyyyMM", new Date()) + "/" + DateUtils.getTimeString("yyyyMMddHHmmss", new Date()) + NumberUtil.getRandomString(4) + fileSuffix;
    }

    private static String createOssImageKey(String fileName) {
        return OSS_RICHN_IMAGES + "/" + createOssFileKey(fileName);
    }

    /**
     * 李楚良
     * 上传app
     *
     * @param fileName
     * @return
     */
    private static String createOssAppKey(String fileName) {
        return OSS_RICHN_APPS + "/" + createOssFileKey(fileName);
    }

    /**
     * 上传app
     * @param fileByte
     * @param fileName
     * @return
     */
    public static String uploadApp2OSSByByte(byte[] fileByte, String fileName) {
        OSSClient ossClient = createOssClient(null);
        String fileKey = createOssAppKey(fileName);
        ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileKey, new ByteArrayInputStream(fileByte)));
        ossClient.setObjectAcl(BUCKET_NAME, fileKey, CannedAccessControlList.PublicRead);
        ossClient.shutdown();

        return OSS_RICHN_BASE_URL + "/" + fileKey;
    }

}
