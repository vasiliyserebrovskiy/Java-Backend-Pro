package ait.messages.service;

import ait.messages.model.MessageBox;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (12.06.2025)
 */
public class Sender implements Runnable {
    private MessageBox messageBox;
    private int nMessages;

    public Sender(MessageBox messageBox, int nMessages) {
        this.messageBox = messageBox;
        this.nMessages = nMessages;
    }



    @Override
    public void run() {
        for (int i = 0; i < nMessages; i++) {
            messageBox.post("message#" + i);
        }
    }
}
