package observer;

import java.util.Observable;
import java.util.Observer;

public class Reader2 implements Observer {
    private String name;

    public Reader2(String name) {
        this.name = name;
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name+"----"+arg);
    }
}
