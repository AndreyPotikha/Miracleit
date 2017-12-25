package thread;


import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class ThreadExc extends Thread {

    private static int number;

    public static void main(String[] args) throws InterruptedException, IOException {
       /* ThreadExc thread = new ThreadExc();
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();*/

       /* RunnableEx runnableEx = new RunnableEx();
        Thread thread1 = new Thread(runnableEx);
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(runnableEx);
        thread2.start();*/

        RunnableWrite runnableWrite = new RunnableWrite();
        Thread thread3 = new Thread(runnableWrite);
        thread3.start();
       /* for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                new Thread(() -> System.out.println("jhjg")).start();
            }
        }*/
        thread3.join();

        RunnableReade runnableReade = new RunnableReade();
        Thread thread4 = new Thread(runnableReade);
        thread4.start();


    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("no more");
                    return;
                }
            }

        }
    }

    public static class RunnableEx implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static class RunnableWrite implements Runnable {
        @Override
        public void run() {
            try {
                Files.write(Paths.get("src\\main\\resources\\file.txt"), "hello".getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static class RunnableReade implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Files.readAllLines(Paths.get("src\\main\\resources\\file.txt")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
