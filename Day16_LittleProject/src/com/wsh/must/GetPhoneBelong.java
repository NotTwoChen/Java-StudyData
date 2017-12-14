package com.wsh.must;

import net.sf.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class GetPhoneBelong {

    public static void getPhone() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的手机号:");
        String phone = scanner.nextLine();
        URL u=new URL("http://api.k780.com/?app=phone.get&phone="+phone+"&appkey=30513&sign=b91c1acd58df496d80253490ad9d5221&format=json");
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        String result = new String(b, "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(result);
        Phone phoneBelong = (Phone)JSONObject.toBean(jsonObject, Phone.class);
        Phone.ResultBean result1 = phoneBelong.getResult();
        System.out.println("手机号" + result1.getPhone() + "来自" + result1.getAtt() +
                "\n号码源:" + result1.getOperators());
    }
}
