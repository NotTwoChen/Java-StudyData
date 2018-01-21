package observer;


import subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class Reader implements Observer,Subject{
    private String readerName;
    private List<Observer> books = new ArrayList<>();

    public Reader(String readerName) {
        this.readerName = readerName;
    }

    @Override
    public void update(String message) {
        System.out.println(readerName + "---" + message);
    }

    @Override
    public void insert(Observer observer) {
        books.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        books.add(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer book : books) {
            book.update(readerName+message);
        }
    }
}
