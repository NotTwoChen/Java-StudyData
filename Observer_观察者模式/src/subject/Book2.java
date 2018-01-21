package subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Book2 extends Observable {

    private String title;
    private List<Observer> readers = new ArrayList<>();

    public Book2() {
    }

    public Book2(String title) {
        this.title = title;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        readers.add(o);
//        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        readers.remove(o);
//        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer reader : readers) {
            reader.update(null,null);
        }
//        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer reader : readers) {
            reader.update(null,title+arg);
        }
//        super.notifyObservers(arg);
    }

    @Override
    public synchronized void deleteObservers() {
        readers.clear();
//        super.deleteObservers();
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    protected synchronized void clearChanged() {
        super.clearChanged();
    }

    @Override
    public synchronized boolean hasChanged() {
        return super.hasChanged();
    }

    @Override
    public synchronized int countObservers() {
        return readers.size();
//        return super.countObservers();
    }
}
