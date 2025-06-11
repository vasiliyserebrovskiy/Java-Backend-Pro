package ait.timer;

import ait.timer.task.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.06.2025)
 */
public class TimerAppl {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
//        thread.setDaemon(true);

        thread.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) { // thread - process demon (все служебные процессы должны быть остановлены, делает система)
            System.out.println("Enter time interval, or press q for exit");
            String str = br.readLine();
            if ("q".equalsIgnoreCase(str)) {
//                thread.stop(); // не безопасный код. Не корректное завершение работы, thread не успел адекватно закончить то что он делал
                thread.interrupt(); //физически thread не прерывает. У каждого объекта thread есть флаг isInterrupted
                // есть договоренность: если внутри thread этот флаг стал true то thread бросает InterruptedException и мы должны это обработать и корректно завершить
                // данный thread. Для этого все в try-catch b
                System.out.println("In main thread: " + thread.isInterrupted());
                break;
            } else {
                timer.setClockPeriod(Integer.parseInt(str));
            }
        }
        System.out.println(Thread.currentThread().getName() + " thread finished.");
        // Application на java завершает свою работу, когда завершает свою работу последний, не daemon thread.
        // Сделать thread демоном нужно до того, как он будет запушен!
        // Необработанный exception ломает stack.
    }
}
