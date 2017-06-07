package chapter2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wjs on 2017/3/13.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        System.out.println("aaaa");
        class ConnectionHandler implements  Runnable{
            InputStream in; OutputStream output;
            ConnectionHandler(Socket socket) throws IOException {
                in = socket.getInputStream();
                output = socket.getOutputStream();
            }
            public void run(){
                try{
                    int n;
                    byte[] buffer = new byte[1024];
                    while((n = in.read(buffer)) != -1){
                        output.write(buffer);
                        output.flush();
                    }
                }catch(IOException e){}
            }
        }

        ServerSocket server = new ServerSocket(4567);

//        while(true){
//            Socket socket = new Socket();
//            Thread handler = new Thread(new ConnectionHandler(socket));
//            handler.start();
//        }

        int threadPoolSize = Runtime.getRuntime().availableProcessors() * 2;
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        while(true){
            Socket socket = server.accept();
            executor.execute(new ConnectionHandler(socket));
        }

    }
}

