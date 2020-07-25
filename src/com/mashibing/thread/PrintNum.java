package com.mashibing.thread;

public class PrintNum{

    static volatile int num = 1;
    static volatile int flag = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (num<100) {
                if (flag==1 && (num % 2 == 0)) {
                    System.out.println(Thread.currentThread().getName()+num);
                    num++;
                    flag = 0;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (num<100){
                if (flag==0 && (num % 2 != 0)) {
                    System.out.println(Thread.currentThread().getName()+num);
                    num++;
                    flag = 1;
                }
            }
        });
        t1.setName("奇数线程");
        t2.setName("偶数线程");
        t1.start();
        t2.start();

    }
}