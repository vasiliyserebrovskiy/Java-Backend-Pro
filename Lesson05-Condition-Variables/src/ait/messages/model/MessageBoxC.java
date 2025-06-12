package ait.messages.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (12.06.2025)
 */
public class MessageBoxC implements MessageBox {
    private String message;
    private final Lock mutex = new ReentrantLock();
    private final Condition senderWaitCondition = mutex.newCondition();
    private final Condition receiverWaitCondition = mutex.newCondition();


    @Override
    public void post(String message) {
        mutex.lock();
        try {
            while (this.message != null) {
                try {
                    senderWaitCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.message = message;
            receiverWaitCondition.signal();
        } finally {
            mutex.unlock();
        }
    }

    @Override
    public String get() {
        mutex.lock();
        try {
            while (message == null) {
                try {
                    receiverWaitCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String res = message;
            message = null;
            senderWaitCondition.signal();
            return res;

        } finally {
            mutex.unlock();
        }
    }
}
