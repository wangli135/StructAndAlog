package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Xingfeng on 2017-04-21.
 */
public class Test {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService exex = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            exex.execute(new DownloadTask(i, countDownLatch));
        }
        for (int i = 1; i < 10; i++) {
            exex.execute(new SingleTask());
        }
        exex.execute(new CompleteTask(countDownLatch));

    }

}
