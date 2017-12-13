package com.wsh.must;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class LogInBySource {

    public static void logIn (String name) throws DocumentException {

        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src\\com\\wsh\\must\\UserData.xml"));
        Element rootElement = read.getRootElement();
        List <Element> elements = rootElement.elements();
        

    }

}
