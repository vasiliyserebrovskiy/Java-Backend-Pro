package ait.elevator.model;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (10.06.2025)
 */
public class Elevator {
    private String name;
    private int currentVolume;

    public Elevator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(int portion) {
        currentVolume += portion;
    }
}
