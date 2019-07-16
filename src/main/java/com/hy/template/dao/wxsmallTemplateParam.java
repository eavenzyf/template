package com.hy.template.dao;

/**
 * @Classname wxsmallTemplateParam
 * @Description TODO
 * @Date 2019/7/16 11:21
 * @Created by Eaven
 */
public class wxsmallTemplateParam {
    // 参数名称
    private String name;
    // 参数值
    private String value;
    // 颜色  废弃了哎。。。。。。。。。。。。。。。。。。。
    private String color;

    public wxsmallTemplateParam(String name, String value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public wxsmallTemplateParam(String name, String value) {
        this.name = name;
        this.value = value;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
