package com.wsh.must;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SignInToSource {

    public static void signIn ( String userName , String passWord , String name) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src\\com\\wsh\\must\\UserData.xml"));
        Element rootElement = read.getRootElement();
        Element userData = rootElement.addElement("userData");
        userData.addAttribute("name",name);
        Element elementUserName = userData.addElement("userName");
        Element elementPassWord = userData.addElement("passWord");
        elementUserName.addText(userName);
        elementPassWord.addText(passWord);
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src\\com\\wsh\\must\\UserData.xml"),outputFormat);
        xmlWriter.write(read);
        xmlWriter.close();
    }



}
