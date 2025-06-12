package ait.messages.service;

import ait.messages.model.MessageBox;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (12.06.2025)
 */
public class Receiver implements Runnable {
    private MessageBox messageBox;

    public Receiver(MessageBox messageBox) {
        this.messageBox = messageBox;
    }

    @Override
    public void run() {
        while (true) {
            String message = messageBox.get();
            System.out.println(message + " - receiver " + Thread.currentThread().getName());
        }
    }
}
