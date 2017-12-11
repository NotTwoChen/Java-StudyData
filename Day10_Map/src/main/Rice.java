package main;

public class Rice {

    private String name;

    public Rice(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rice{" +
                "name='" + name + '\'' +
                '}';
    }
}
