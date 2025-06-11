package consultation_10_06_25.task_01;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.06.2025)
 */
public class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 10_000; i < 10_010; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}
