package com.wsh;


import org.springframework.boot.context.properties.ConfigurationProperties;

// 在配置文件中通过:demo.msg=xxx来配置msg
// 若不是这,则默认为:我是DEMO
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

    public static final String MSG = "我是DEMO";

    private String msg = MSG;

    public static String getMSG(){
        return MSG;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
