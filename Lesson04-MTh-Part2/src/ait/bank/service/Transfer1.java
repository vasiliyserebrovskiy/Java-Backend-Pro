package ait.bank.service;

import ait.bank.model.Account;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (11.06.2025)
 */
public class Transfer1 implements Runnable {
    private Account accFrom;
    private Account accTo;
    private int sum;

    public Transfer1(Account accFrom, Account accTo, int sum) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.sum = sum;
    }

    @Override
    public void run() {

        //---------- вариант цвай
        if (accFrom.getAccNumber() < accTo.getAccNumber()) {
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
        } else {
            synchronized (accTo) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (accFrom) {
                    if (accFrom.getBalance() >= sum) {
                        accFrom.credit(sum);
                        accTo.debit(sum);
                    }
                }
            }
        }

    }
}
