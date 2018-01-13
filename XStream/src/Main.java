import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        XStream xStream = new XStream(new DomDriver());
        User user1 = new User("李四","123");
        User user2 = new User("张三","123");
        User user3 = new User("王五","123");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Person person = new Person(users);
//        xStream.toXML(person,new FileOutputStream("src/person.xml"));
        Person xml = (Person) xStream.fromXML(new FileInputStream("src/person.xml"));
        System.out.println(Arrays.toString(xml.getUsers().toArray()));
        System.out.println(xml.toString());
        System.out.println(xml.getUsers().toString());
    }
}
