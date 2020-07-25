package com.mashibing.thread;

import java.util.concurrent.locks.LockSupport;

public class PrintUseLockSupport {

    static Thread thread1,thread2=null;
    static volatile int num=1;
    public static void main(String[] args) {
         thread1=new Thread(()->{
            while (num<100){
                if (num%2!=0){
                    System.out.println(Thread.currentThread().getName()+num);
                    num++;
                    LockSupport.unpark(thread2);
                    LockSupport.park();
                }
            }
             LockSupport.unpark(thread2); //�ó������
             LockSupport.unpark(thread1); //�ó������
        });
         thread2=new Thread(()->{
             while (num<100){
                 if (num%2==0){
                     System.out.println(Thread.currentThread().getName()+num);
                     num++;
                     LockSupport.unpark(thread1);
                     LockSupport.park();
                 }
             }
             LockSupport.unpark(thread2); //�ó������
             LockSupport.unpark(thread1); //�ó������
        });
        thread1.start();
        thread2.start();
        thread1.setName("�����߳�");
        thread2.setName("ż���߳�");
    }

}
