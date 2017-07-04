package juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Xingfeng on 2017-04-21.
 */
public class CompleteTask implements Runnable {

    private CountDownLatch countDownLatch;

    public CompleteTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            countDownLatch.await();
            System.out.println("文件下载完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
