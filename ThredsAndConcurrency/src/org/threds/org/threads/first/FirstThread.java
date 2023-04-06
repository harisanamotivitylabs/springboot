package org.threds.org.threads.first;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Thread1 extends Thread {

    @Override
    public void run() {
        List<Integer> integerList = Arrays.asList(1, 8, 8, 8, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

        integerList.stream().forEach(i -> System.out.println("task1 : " + i));
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        List<Integer> integerList = Arrays.asList(1, 8, 8, 8, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

        integerList.stream().forEach(i -> System.out.println("task2 : " + i));
    }
}

public class FirstThread {
    public static void main(String[] args) throws Exception {

        Thread1 thread1 = new Thread1();
        Runnable thread2 = new Thread2();
        thread1.start();
        Callable thread = new CallableThread();
        ExecutorService service = Executors.newFixedThreadPool(22);
        Future submit = service.submit(thread);
        System.out.println(submit.get());
        service.shutdown();
        new Thread(thread2).start();
    }

}

class CallableThread implements Callable {

    @Override
    public String call() throws Exception {
        List<Integer> integerList = Arrays.asList(1, 8, 8, 8, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        integerList.stream().forEach(i -> System.out.println("task3 : " + i));
        return "Task3 Completed @&&@";
    }
}