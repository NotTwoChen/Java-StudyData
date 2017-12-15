package com.wsh.util;

import com.wsh.user.UserData;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class Source {
    static SAXReader saxReader = new SAXReader();

    public static File file = new File(Constant.USERDATA_PATH);

    public static void signIn (String userName,String passWord,String name) throws DocumentException, IOException {
        Document read = saxReader.read(file);
        Element rootElement = read.getRootElement();
        Element userData = rootElement.addElement(Constant.XML_ELEMENT_BY_ROOT);
        userData.addAttribute(Constant.XML_ATTRIBUTE_BY_UD,name);
        Element elementUserName = userData.addElement(Constant.XML_ELEMENT_BY_UD1);
        Element elementPassWord = userData.addElement(Constant.XML_ELEMENT_BY_UD2);
        elementUserName.addText(userName);
        elementPassWord.addText(passWord);
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding(Constant.ENCODING);
        XMLWriter xmlWriter = new XMLWriter(new FileWriter(Constant.USERDATA_PATH),outputFormat);
        xmlWriter.write(read);
        xmlWriter.close();
    }

    public static UserData logIn (String name) throws DocumentException {
        Document read = saxReader.read(file);
        Element rootElement = read.getRootElement();
        List <Element> elements = rootElement.elements();
        for (Element element : elements) {
            if (element.element(Constant.XML_ELEMENT_BY_UD1).getText().equals(name)){
                Element userName = element.element(Constant.XML_ELEMENT_BY_UD1);
                Element passWord = element.element(Constant.XML_ELEMENT_BY_UD2);
                Attribute attribute = element.attribute(Constant.XML_ATTRIBUTE_BY_UD);
                return new UserData(attribute.getValue(),userName.getText(),passWord.getText());
            }
        }return null;
    }
}
