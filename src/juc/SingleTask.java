package juc;

/**
 * Created by Xingfeng on 2017-04-21.
 */
public class SingleTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Single Task");
    }
}
