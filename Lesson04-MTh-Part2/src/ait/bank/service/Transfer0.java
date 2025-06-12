package ait.bank.service;

import ait.bank.model.Account;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (11.06.2025)
 */
public class Transfer0 implements Runnable {
    private Account accFrom;
    private Account accTo;
    private int sum;

    public Transfer0(Account accFrom, Account accTo, int sum) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.sum = sum;
    }

    @Override
    public void run() {

        synchronized (accFrom) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (accTo) {
                if (accFrom.getBalance() >= sum) {
                    accFrom.credit(sum);
                    accTo.debit(sum);
                }
            }
        }


    }
}
