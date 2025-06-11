package ait.elevator.task;

import ait.elevator.model.Elevator;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.06.2025)
 */
public class Truck implements Runnable {
    private final static Object monitor = new Object(); // объект используем как монитор
    private int nRaces;
    private int capacity;
    private Elevator elevator;

    public Truck(int nRaces, int capacity, Elevator elevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor) {
                elevator.add(capacity);
            }
        }
    }
}
