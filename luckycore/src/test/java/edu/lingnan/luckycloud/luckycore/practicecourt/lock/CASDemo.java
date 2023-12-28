package edu.lingnan.luckycloud.luckycore.practicecourt.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        int oldValue;
        int newValue;
        do {
            oldValue = count.get();
            newValue = oldValue + 1;
        } while (!count.compareAndSet(oldValue, newValue));
        // count.compareAndSet(oldValue, newValue) 是使用 CAS 操作更新计数器的关键步骤。
        // 它的作用是比较当前共享变量的值与期望的旧值，如果相等，则使用新值来更新共享变量，并返回更新是否成功的结果。
        // 在increment 方法中，我们使用一个循环来连续进行 CAS 操作，直到成功为止。
        // 这是因为在多线程环境下，有可能多个线程同时执行 CAS 操作，并发地尝试更新共享变量。
        // 循环可以保证在失败的情况下不断重新尝试，直到成功为止。
    }

    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) {
        final CASDemo casDemo = new CASDemo();

        // 创建多个线程并发执行计数器的递增操作
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                casDemo.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                casDemo.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + casDemo.getCount());
    }
}