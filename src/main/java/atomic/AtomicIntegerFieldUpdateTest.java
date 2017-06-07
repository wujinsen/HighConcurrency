import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 原子更新字段类
 *
 * Created by wjs on 2017/3/8.
 */
public class AtomicIntegerFieldUpdateTest {

    //创建原子更新器，并设置需要更新的对象类和对象的属性
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {

        User conan = new User("conan", 18);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }

    static class User {

        private String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOld(int old) {
            this.old = old;
        }
    }
}
