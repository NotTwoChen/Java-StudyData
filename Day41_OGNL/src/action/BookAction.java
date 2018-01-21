package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class BookAction extends ActionSupport {
    private String username;
    private String sex;
    private String city;

    public String books(){
        System.out.println(username);
        System.out.println(sex);
        System.out.println(city);
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("书名" + i, "作者" + i, "分类" + i);
            books.add(book);
        }
        ActionContext.getContext().put("books",books);
        return SUCCESS;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
