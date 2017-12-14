package com.wsh.must;

import net.sf.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GetWeather {

    public static void getWeather() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的城市:");
        String city = scanner.nextLine();
        URL u = new URL("http://api.k780.com/?app=weather.future&weaid="+city+"&appkey=30513&sign=b91c1acd58df496d80253490ad9d5221&format=json");
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
        String result = new String(b, "utf-8");
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
}
