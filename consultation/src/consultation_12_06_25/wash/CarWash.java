package consultation_12_06_25.wash;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (12.06.2025)
 */
/*
    У нас есть автомойка. Которая одновременно может обслуживать только две машины.

    Остальные ждут своей очереди. Каждая машина моется случайное время.

    Semaphore
    Semaphore ограничивает количество одновременных доступов к ресурсу.
    - acquire() - поток запрашивает доступ. Если места нет, поток ждет.
    - release() - поток освобождает ресурс после работы.
 */
public class CarWash {
    public static void main(String[] args) {

        int carCount = 7;
        Semaphore semaphore = new Semaphore(2); // 2 бокса мойки

        for (int i = 1; i <= carCount; i++) {
            String name = "Car_" + i;

            new Thread(() -> {
                try {
                    System.out.println(name + " ждет очередь на мойку");
                    semaphore.acquire(); // запрашивает вход в автомойку
                    // Если места нет, поток будет остановлен.

                    System.out.println(name + " моется...");

                    int washTime = ThreadLocalRandom.current().nextInt(1000,3000);
                    Thread.sleep(washTime); // симуляция мытья

                    System.out.println(name + " выехала из мойки спустя " + washTime + " мс");



                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }).start();

        }


    }
}
