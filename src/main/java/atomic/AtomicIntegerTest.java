import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wjs on 2017/3/7.
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);
    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());//原子自增长1，返回更新前的值 1
        System.out.println(ai.incrementAndGet());//原子自增长1，返回更新后的值 3
        System.out.println(ai.get()); //获取值 3
        System.out.println(ai.getAndSet(5));//设置值
        System.out.println(ai.get());// 5
        System.out.println(ai.getAndAdd(6));
        System.out.println(ai.get());
    }
}
