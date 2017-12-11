package com.lanou3g.study;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.print.Doc;
import java.io.File;
import java.util.*;

public class Main2 {
    static SAXReader reader = new SAXReader();
    static Document read = null;
    public static void main(String[] args) throws DocumentException {
        read = reader.read(new File("src/data.xml"));
//        List<Student> students = lisiElements();

//        System.out.println(Arrays.toString(students.toArray()));
        Map<String, Student> stringStudentMap = lisiElements();

        for (Map.Entry<String, Student> stringStudentEntry : stringStudentMap.entrySet()) {
            System.out.println(stringStudentEntry.getKey() + stringStudentEntry.getValue());
        }




//        allElements(read.getRootElement());



    }
    public static void allElements(Element e){

        List<Attribute> attributes = e.attributes();
        for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            System.out.println("属性名为:" + attribute.getName() + "\n属性值为:" + attribute.getValue());
        }
        String text = e.getText();
        System.out.println("当前元素的文本为:" + text);
        List<Element> elements = e.elements();
        // 如果没有子标签,则结束这个方法
        if (elements.size() == 0){
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            // 获得第i个子标签
            Element element = elements.get(i);
            //扔到allEles这个方法中
            allElements(element);
        }




    }

    private static Map<String,Student> lisiElements() throws DocumentException {

        Element rootElement = read.getRootElement();
        List<Element> student = rootElement.elements("student");

        List<Student> studentData = new ArrayList<>();
        Map<String,Student> studentMap = new HashMap<>();


        for (int i = 0; i < student.size(); i++) {
            Element element = student.get(i);
            Student stu = new Student();
            Attribute name = element.attribute("name");
            // 获得name属性的值
            String value = name.getValue();
            // 设置到stu这个对象中
            stu.setName(value);

            Element score = element.element("score");
            // 拿到score标签中的文本
            String text = score.getText();
            // "1001" == > 1001
            stu.setScore(Integer.parseInt(text));
            //把数据健全的学生对象,装进集合中
            studentData.add(stu);
            studentMap.put(value,stu);
            System.out.println("学生的名为:"+value+"\n学生的分数为:"+text);
        }
//        return studentData;
        return studentMap;
    }



}
