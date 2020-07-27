package com.mashibing.leetcode.dynamicProgramming;

public class Fibonacci {
    volatile static int time =0;
    private Integer[] cache = new Integer[10000];

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        time++;
        if (cache[N] != null) {//如果 N 对应的斐波那契数存在，则返回。
            return cache[N];
        }
        cache[N] = fib(N-1) + fib(N-2);// 否则将计算 N 对应的斐波那契数为 memoize(N-1) + memoize(N-2)。
        return cache[N];
    }
    public int fib3(int N) {
        time++;
        if (N <= 1) {
            return N;
        }
        return  fib3(N-1) + fib3(N-2);
    }
//    public int memoize(int N) {
//        time++;
//        if (cache[N] != null) {//如果 N 对应的斐波那契数存在，则返回。
//            return cache[N];
//        }
//        cache[N] = memoize(N-1) + memoize(N-2);// 否则将计算 N 对应的斐波那契数为 memoize(N-1) + memoize(N-2)。
//        return memoize(N);
//    }
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int res= fibonacci.fib3(30);
        System.out.println(res);
        System.out.println(time);
    }
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize(N);
    }

    public int memoize(int N) {
        time++;
        if (cache[N] != null) {
            return cache[N];
        }
        cache[N] = memoize(N-1) + memoize(N-2);
        return memoize(N);
    }
}
