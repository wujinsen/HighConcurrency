package SeventConcurrent.chapter2;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wjs on 2017/5/11.
 */
public class Philosopher2 extends Thread {

    private boolean eating;
    private Philosopher2 left;
    private Philosopher2 right;
    private ReentrantLock table;
    private Condition condition;
    private Random random;
    private int thinkCount;

    public Philosopher2(ReentrantLock table) {
        eating = false;
        this.table = table;
        condition = table.newCondition();//Returns a Condition instance for use with this instance.
        random = new Random();
    }

    public void setLeft(Philosopher2 left) {
        this.left = left;
    }

    public void setRight(Philosopher2 right) {
        this.right = right;
    }

    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
        }
    }

    private void think() throws InterruptedException {
        table.lock();
        try {
            eating = false;
            left.condition.signal();//Wakes up one waiting thread.
            right.condition.signal();
        } finally {
            table.unlock();//Attempts to release this lock.
        }
        ++thinkCount;
        if (thinkCount % 10 == 0)
            System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
        Thread.sleep(1000);
    }

    private void eat() throws InterruptedException {
        table.lock();
        try {
            while (left.eating || right.eating)
                condition.await(); //Causes the current thread to wait until it is signalled or interrupted
            eating = true;
        } finally {
            table.unlock();
        }
        Thread.sleep(1000);
    }
}
