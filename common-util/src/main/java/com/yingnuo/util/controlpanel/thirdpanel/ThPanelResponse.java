package com.yingnuo.util.controlpanel.thirdpanel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yingnuo.util.weixin.cgi.BaseDO;

import java.util.ArrayList;

/**
 * @author ssh
 * 第三代控制板数据交互结构体
 * Created by Administrator on 2018/1/8.
 */
public class ThPanelResponse extends BaseDO {
    /**
     * uuid
     */
    private String uuid ;
    /**
     * 结果编码
     */
    private int code;
    /**
     * 指令名称 功能
     */
    private String operation;
    /**
     * 用户id
     */
    private String userid;
    /**
     * 设备id 主控板id
     */
    private String deviceid;
    /**
     * 集合参数的数量
     */
    private int number;
    /**
     * 备注信息
     */
    private String message;
    /**
     * 是否错误
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String iserror;
    /**
     *
     */
    private ArrayList<ThPanelData> data;


    public ThPanelResponse() {
    }

    public ThPanelResponse(int code,String uuid,String message){
        this.code=code;
        this.uuid=uuid;
        this.message=message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIserror() {
        return iserror;
    }

    public void setIserror(String iserror) {
        this.iserror = iserror;
    }

    public ArrayList<ThPanelData> getData() {
        return data;
    }

    public void setData(ArrayList<ThPanelData> data) {
        this.data = data;
        this.number = data.size();
    }
}
