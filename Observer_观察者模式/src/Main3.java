import demo.Book;
import demo.Reader;

public class Main3 {
    public static void main(String[] args) {
        Book book = new Book("玄门大逃杀");

        Reader reader1 = new Reader("张三");
        Reader reader2 = new Reader("李四");
        Reader reader3 = new Reader("王五");

        book.addObserver(reader1);
        book.addObserver(reader2);
        book.addObserver(reader3);

        System.out.println(book.countObservers());

        book.notifyObservers(reader1);
    }
}
