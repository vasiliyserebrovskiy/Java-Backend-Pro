package ait.timer.task;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.06.2025)
 */
public class Timer implements Runnable {
    private int clockPeriod = 3;

    public int getClockPeriod() {
        return clockPeriod;
    }

    public void setClockPeriod(int clockPeriod) {
        this.clockPeriod = clockPeriod;
    }



    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            try {
                Thread.sleep(clockPeriod*1000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e); // ближе к продакшен
//                e.printStackTrace(); // при тестировании
                System.out.println(Thread.interrupted());
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(Thread.currentThread().getName() + " (aka Timer) Timer thread say bye, bye");
                break;
            }
        }
    }
}
