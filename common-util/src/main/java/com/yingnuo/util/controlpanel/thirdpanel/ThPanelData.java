package com.yingnuo.util.controlpanel.thirdpanel;


import com.yingnuo.util.weixin.cgi.BaseDO;

/**
 * @author ssh
 * 第三代控制板数据交互结构体
 * Created by Administrator on 2018/1/8.
 */
public class ThPanelData extends BaseDO {

    private String type;
    private String datas;
    private int length;

    public ThPanelData() {
    }

    public ThPanelData(String datas) {
        this.datas = datas;
        this.length = datas.length();
        this.type = "String".equals(datas.getClass().toString().substring(16)) ? "1" : "0";
    }

    public ThPanelData(String type, String datas, int length) {
        this.type = type;
        this.datas = datas;
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
        this.length = datas.length();
        this.type = "String".equals(datas.getClass().toString().substring(16)) ? "1" : "0";
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
