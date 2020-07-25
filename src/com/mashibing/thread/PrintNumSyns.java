package com.mashibing.thread;

public class PrintNumSyns {
        private static volatile Integer counter = 0;
        private static Object monitor = new Object();

        public static void main(String[] args) {
            Thread t1 = new Thread(() -> {
                while (counter<100){
                    synchronized (monitor){
                        if (counter % 2 != 0){
                            System.out.println("�����̣߳�"  + counter);
                            counter++;
                            try {
                                monitor.notify();
                                monitor.wait(); //�ó���
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        monitor.notify(); //Ϊʲô���ỽ���Լ�����ִ��
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
                            System.out.println("ż���̣߳�"  + counter);
                            counter++;
                            try {
                                monitor.notify();
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                       monitor.notify();//�ó���ͣס �������һ���߳���wait״̬
                    }
                }
            });
            t1.start();
            t2.start();
    }
}
