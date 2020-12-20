package com.example.multithread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadPoolMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                printExecutionThreadStatus("run方法");
            }
        });
        System.out.println("已经提交run task");
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                printExecutionThreadStatus("call方法");
                System.out.println("执行call任务ing");
                Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                System.out.println("执行call任务结束");
                return "这是call返回的结果";
            }
        });
        System.out.println("已经提交call task");

        try {
            System.out.println("开始获取call task的执行结果");
            String result = future.get();//这个方法调用者会阻塞，直到得到返回值或者出现异常
            System.out.println("获取到了任务执行的结果，为：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("任务提交完毕");
        // TODO 关闭线程池，shutdown方法会等待所有已经提交的任务完成，然后释放所有资源
        // TODO 正常应该在应用程序需要结束的时候，将工作线程池关闭。这里我们为了演示，提交完任务就关闭
        System.out.println("关闭线程池");
        executorService.shutdown();
    }


    private static void printExecutionThreadStatus(String phase) {
        System.out.println(Thread.currentThread().getName() + ":这是在线程池里执行的代码：" + phase);
    }
}