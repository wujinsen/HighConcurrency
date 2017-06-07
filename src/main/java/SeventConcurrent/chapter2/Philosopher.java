package SeventConcurrent.chapter2;

import java.util.Random;

/**
 * Created by wjs on 2017/3/9.
 */
class Philosopher extends Thread {
    private Chopstick left, right;
    private Random random;
    private int thinkCount;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left; this.right = right;
        random = new Random();
    }

    public void run() {
        try {
            while(true) {
                ++thinkCount;
                if (thinkCount % 10 == 0)
                    System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
                Thread.sleep(random.nextInt(1000));     // Think for a while
                synchronized(left) {                    // Grab left chopstick
                    synchronized(right) {                 // Grab right chopstick
                        Thread.sleep(random.nextInt(1000)); // Eat for a while
                    }
                }
            }
        } catch(InterruptedException e) {}
    }
}