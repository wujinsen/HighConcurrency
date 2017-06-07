package Future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by wjs on 2017/5/12.
 */
public class FutureMain {
    public static void main(String[] args) throws  Exception{
        //构造FutureTask
        FutureTask<String> fs = new FutureTask<String>(new RealData("a"));
        ExecutorService es = Executors.newFixedThreadPool(1);
        //这里开启线程进行RealData的call()执行
        es.submit(fs);//Future<?> submit(Runnable task);

        System.out.println("请求完毕");
        System.out.println(fs.isDone());
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){

        }

        System.out.println("数据="+ fs.get());
        System.out.println(fs.isDone());
    }
}
