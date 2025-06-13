package ait.integral;

import ait.integral.task.SumRectangles;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (13.06.2025)
 */
public class ThreadPoolIntegralAppl {
    private static final int N_TASKS = 10_000;
    private static final int N_PARTS = 1_000_000;
    private static final int A = 0;
    private static final int B = 3;

    public static void main(String[] args) throws InterruptedException {

        SumRectangles[] tasks = new SumRectangles[N_TASKS];
        for (int i = 0; i < N_TASKS; i++) {
            tasks[i] = new SumRectangles(A, B, x -> x * x, N_PARTS, N_TASKS, i);
        }

        long t1 = System.currentTimeMillis();

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int cpus = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU: " + cpus);
        ExecutorService executorService = Executors.newWorkStealingPool(cpus);

        for (int i = 0; i < tasks.length; i++) {
            executorService.execute(tasks[i]);
        }
        executorService.shutdown(); // метод, после которого execute уже работать не будет (больше никого не принимаю, но все кто в очереди будут дорабатывать)

        //executorService.execute(tasks[0]); RejectedExecutionException - нельзя зайти в магазин, после закрытия

        executorService.awaitTermination(1, TimeUnit.MINUTES); // дождись выполнения всех тасков, но если через минуту все еще кто-то работает - тех завершить.

        long t2 = System.currentTimeMillis();

        System.out.println("Duration: " + (t2 - t1));

        double res = Arrays.stream(tasks).mapToDouble(SumRectangles::getResult).sum();
        System.out.println("Result: " + res);
    }
}
