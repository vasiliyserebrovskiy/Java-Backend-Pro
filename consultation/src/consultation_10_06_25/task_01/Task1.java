package consultation_10_06_25.task_01;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.06.2025)
 */
public class Task1 {
    public static void main(String[] args) {
        //Два базовых способа
        // 1. extends от класса Threads
        // 2. implements интерфейса Runnable

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

//        myThread1.run();
//        myThread2.run();

        // При создании наследования - просто запускаем метод старт
        myThread1.start();

        // Запуск потока с класса, который использует implements
        // сначала создаем объект и в него передаем экземпляр класса runnable
        Thread myThread = new Thread(myThread2);
        myThread.setDaemon(true); // делаем его демоном
        myThread.start();


        Thread thread1 = new Thread(() -> {
            for (int i = 100_000; i < 100_010 ; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        });

        thread1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
