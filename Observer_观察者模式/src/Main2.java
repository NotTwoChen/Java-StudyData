import observer.Reader2;
import subject.Book2;

public class Main2 {
    public static void main(String[] args) {
        //发布一本小说
        Book2 book = new Book2("我是大明星");

        //吸引来了读者
        Reader2 reader1 = new Reader2("张小花");
        Reader2 reader2 = new Reader2("王晓明");
        Reader2 reader3 = new Reader2("李小飞");
        reader1.update(book,"更新啦");

        //读者订阅了小说
        book.addObserver(reader1);
        book.addObserver(reader2);
        book.addObserver(reader3);

        //更新了章节
        book.notifyObservers("2018年1月16日19:21:52更新了第三百五十四章!");

        book.deleteObserver(reader1);

        book.notifyObservers("2018年1月18日11:11:22更新了第三百五十五章");

    }
}
