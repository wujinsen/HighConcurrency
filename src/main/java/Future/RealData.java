package Future;

import java.util.concurrent.Callable;

/**
 * Created by wjs on 2017/5/12.
 */
public class RealData implements Callable<String>{
    private String data;
    public RealData(String data){
        this.data = data;
    }
    public String call() throws  Exception{
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<10;i++){
            sb.append(data);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){

            }
        }
        return sb.toString();
    }
}
