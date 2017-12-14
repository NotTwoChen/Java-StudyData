package com.wsh.must;

import com.wsh.constant.Constant;
import com.wsh.util.Ranking;
import com.wsh.util.Telephone;
import com.wsh.util.Weather;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Visit {
    public static void getWeather() throws IOException {
        System.out.println("请输入需要查询的城市:");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        URL u = new URL("http://api.k780.com/?app=weather.future&weaid="+city+"&appkey=30513&sign=b91c1acd58df496d80253490ad9d5221&format=json");
        String result = visit(u);
        Map map = new HashMap();
        map.put("result",Weather.ResultBean.class);
        JSONObject jsonObject = JSONObject.fromObject(result);
        Weather weather =(Weather) JSONObject.toBean(jsonObject, Weather.class,map);
        List<Weather.ResultBean> resultBeans = weather.getResult();
        for (Weather.ResultBean resultBean : resultBeans) {
            System.out.println("日期:" + resultBean.getDays() + "\n星期:" + resultBean.getWeek() +
                    "\n温度:"+resultBean.getTemperature()+"\n天气:"+resultBean.getWeather());
        }
    }

    private static String visit(URL u) throws IOException {
        InputStream in = u.openStream();
        ByteArrayOutputStream out= new ByteArrayOutputStream();
        try {
            byte buf[]= new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        return new String(b, "utf-8");
    }

    public static void getPhone() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的手机号:");
        String phone = scanner.nextLine();
        URL u = new URL("http://api.k780.com/?app=phone.get&phone="+phone+"&appkey=30513&sign=b91c1acd58df496d80253490ad9d5221&format=json");
        String result = visit(u);
        JSONObject jsonObject = JSONObject.fromObject(result);
        Telephone telephoneBelong = (Telephone)JSONObject.toBean(jsonObject, Telephone.class);
        Telephone.ResultBean result1 = telephoneBelong.getResult();
        System.out.println("手机号" + result1.getPhone() + "来自" + result1.getAtt() +
                "\n号码源:" + result1.getOperators());
    }
    public static void getTop() throws IOException, DocumentException {
        URL url = new URL(Constant.URL_TOP_TEN);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String result = new String(bytes,0,read);
        JSONArray jsonArray = JSONArray.fromObject(result);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Ranking ranking = (Ranking)JSONObject.toBean(jsonObject, Ranking.class);
            System.out.println("第"+(i+1)+"位用户名:"+ ranking.getNickname() +",分数为"+ ranking.getScore());
        }
    }
}
