package com.wsh.constant;
public class Constant {
    public static final String USERDATA_PATH = "src\\com\\wsh\\must\\UserData.xml";
    public static final String XML_ELEMENT_BY_ROOT = "userData";
    public static final String XML_ATTRIBUTE_BY_UD = "name";
    public static final String XML_ELEMENT_BY_UD1 = "userName";
    public static final String XML_ELEMENT_BY_UD2 = "passWord";
    public static final String ENCODING = "UTF-8";
    public static final String REGEX_NAME = "^[a-zA-Z]\\w{5,20}$";
    public static final String REGEX_PHONE = "^1[3,4,5,7,8,9]\\d{9}$";
    public static final String REGEX_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    public static final String REGEX_PASSWORD = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,14}";
    public static final String URL_SITE = "http://192.168.20.221:8080";
    public static final String URL_FIRST = URL_SITE + "/day16/first";
    public static final String URL_TOP_TEN = URL_SITE + "/day16/ten";
    public static final String URL_INSERT = URL_SITE + "/day16/insert";

}
