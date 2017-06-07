/**
 * synchronized引发死锁问题
 * Created by wjs on 2017/3/8.
 */
public class Uninterruptible {


    public static void main(String[] args) throws  Exception{
        final Object o1 = new Object();
        final Object o2 = new Object();
        Thread t1 = new Thread(){
            public void run(){
                try{
                    synchronized(o1) {
                        Thread.sleep(1000);
                        synchronized (o2) {
                        }
                    }
                }catch (Exception e){
                    System.out.println("t1 interrupted");
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                try{
                    synchronized(o2) {
                        Thread.sleep(1000);
                        synchronized (o1) {
                        }
                    }
                }catch (Exception e){
                    System.out.println("t2 interrupted");
                }
            }
        };
        t1.start();t2.start();
        Thread.sleep(1000);
        t1.interrupt();t2.interrupt();
        t1.join();t2.join();
        System.out.println("hello");

    }
}
