import Observer.Reader;
import Subject.Book;

public class Main {
    public static void main(String[] args) {
        // 创建被观察者/我发布了一本书
        Book book =
                new Book("斗破苍穹");
        // 创建观察者/吸引了读者
        Reader reader1 =
                new Reader("张三");
        Reader reader2 =
                new Reader("李四");
        Reader reader3 =
                new Reader("王五");

        book.add(reader1);
        book.add(reader2);

        book.notify("更新了第二章");

        book.delete(reader2);

        book.notify("更新了第三章");

    }
}
