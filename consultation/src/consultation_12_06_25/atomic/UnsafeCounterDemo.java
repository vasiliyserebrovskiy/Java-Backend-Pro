package consultation_12_06_25.atomic;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (12.06.2025)
 */
public class UnsafeCounterDemo {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 10_000; i++) {
                counter++; // не атомарная операция counter = counter + 1
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        t1.join(); // по хорошему тут try-cach
        t2.join();
        System.out.println("Результат: " + counter);
    }
}
