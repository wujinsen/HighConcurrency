import javax.jnlp.IntegrationService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * java并发编程Fork/Join框架
 * Created by wjs on 2017/3/7.
 */
public class CountTask extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 2;//任务阈值
        private int start;
        private int end;
    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }
    protected Integer compute(){
    int sum = 0;
            //如果任务足够小就直接计算任务
        boolean canCompute = (end -start) <= THRESHOLD;
        if(canCompute){
            for(int i = start; i <= end; i++){//执行计算累加
                sum += i;
            }
        }else{
        //如果任务大于阈值，就分裂成两个小任务
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，得到结果
            int leftResult = leftTask.join();
            int rightResutl = rightTask.join();
            //合并子任务
            sum = leftResult + rightResutl;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务，负责计算1+2+3+4
        CountTask task = new CountTask(1, 4);
        //执行一个计算任务
        Future<Integer> result = forkJoinPool.submit(task);
        try{
            System.out.println(result.get());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
