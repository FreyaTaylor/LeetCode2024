package src._JavaBasic.ThreadDemo;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamExample {

    public static void main(String[] args) throws IOException {
        // 创建管道的输入输出流
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        // 启动写入线程
        Thread writerThread = new Thread(() -> {
            try {
                pos.write("Hello from writer!".getBytes());
                pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 启动读取线程
        Thread readerThread = new Thread(() -> {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead = pis.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Message received: " + message);
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 启动线程
        writerThread.start();
        readerThread.start();

        // 等待线程结束
        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


