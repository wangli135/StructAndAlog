package ali;

/**
 * Created by Xingfeng on 2017-04-26.
 */
public class Test1 {

    static class MyThread extends Thread{
        @Override
        public void run() {
            try{
                Thread.sleep(2000);
                System.out.println("run");
            }catch (Exception e){
                System.out.println("exception");
            }finally {
                System.out.println("finally");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
      MyThread thread=new MyThread();
      thread.setDaemon(true);
      thread.start();
      Thread.sleep(1000);
    }

}
