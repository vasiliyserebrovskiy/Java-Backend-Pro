package ait.messages;

import ait.messages.model.MessageBox;
import ait.messages.model.MessageBoxA;
import ait.messages.model.MessageBoxB;
import ait.messages.model.MessageBoxC;
import ait.messages.service.Receiver;
import ait.messages.service.Sender;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (12.06.2025)
 */
public class MessageBoxAppl {
    private static final int N_MESSAGES = 20;
    private static final int N_RECEIVERS = 5;
    private static MessageBox messageBox = new MessageBoxC();

    public static void main(String[] args) throws InterruptedException {

        Thread sender = new Thread(new Sender(messageBox, N_MESSAGES));

        for (int i = 0; i < N_RECEIVERS; i++) {
            Thread receiver = new Thread(new Receiver(messageBox));
            receiver.setDaemon(true);
            receiver.start();
        }
        Thread.sleep(100);    // all receivers go to sleep becaurse message = null -> wait
        sender.start();
        sender.join();

        Thread.sleep(100);// give opportunity for receivers to read messages
    }
}
