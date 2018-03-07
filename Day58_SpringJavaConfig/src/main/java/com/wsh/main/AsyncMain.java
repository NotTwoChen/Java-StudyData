package com.wsh.main;

import com.wsh.config.TaskExecutorConfig;
import com.wsh.service.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AsyncMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TaskExecutorConfig.class);
        context.refresh();
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
