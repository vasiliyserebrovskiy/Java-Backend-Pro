package ait.bank.model;

import java.util.Objects;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (11.06.2025)
 */
public class Account {
    private int accNumber;
    private int balance;

    public Account(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void debit(int sum) {
        balance = balance + sum;
    }

    public void credit(int sum) {
        balance = balance - sum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accNumber == account.accNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accNumber);
    }
}
