import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPool {
    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(() -> System.out.println("哈哈哈哈哈"),2, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> System.out.println("噢噢噢噢"),2,3,TimeUnit.SECONDS);
    }
}
