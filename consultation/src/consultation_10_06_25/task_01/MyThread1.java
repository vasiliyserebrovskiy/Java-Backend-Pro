package consultation_10_06_25.task_01;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.06.2025)
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 100; i < 110; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}
