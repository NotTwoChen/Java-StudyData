package com.lanou3g.RLFunction.userdata;

import com.lanou3g.RLFunction.works.Boss;
import com.lanou3g.RLFunction.works.Cooker;
import com.lanou3g.RLFunction.works.Doctor;
import com.lanou3g.RLFunction.works.Worker;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserData {

        private static File file =new File("src/com/lanou3g/RLFunction/userdata/UserData.xml");
        private static FileWriter fileWriter;
        private static SAXReader saxReader ;
        //读取账户信息
        public static Person getPerson(String username) throws DocumentException {
                saxReader = new SAXReader();
                Document read = saxReader.read(file);
                Element rootElement = read.getRootElement();
                List<Element> person = rootElement.elements("person");
                for (int i = 0; i < person.size(); i++) {
                        Element element = person.get(i);
                        Attribute name = element.attribute("name");
                        Element userName = element.element("username");
                        Element passWord = element.element("password");
                        Element work = element.element("work");
                        Person p = null;
                        if (userName.getText().equals(username)) {
                                switch (work.getText()){
                                        case "Worker":
                                                p = new Worker(name.getValue(),userName.getText(),passWord.getText(),work.getText());
                                                break;
                                        case "Doctor":
                                                p = new Doctor(name.getValue(),userName.getText(),passWord.getText(),work.getText());
                                                break;
                                        case "Cooker":
                                                p = new Cooker(name.getValue(),userName.getText(),passWord.getText(),work.getText());
                                                break;
                                        case "Boss":
                                                p = new Boss(name.getValue(),userName.getText(),passWord.getText(),work.getText());
                                                break;
                                }return p;
                        }
                }return null;
        }
        // 创建账户信息
        public static void setPerson(Person p) throws DocumentException, IOException {
                saxReader = new SAXReader();
                Document document = saxReader.read(file);
                Element users = document.getRootElement();
                Element person = users.addElement("person");
                person.addAttribute("name",p.getName());
                Element username = person.addElement("username");
                username.addText(p.getUsername());
                Element password = person.addElement("password");
                password.addText(p.getPassword());
                Element work = person.addElement("work");
                work.addText(p.getWork());
                OutputFormat outputFormat = OutputFormat.createPrettyPrint();
                outputFormat.setEncoding("utf-8");
                fileWriter = new FileWriter("src/com/lanou3g/RLFunction/userdata/UserData.xml");
                XMLWriter xmlWriter = new XMLWriter(fileWriter,outputFormat);
                xmlWriter.write(document);
                xmlWriter.close();
        }
        // 删除账户信息
        public static void removePerson(String userName) throws DocumentException, IOException {
                saxReader = new SAXReader();
                Document read = saxReader.read(file);
                Element rootElement = read.getRootElement();
                List<Element> person = rootElement.elements("person");
                for (Element o : person) {
                        Element username = o.element("username");
                        if (username.getText().equals(userName)){
                                rootElement.remove(o);
                                OutputFormat outputFormat = OutputFormat.createPrettyPrint();
                                outputFormat.setEncoding("utf-8");
                                fileWriter = new FileWriter("src/com/lanou3g/RLFunction/userdata/UserData.xml");
                                XMLWriter xmlWriter = new XMLWriter(fileWriter,outputFormat);
                                xmlWriter.write(read);
                                xmlWriter.close();
                        }
                }
        }
        // 修改账户信息
        public static boolean changePerson(String userName,String change,int choice) throws DocumentException, IOException {
                saxReader = new SAXReader();
                Document read = saxReader.read(file);
                Element rootElement = read.getRootElement();
                List<Element> person = rootElement.elements("person");
                for (Element element : person) {
                        Element username = element.element("username");
                        if (userName.equals(username.getText())){
                                if (choice == 1) {
                                        element.remove(element.element("password"));
                                        Element password = element.addElement("password");
                                        password.addText(change);
                                        System.out.println("---密码修改成功!!!---");

                                }
                                if (choice == 2){
                                        element.remove(element.attribute("name"));
                                        element.addAttribute("name",change);
                                        System.out.println("---用户姓名修改成功!!!---");
                                }
                                if (choice == 3){
                                        element.remove(element.element("work"));
                                        Element work = element.addElement("work");
                                        work.addText(change);
                                        System.out.println("---用户职业修改成功!!!---");

                                }
                                OutputFormat outputFormat = OutputFormat.createPrettyPrint();
                                outputFormat.setEncoding("utf-8");
                                fileWriter = new FileWriter("src/com/lanou3g/RLFunction/userdata/UserData.xml");
                                XMLWriter xmlWriter = new XMLWriter(fileWriter,outputFormat);
                                xmlWriter.write(read);
                                xmlWriter.close();
                                if (choice > 3 || choice < 1){
                                        System.out.println("---选择错误!!!---");
                                        return false;
                                }else {
                                        return true;
                                }
                        }
                }
                return false;

        }
}







