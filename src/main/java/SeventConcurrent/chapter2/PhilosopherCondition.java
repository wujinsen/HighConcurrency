package chapter2;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 条件变量Condition
 * 使用ReentrantLock的condition
 * Created by wjs on 2017/3/10.
 */
public class PhilosopherCondition extends Thread{
    private boolean eating;
    private PhilosopherCondition left, right;
    private ReentrantLock table;
    private Condition condition;
    private Random random;
    public PhilosopherCondition(ReentrantLock table) {
        eating = false;
        this.table = table;
        condition = table.newCondition();
        random = new Random();
    }
    public void setLeft(PhilosopherCondition left){
        this.left = left;
    }
    public void setRight(PhilosopherCondition right) {
        this.right = right;
    }

    public void run(){
        try {
            while(true){
                Thread.sleep(random.nextInt(1000));//思考一段时间
                think();
                eat();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void think() throws InterruptedException{
        table.lock();
        try{
            eating = false;
            left.condition.signal();
            right.condition.signal();
        }finally{
            table.unlock();
        }
        Thread.sleep(1000);
    }
    private void eat() throws  InterruptedException{
        table.lock();
        try{
            while(left.eating || right.eating){
                condition.await();

            }
        }finally{
            table.unlock();
        }
        Thread.sleep(1000);
    }
}

class Chopstick4 {

    private int id;
    public Chopstick4(int id) { this.id = id; }
    public int getId() { return id; }
}
