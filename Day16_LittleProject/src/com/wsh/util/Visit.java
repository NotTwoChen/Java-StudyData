package com.wsh.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Visit {
    public static void weatherFuture() throws IOException {
        System.out.println("请输入需要查询的城市:");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        URL u = new URL(Constant.API_APP+"weather.future&weaid="+city+Constant.API_APPKEY_SIGN);
        String result = dataStore(u);
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

    public static void phoneGet() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的手机号:");
        String phone = scanner.nextLine();
        URL u = new URL(Constant.API_APP+"phone.get&phone="+phone+Constant.API_APPKEY_SIGN);
        String result = dataStore(u);
        JSONObject jsonObject = JSONObject.fromObject(result);
        Telephone telephoneBelong = (Telephone)JSONObject.toBean(jsonObject, Telephone.class);
        Telephone.ResultBean result1 = telephoneBelong.getResult();
        System.out.println("手机号" + result1.getPhone() + "来自" + result1.getAtt() +
                "\n号码源:" + result1.getOperators());
    }

    private static String dataStore(URL u) throws IOException {
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

    public static void startGame(String username) throws IOException, DocumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到手速游戏测试平台:" +
                "\n请选择游戏难度:" +
                "\nⅠ.简单(10个字符)" +
                "\nⅡ.一般(20个字符)" +
                "\nⅢ.困难(30个字符)");
        int choice = scanner.nextInt();
        for (int i = 3; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("游戏"+i+"秒后开始");
        }
        System.out.println("游戏正式开始!");
        long timeBegin = new Date().getTime();
        String list = duringGame(choice * 10);
        scanner.nextLine();
        if (scanner.nextLine().equals(list)){
            long timeEnd = new Date().getTime();
            long timeExpend = timeEnd - timeBegin;
            System.out.println("恭喜你!成绩为:" + timeExpend + "毫秒");
            Visit.submitScore(timeExpend,username);
        }else {
            System.out.println("游戏失败!");
        }
    }

    public static String duringGame(int number) throws IOException, DocumentException {
        String [] gameList = new String[number];
        String list = "";
        for (int i = 0; i < gameList.length; i++) {
            int random = 0;
            if (number == 10){
                random = (int)(Math.random()*36);//10+26
            }else if (number == 20){
                random = (int)(Math.random()*62);//10+26+26
            }else if (number == 30){
                random = (int)(Math.random()*86);//10+26+26+24
            }
            list = list + Constant.BYTES[random];
        }
        System.out.println(list);
        return list;
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

    public static void submitScore(long time, String username) throws IOException, DocumentException {
        URL url = new URL(Constant.URL_INSERT + "?username="+username+"&score="+time);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String result = new String(bytes,0,read,Constant.ENCODING);
        if (result.equals("SUCCESS")){
            System.out.println("成绩已提交成功!");
            getFirst();
        }else{
            System.out.println("成绩提交失败!");
        }
    }

    public static void getFirst() throws IOException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new URL(Constant.URL_FIRST));
        Element rootElement = document.getRootElement();
        String nickname = rootElement.element("nickname").getText();
        String score = rootElement.element("score").getText();
        System.out.println("目前第一名为:"+nickname+",分数为:"+score);
    }
}
