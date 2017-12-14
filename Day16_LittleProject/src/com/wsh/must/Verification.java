package com.wsh.must;

public class Verification {

    public static final String REGEX_NAME = "^[a-zA-Z]\\w{5,20}$";

    public static final String REGEX_PHONE = "^1[3,4,5,7,8,9]\\d{9}$";

    public static final String REGEX_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    public static final String REGEX_PASSWORD = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,14}";

}
