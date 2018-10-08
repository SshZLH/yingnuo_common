package com.yingnuo.util.weixin.cgi;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * Created by zhangweizhou
 * Email: zhangweizhou@wanhuchina.com
 * Date:  2017/11/1
 * Time:  14:30
 */
public class TemplateData {

    private String touser;
    private String template_id;
    private String url;
    private String topcolor;
    private TemplateItem data;

    public static TemplateData New() {
        return new TemplateData();
    }

    private TemplateData() {
        this.data = new TemplateItem();
    }

    public String getTouser() {
        return touser;
    }

    public TemplateData setTouser(String touser) {
        this.touser = touser;
        return this;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public TemplateData setTemplate_id(String template_id) {
        this.template_id = template_id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public TemplateData setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public TemplateData setTopcolor(String topcolor) {
        this.topcolor = topcolor;
        return this;
    }

    public TemplateItem getData() {
        return data;
    }

    /**
     * 添加内容：不限key
     *
     * @param key
     * @param value
     * @param color
     * @return
     */
    public TemplateData add(String key, String value, String color) {
        data.put(key, new Item(value, color));
        return this;
    }

    /**
     * 添加标题：默认为first
     *
     * @param value
     * @param color
     * @return
     */
    public TemplateData addFirst(String value, String color) {
        data.put("first", new Item(value, color));
        return this;
    }

    /**
     * 添加关键字：默认为keyword1
     *
     * @param value
     * @param color
     * @return
     */
    public TemplateData addKeyword1(String value, String color) {
        data.put("keyword1", new Item(value, color));
        return this;
    }

    /**
     * 添加关键字：默认为keyword2
     *
     * @param value
     * @param color
     * @return
     */
    public TemplateData addKeyword2(String value, String color) {
        data.put("keyword2", new Item(value, color));
        return this;
    }

    /**
     * 添加关键字：默认为keyword3
     *
     * @param value
     * @param color
     * @return
     */
    public TemplateData addKeyword3(String value, String color) {
        data.put("keyword3", new Item(value, color));
        return this;
    }

    /**
     * 添加关键字：默认为keyword4
     *
     * @param value
     * @param color
     * @return
     */
    public TemplateData addKeyword4(String value, String color) {
        data.put("keyword4", new Item(value, color));
        return this;
    }

    /**
     * 添加关键字：默认为keyword5
     *
     * @param value
     * @param color
     * @return
     */
    public TemplateData addKeyword5(String value, String color) {
        data.put("keyword5", new Item(value, color));
        return this;
    }

    /**
     * 添加备注：默认为remark
     *
     * @param value
     * @param color
     * @return
     */
    public TemplateData addRemark(String value, String color) {
        data.put("remark", new Item(value, color));
        return this;
    }


    /**
     * 直接转化成jsonString
     *
     * @return {String}
     */
    public String build() {
        return JSONObject.toJSONString(this);
    }

    public class TemplateItem extends HashMap<String, Item> {

        public TemplateItem() {
        }

        public TemplateItem(String key, Item item) {
            this.put(key, item);
        }
    }

    public class Item {
        private Object value;
        private String color;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Item(Object value, String color) {
            this.value = value;
            this.color = color;
        }
    }
}
