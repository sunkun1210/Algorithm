package com.mashibing.thread;

public class PrintNumSyns {
        private static volatile Integer counter = 0;
        private static Object monitor = new Object();

        public static void main(String[] args) {
            Thread t1 = new Thread(() -> {
                while (counter<100){
                    synchronized (monitor){
                        if (counter % 2 != 0){
                            System.out.println("奇数线程："  + counter);
                            counter++;
                            try {
                                monitor.notify();
                                monitor.wait(); //让出锁
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        monitor.notify(); //为什么不会唤醒自己继续执行
                    }
                }
            });
            Thread t2 = new Thread(() -> {
                while (counter<100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (monitor){
                        if (counter % 2 == 0){
                            System.out.println("偶数线程："  + counter);
                            counter++;
                            try {
                                monitor.notify();
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                       monitor.notify();//让程序停住 否则最后一个线程是wait状态
                    }
                }
            });
            t1.start();
            t2.start();
    }
}
