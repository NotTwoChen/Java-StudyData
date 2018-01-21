import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPool {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            // 给一个变量赋值
            final int index = i;
            // 调用线程池
            executorService.execute(() -> {
                System.out.println(index);
                try {
                    Thread.sleep(index*2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

    }
}
