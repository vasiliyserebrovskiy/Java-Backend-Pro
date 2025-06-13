package consultation_12_06_25.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (12.06.2025)
 */
/*
    Требуется симулировать старт гонка, где несколько машин должны стартовать одновременно
    Каждая машина финиширует через случайный промежуток времени
    После того как все финишируют программа должна завершиться

    CountDownLatch() - работает как задвижка
        latch.await() - что поток будет заблокирован (приостановлен) пока значение задвижки не станет равно 0.
        latch.countDown() - уменьшает значение счетчика на -1. Когда счетчик достигает нуля, задвижка открывается и все ждущие потоки продолжают выполнение кода.

 */
public class CarRace {
    public static void main(String[] args) throws InterruptedException {
        int carCount = 3;
        //2 задвишки - 1 для старта, вторая что все финишировали
        CountDownLatch readyLatch = new CountDownLatch(1); // задвижка старта гонки
        CountDownLatch finishLatch = new CountDownLatch(carCount); //задвижка окончания гонки

        for (int i = 1; i <= carCount; i++) {
            String name = "Car-" +i;
            new Thread(() -> {
                try {
                    System.out.println(name + " на старте");
                    readyLatch.await(); // ждем сигнала старта (когда readyLatch станет равен 0)

                    System.out.println(name + " starting!");
                    //генерируем случайное время гонки и засыпаем потом
                    int timeToFinish = ThreadLocalRandom.current().nextInt(1000,3000);
                    Thread.sleep(timeToFinish);

                    System.out.println(name + " финишировал за " + timeToFinish + " мс");

                    // Сообщает о финише
                    finishLatch.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        // Код потока main
        Thread.sleep(2000);

        System.out.println("START!");

        readyLatch.countDown(); // Открываем стартовую защелку
        // Lелаем в потоке main, но ждали открытия защелки другие потоки (машины).

        finishLatch.await(); // Ждем пока все финишируют
        System.out.println("Все машины финишировали");

    }
}
