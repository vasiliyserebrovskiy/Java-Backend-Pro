package ait.cockroach_race.model;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (08.06.2025)
 */
public class Cockroach implements Beetle, Runnable {
    private static int winnerName = -1;
    private static int distance =-1;
    private final int name;


    public Cockroach(int name) {
        this.name = name;
    }

    public static int getWinnerName() {
        return winnerName;
    }

    public static void setWinnerName(int name) {
        if (Cockroach.winnerName == -1) {
            Cockroach.winnerName = name;
        } else {
            System.out.println("The winner has already been determined. Cockroach with name: " + name + " loose this race.");
        }
    }

    public static void setDistance(int distance) {
        if (Cockroach.distance == -1 && distance > 0) {
            Cockroach.distance = distance;
        } else {
            System.out.println("Distance is already set or invalid.");
        }
    }

    @Override
    public int randomSleep() {
        return (int) (Math.random() * 4) + 2;
    }

    @Override
    public void race(int dist) {
        for (int i = 0; i < dist; i++) {
            System.out.printf("Cockroach name : %d, iteration %d.\n", name, i);
            try {
                int temp = randomSleep();
                System.out.printf("Name: %d | Sleep time now: %d\n", name, temp);
                Thread.sleep(temp);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        setWinnerName(name);
    }

    @Override
    public void run() {
        if (distance == -1 ) {
            System.out.println("Error: Race distance didn't set!");
            return;
        }
        race(distance);
    }
}
