package subject;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Book implements Subject,Observer{
    private String title;
    private List<Observer> readers = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }
    @Override
    public void insert(Observer observer) {
        readers.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        readers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer reader : readers) {
            reader.update(title+message);
        }
    }

    @Override
    public void update(String message) {
        System.out.println(title + "---" + message);
    }
}
