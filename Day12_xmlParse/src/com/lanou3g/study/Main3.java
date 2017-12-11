package com.lanou3g.study;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;


public class Main3 {

    public static void main(String[] args) throws IOException {

        // 创建一个Document对象
        Document document = DocumentHelper.createDocument();

        // 在document对象中,添加一个元素
        // 元素的名字叫students
        // 并且,将添加的这个元素
        // 返回给element这个引用
        Element element = document.addElement("students");

        element.addText("我是一坨学生");
        element.addAttribute("name","大胖子");

        Element student = element.addElement("student");

        student.addText("我是一团学生");
        student.addAttribute("name" ,"小胖子");

        Element score = student.addElement("score");

        score.addText("231");
        score.addAttribute("score","分数");

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");


        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/output.xml"),outputFormat);

        xmlWriter.write(document);

        // 将这个工具关闭,并且把工具中的内容写进目标文件中
        xmlWriter.close();

    }
}
