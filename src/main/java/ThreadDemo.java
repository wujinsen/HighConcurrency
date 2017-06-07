/**
 * Created by wjs on 2017/1/3.
 */
public class ThreadDemo {
    public static void main(String args[]) {
        Thread t1 = new Thread() {
            public void run() {
                System.out.print("Thread runing...");
            }
        };
        t1.run();
    }
}
