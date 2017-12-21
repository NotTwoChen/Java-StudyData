package com.wsh.util;

import com.wsh.exception.PasswordInputErrorException;
import com.wsh.exception.PasswordOrNameInputErrorException;
import com.wsh.exception.SelectErrorException;
import com.wsh.user.UserData;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Visit {

    private static String alterData;

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
        System.out.println("请输入需要查询的号码:");
        Scanner scanner = new Scanner(System.in);
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
        try { byte buf[]= new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read); }
        }finally { if (in != null) {
            in.close(); } }
        byte b[]=out.toByteArray( );
        return new String(b, "utf-8");
    }

    public static void startGame(String name) throws IOException, DocumentException {
        System.out.println("欢迎来到手速游戏测试平台:" +
                "\n请选择游戏难度:" +
                "\nⅠ.简单(10个字符)" +
                "\nⅡ.一般(20个字符)" +
                "\nⅢ.困难(30个字符)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        for (int i = 3; i > 0; i--) {
            try { Thread.sleep(1000);
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("游戏"+i+"秒后开始");
        }System.out.println("游戏正式开始!");
        long timeBegin = new Date().getTime();
        String list = duringGame(choice * 10);
        scanner.nextLine();
        if (scanner.nextLine().equals(list)){
            long timeEnd = new Date().getTime();
            long timeExpend = timeEnd - timeBegin;
            System.out.println("恭喜你!成绩为:" + timeExpend + "毫秒");
            Visit.submitScore(timeExpend,name);
        }else { System.out.println("游戏失败!"); }
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

    public static boolean alterUserdata(UserData userData) throws SQLException, SelectErrorException, PasswordInputErrorException, PasswordOrNameInputErrorException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户密码验证身份:");
        if (userData.getPassWord().equals(scanner.nextLine())){
            System.out.println("验证密码成功!\n请选择需要修改的信息:\nⅠ.用户昵称\nⅡ.用户密码");
            int choice = scanner.nextInt();
            System.out.println("请输入新的用户信息:");
            scanner.nextLine();
            String newData = scanner.nextLine();
            if (Console.isPassword(newData)||Console.isName(newData)){
                return alter(newData,userData.getUserName(),choice);
            }throw new PasswordOrNameInputErrorException();
        }throw new PasswordInputErrorException();
    }

    public static boolean alter(String newData,String username,int choice) throws SelectErrorException {
        Connection connection = Mysql.getConnection();
        if (choice == 1){ alterData = "name"; }
        else if (choice == 2){ alterData = "password"; }
        else { throw new SelectErrorException(); }
        try { PreparedStatement preparedStatement = connection.prepareStatement("UPDATE userdata SET "+alterData+" =? WHERE username=?");
            preparedStatement.setString(1,newData);
            preparedStatement.setString(2,username);
            preparedStatement.execute();
            connection.close();
            System.out.println("修改用户信息成功!");
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public static boolean updateUserdata(UserData userData) throws SelectErrorException, PasswordInputErrorException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户密码验证身份:");
        if (userData.getPassWord().equals(scanner.nextLine())){
            System.out.println("验证密码成功!\n请确认是否注销账户:\nⅠ.是!!!\nⅡ.否!!!");
            if (scanner.nextLine().equals("1")){
                return update(userData.getUserName());
            }throw new SelectErrorException();
        }throw new PasswordInputErrorException();
    }

    public static boolean update(String username){
        Connection connection = Mysql.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userdata WHERE username =?");
            preparedStatement.setString(1,username);
            preparedStatement.execute();
            connection.close();
            System.out.println("注销账户成功!");
            return true;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}
