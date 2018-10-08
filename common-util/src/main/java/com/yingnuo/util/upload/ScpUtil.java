/*
package com.wanhuchina.common.util.upload;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SCPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

*/
/**
 * @Author: Diviner
 * @CreateDate： 2018/5/4 15:03
 * @PackageName: com.wanhuchina.common.util.upload
 * @Desc: 使用SCPClient实现文件的上传
 **//*

@Component
public class ScpUtil {

    private static final Logger logger = LoggerFactory.getLogger(ScpUtil.class);
    private static String FTP_ADDRESS = PropertiesUtil.getProperty("FTP_ADDRESS");
    private static int FTP_PORT = Integer.parseInt(Objects.requireNonNull(PropertiesUtil.getProperty("FTP_PORT")));
    private static String FTP_USERNAME = PropertiesUtil.getProperty("FTP_USERNAME");
    private static String FTP_PASSWORD = PropertiesUtil.getProperty("FTP_PASSWORD");
    private static Connection connection = new Connection(FTP_ADDRESS, FTP_PORT);


    */
/**
     * 用户认证
     *
     * @param user     登录用户名
     * @param password 登录密码
     * @return 认证是否成功
     *//*

    private static boolean isAuthoredWithPassword(String user, String password) {
        try {
            return connection.authenticateWithPassword(user, password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    */
/**
     * 判断是不是用户密码登陆
     * 如果不是 直接异常
     *//*

    private static boolean isAuth() {
        try {
            return isAuthoredWithPassword(FTP_USERNAME, FTP_PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("账号密码 错误");
        }
    }

    */
/**
     * 从服务器拿文件
     *
     * @param remoteFile 远程文件地址
     * @param path       文件路径存放
     *//*

    public static void getFile(String remoteFile, String path) {
        try {
            connection.connect();
            boolean isAuthored = isAuth();
            if (isAuthored) {
                System.out.println("认证成功!");
                SCPClient scpClient = connection.createSCPClient();
                scpClient.get(remoteFile, path);
            } else {
                System.out.println("认证失败!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    */
/**
     * 推送文件
     *
     * @param localFile             本地文件地址
     * @param remoteTargetDirectory 远程目标地址
     *//*

    public static String putFile(String localFile, String remoteTargetDirectory) {
        String RESULT_PATH = remoteTargetDirectory.substring(13);
        String result = "";
        try {
            File file = new File(localFile);
            connection.connect();
            boolean isAuthored = isAuth();
            if (isAuthored) {
                SCPClient scpClient = connection.createSCPClient();
                logger.info("开始put 文件------------");
                logger.info("file size : " + file.length());
                if (file.length() <= 0) {
                    return result;
                }
                scpClient.put(localFile, remoteTargetDirectory, "0777");
                logger.info("结束put 文件------------");
                result = "http://" + FTP_ADDRESS + RESULT_PATH + "/" + file.getName();
            } else {
                logger.error("认证失败!");
            }
        } catch (Exception ex) {
            logger.error("文件上传失败...." + ex);
        } finally {
            connection.close();
        }
        return result;
    }

}
*/
