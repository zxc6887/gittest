package com.example.demo.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 *
 */
public class MapExample {


    private static int threadNum = 200;//改为1后 输出为5000
    private static int clientNum = 5000;
    private static Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadNum);
        for (int i=0;i<clientNum;i++){
            final int threadNum = i;
            exec.execute(()->{
                try {
                    semaphore.acquire();
                    func(threadNum);
                    semaphore.release();
                }catch (Exception e){
                    System.out.println(e+"");
                }
            });
        }
        exec.shutdown();
        System.out.println(map.size());
    }

    public static void func(Integer threadNum){
     map.put(threadNum,threadNum);
    }
}
