package ait.multithreading;

import ait.multithreading.task.MyTaskExtends;
import ait.multithreading.task.MyTaskImplements;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (06.06.2025)
 */
public class MultithreadingAppl {
    private static final int MAX = 10;
    private static final int SIZE = 3;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread started");
        Runnable task1 = new MyTaskImplements("TaskImplements", MAX);
        //task1.run(); так не работает
        //Создаем новый thread, в качестве аргумента передаем Runnable
        Thread thread1 = new Thread(task1);
        Thread thread2 = new MyTaskExtends("TaskExtends", MAX);

        Runnable[] tasks = new Runnable[SIZE];

        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new MyTaskImplements("Name#"+i, MAX);
        }

        Thread[] threads = new Thread[tasks.length];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tasks[i]);

        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            threads[i].join();
        }


        thread1.start(); // начнется одновременное выполнение кода
        thread2.start();

        for (int i = 0; i < MAX; i++) {
            System.out.println("Main thread, count = " + i);
            Thread.sleep(1);
        }
        thread1.join();
        thread2.join();
//        for (int i = 0; i < threads.length; i++) {
//            threads[i].join();
//        }
        System.out.println("Main thread finished");
        // старт определяется стартом maina
        // завершение определяется завершением выполнения последнего thread
    }
}

