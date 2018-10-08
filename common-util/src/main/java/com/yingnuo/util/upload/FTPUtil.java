package com.yingnuo.util.upload;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Diviner
 * @CreateDate： 2018/5/4 16:04
 * @PackageName: com.wanhuchina.common.util.upload
 * @Desc:   使用FTP实现文件上传
 **/
public class FTPUtil {
    private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");

    private String ip;
    private int port;
    private String user;
    private String pwd;
    private FTPClient ftpClient;


    private FTPUtil(String ip, int port, String user, String pwd) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }


    public static boolean uploadFile(String remotePath, List<File> fileList) {
        FTPUtil ftpUtil = new FTPUtil(ftpIp, 21, ftpUser, ftpPass);
        logger.info("开始连接ftpfu服务器" + ftpUtil.getIp() + " " + ftpUtil.getUser() + " " + ftpUtil.getPort());
        //此处有个异常， 往上抛就可以， 根据逻辑在业务中的具体位置，根据业务逻辑安排 进行try/catch 或者 throws
        boolean result = false;
        try {
            result = ftpUtil.upload(remotePath, fileList);
        } catch (Exception e) {
            logger.error("文件上传异常");
        }
        logger.info("开始连接ftp服务器，结束上传，上传结果：{}", result);
        return result;
    }

    //如果要上传的路径是 /ftpfile 的目录下就得使用remotePath
    private boolean upload(String remotePath, List<File> fileList) {
        boolean uploaded = true;
        FileInputStream fis = null;
        if (connectServer(this.ip, this.port, this.user, this.pwd)) {
            try {
                String[] split = remotePath.split("/");
                for (int i = 0; i < split.length; i++) {
                    //使用FTP用户创建文件夹
                    ftpClient.makeDirectory(split[i]);
                    //切换文件夹
                    ftpClient.changeWorkingDirectory(split[i]);
                }
                logger.info("remotePath : " + remotePath);
                //设置缓冲区
                ftpClient.setBufferSize(1024);
                //设置字符集 utf-8
                ftpClient.setControlEncoding("UTF-8");
                //设置成二进制文件
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //打开本地本动模式
//                ftpClient.enterLocalPassiveMode();
                for (File fileItem : fileList) {
                    fis = new FileInputStream(fileItem);
                    ftpClient.storeFile(fileItem.getName(), fis);
                }

            } catch (IOException e) {
                logger.error("上传文件常", e);
                uploaded = false;
                e.printStackTrace();

            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return uploaded;
    }


    private boolean connectServer(String ip, int port, String user, String pwd) {
        ftpClient = new FTPClient();

        boolean isSuccess = false;
        try {
            ftpClient.connect(ip, port);
            isSuccess = ftpClient.login(user, pwd);
        } catch (IOException e) {
            logger.error("链接FTP服务器异常", e);
            e.printStackTrace();

        }
        return isSuccess;

    }


    private String getIp() {
        return ip;
    }


    private int getPort() {
        return port;
    }


    private String getUser() {
        return user;
    }


}
