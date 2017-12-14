package com.wsh.must;

import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetGameTopTen {

    public static void main(String[] args) {
        try {
            getTop();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void getTop() throws IOException, DocumentException {
//        SAXReader saxReader = new SAXReader();
//        Document read = saxReader.read(new URL("http://192.168.20.221:8080/day16/ten"));
//        Element rootElement = read.getRootElement();

        URL url = new URL("http://192.168.20.221:8080/day16/ten");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String result = new String(bytes,0,read);
//
//        System.out.println(result);
        Map map = new HashMap();
        map.put("result",GameTopTen.ResultBean.class);
        JSONObject jsonObject = JSONObject.fromObject(result);
        GameTopTen gameTopTen = (GameTopTen)JSONObject.toBean(jsonObject, GameTopTen.class,map);
        List<GameTopTen.ResultBean> tenResult = gameTopTen.getResult();
        for (GameTopTen.ResultBean resultBean : tenResult) {
            System.out.println(resultBean.getNickname() + resultBean.getScore());
        }

//        byte b[]=out.toByteArray( );
//        String result = new String(b, "utf-8");
//        Map map = new HashMap();
//        map.put("result",Weather.ResultBean.class);
//        JSONObject jsonObject = JSONObject.fromObject(result);
//        Weather weather =(Weather) JSONObject.toBean(jsonObject, Weather.class,map);
//        List<Weather.ResultBean> resultBeans = weather.getResult();
//        for (Weather.ResultBean resultBean : resultBeans) {
//            System.out.println("日期:" + resultBean.getDays() + "\n星期:" + resultBean.getWeek() +
//                    "\n温度:"+resultBean.getTemperature()+"\n天气:"+resultBean.getWeather());
//        }



    }
}
