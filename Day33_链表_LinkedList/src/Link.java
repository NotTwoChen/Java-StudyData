public interface Link {

    void add(Object data);
    void print();
    int size();
    boolean isEmpty();
    boolean contains(Object data);
    Object get(int index);
    void set(int index,Object data);
    void remove(Object data);

}
