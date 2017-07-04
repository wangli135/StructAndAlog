package juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xingfeng on 2017-04-21.
 */
public class DownloadTask implements Runnable {

    private int id;
    private CountDownLatch countDownLatch;

    public DownloadTask(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            System.out.println("文件" + id + "部分下载完毕");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
