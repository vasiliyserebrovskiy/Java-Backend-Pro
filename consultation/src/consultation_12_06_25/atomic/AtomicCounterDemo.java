package consultation_12_06_25.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (12.06.2025)
 */
public class AtomicCounterDemo {
    static AtomicInteger counter = new AtomicInteger(); // 0 - значение по умолчанию

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter.incrementAndGet();// атомарная операция
                // операция атомарная - происходит за не делимый промежуток времени
                // counter.getAndDecrement // атомарная операция
                // (CAS - операция)
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Результат: "+ counter.get());

    }


}
