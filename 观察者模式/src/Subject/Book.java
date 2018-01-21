package Subject;

import Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Book extends Subject {
    private String name;
    private List<Observer> observers =
            new ArrayList<Observer>();

    public Book(String name) {
        this.name = name;
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(name+message);
        }
    }
}
