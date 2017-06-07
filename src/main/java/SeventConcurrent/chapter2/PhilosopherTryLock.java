package chapter2;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的tryLock()为获取锁设置超时时间
 * Created by wjs on 2017/3/10.
 */
public class PhilosopherTryLock {
    private ReentrantLock left, right;
    private Random random;
    public PhilosopherTryLock(ReentrantLock left, ReentrantLock right){
        left = this.left;
        right = this.right;
        random = new Random();
    }
    public void run(){
        try {
            while(true){
                Thread.sleep(random.nextInt(1000));//思考一段时间
                left.lock();
                try{
                   if(right.tryLock(1000, TimeUnit.MILLISECONDS)){//获得锁返回true，超时没获得锁返回false
                       //获取右手边的筷子
                       Thread.sleep(random.nextInt(1000));
                   }else{
                       //没有获取到右手边的筷子，继续思考
                   }
                }finally{
                    left.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
class Chopstick3 {

    private int id;
    public Chopstick3(int id) { this.id = id; }
    public int getId() { return id; }
}
