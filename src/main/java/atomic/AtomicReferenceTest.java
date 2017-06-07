import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子更新引用类型
 * AtomicReference  原子更新引用类型
 * AtomicReferenceFieldUpdater 原子更新引用类型里的字段
 * AtomicMarkableRefence 原子更新带有标记位的引用类型
 * Created by wjs on 2017/3/8.
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> ar = new AtomicReference<User>();
    public static void main(String[] args) {
        User user = new User("conan",15);
        ar.set(user);
        User updateUser = new User("Shinichi", 17);
        ar.compareAndSet(user, updateUser);
        System.out.println(ar.get().getName());
        System.out.println(ar.get().getOld());
    }
    static class User{

        private String name;
        private int old;
        public User(String name, int old){
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
