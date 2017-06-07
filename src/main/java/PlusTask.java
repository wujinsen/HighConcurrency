/**
 * Created by wjs on 2017/1/12.
 */
public class PlusTask {
    volatile static int i = 0;
    public static class PlusTask2 implements Runnable {

        public void run() {
            for (int y = 0; y < 10000; y++) {
                i++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PlusTask2());
            threads[i].start();
        }
        for(int i=0;i< 10;i++){
            threads[i].join();
        }
        System.out.println(i);
    }
}
