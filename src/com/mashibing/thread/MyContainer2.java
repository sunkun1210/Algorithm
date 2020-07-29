package com.mashibing.thread;

import jdk.nashorn.internal.ir.CatchNode;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2<T> {
//是
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10; //最多10个元素
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        lock.lock();
        try {
            while (lists.size()==MAX){
            //    consumer.signal();
                producer.await();
            }
            lists.add(t);
            System.out.println("shengchan======");
            count++;
            consumer.signal();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t=null;
        try {
            lock.lock();
            while (lists.size()==0){
                consumer.await();
            }
            t=lists.removeFirst();
            System.out.println("xiaofei======");
            count--;
            producer.signal();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer2 myContainer2 = new MyContainer2();

        for (int i=0;i<1;i++){
            new Thread(()->{
                for(int j=0; j<5; j++) {
                    System.out.println(Thread.currentThread().getName()+"%%%%%%"+myContainer2.get());
                }
            },"consumerThread"+i).start();
        }
        //启动生产者线程
        for (int i=0;i<1;i++){
            new Thread(()->{
                for(int j=0; j<25; j++){
                    myContainer2.put(Thread.currentThread().getName());
                }
            },"producerThread"+i).start();
        }
    }

}
