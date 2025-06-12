package ait.bank.service;

import ait.bank.model.Account;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (11.06.2025)
 */
public class Transfer implements Runnable {
    private Account accFrom;
    private Account accTo;
    private int sum;

    public Transfer(Account accFrom, Account accTo, int sum) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.sum = sum;
    }

    @Override
    public void run() {
        ReentrantLock accFromLock = accFrom.getLock();
        ReentrantLock accToLock = accTo.getLock();
       //  Check and set locks order
        if (accFrom.hashCode() < accTo.hashCode()) {
            accFromLock.lock();
            accToLock.lock();
        } else {
            accToLock.lock();
            accFromLock.lock();
        }
        try {
            if (accFrom.getBalance() >= sum) {
                accFrom.credit(sum);
//                System.out.println("Account: " + accFrom.getAccNumber() + " account balance: " + accFrom.getBalance());
                accTo.debit(sum);
//                System.out.println("Account: " + accTo.getAccNumber() + " account balance: " + accTo.getBalance());
            }
        } finally {
            accFromLock.unlock();
            accToLock.unlock();
        }
//        synchronized (accFrom) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            synchronized (accTo) {
//                if (accFrom.getBalance() >= sum) {
//                    accFrom.credit(sum);
//                    accTo.debit(sum);
//                }
//            }
//        }


    }
}
