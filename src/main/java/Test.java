/**
 * Created by wjs on 2017/1/12.
 */
public class Test {
    public static void main(String args[]) {
        int a = 0, b = 0;
        if (a != b) {
            System.out.println("hello");
        }
        for (int i = 0; i < 5; ++i) {
            System.out.println((i + 1) % 5);
        }
        P[] p = new P[5];
        for(int i=0;i<5;++i){
            p[i] = new P("zhangsan","18");
        }

    }
}
class  P{
    private String name;
    private String age;
    public P(String name, String age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
