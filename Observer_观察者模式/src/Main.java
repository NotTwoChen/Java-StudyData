import observer.Reader;
import subject.Book;

public class Main {


    public static void main(String[] args) {
        Book book1 = new Book("斗破苍穹");
        Book book2 = new Book("飞剑问道");
        Book book3 = new Book("斗罗大陆");

        Reader reader1 = new Reader("小不点");
        Reader reader2 = new Reader("葫芦娃");
        Reader reader3 = new Reader("小老庄");

        book1.insert(reader1);
        reader1.insert(book1);
        book1.insert(reader2);
        reader2.insert(book1);
        book1.insert(reader3);
        reader3.insert(book1);

        book1.notify("刚刚发布了第三章!");

        book2.insert(reader2);
        reader2.insert(book2);
        book2.insert(reader3);
        reader3.insert(book2);


        book3.insert(reader3);
        reader3.insert(book3);

        reader3.notify("打赏了一百块钱!");


    }
}
