package ait.multithreading.task;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (06.06.2025)
 */
public class MyTaskImplements implements Runnable {

    private String name;
    private int max;

    public MyTaskImplements(String name, int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() { // главная функция нового thread
        System.out.println(name + " task started");
        for (int i = 0; i < max; i++) {
            System.out.println("Task " + name + ", count = " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " task finished");
    }
}
