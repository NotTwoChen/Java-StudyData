package com.wsh.must;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class LogInBySource {

    public static UserData logIn (String name) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src\\com\\wsh\\must\\UserData.xml"));
        Element rootElement = read.getRootElement();
        List <Element> elements = rootElement.elements();
        for (Element element : elements) {
            if (element.element("userName").getText().equals(name)){
                Element userName = element.element("userName");
                Element passWord = element.element("passWord");
                Attribute attribute = element.attribute("name");
                return new UserData(attribute.getValue(),userName.getText(),passWord.getText());
            }
        }return null;
    }
}
