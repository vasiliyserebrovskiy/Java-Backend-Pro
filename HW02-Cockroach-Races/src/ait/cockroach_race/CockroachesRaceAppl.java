/*
 * Create an application-game “TarakansRace” Tarakan - thread running loop of distance
 * iterations. At each iteration the thread prints out its own number and
 * sleeps a random amount of milliseconds [2-5] The sleeping time range should be the same for all tarakans. Tarakan that is finishing the race the first is the winner.
 * ----
 * The application should take a number of tarakans and a distance from
 * the console input/output.
 * ----
 * At the end of a game there should be printed out the following message
 * “Congratulations to tarakan #X (winner)” where X - is the tarakan-winner number
 */

package ait.cockroach_race;

import ait.cockroach_race.model.Cockroach;
import ait.cockroach_race.utils.Utils;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (08.06.2025)
 */

public class CockroachesRaceAppl {
    public static void main(String[] args) throws InterruptedException {

        int numberOfCockroaches = Utils.readInputParameter("Please, enter number of cockroaches (a positive integer): ");
        int raceDistance = Utils.readInputParameter("Please enter the race distance (a positive integer): ");

        System.out.println("====================================");
        System.out.println("---       GAME PARAMETERS        ---");
        System.out.println("     Number of cockroaches: " + numberOfCockroaches);
        System.out.println("             Race distance: " + raceDistance);
        System.out.println("====================================");
        System.out.println();

        Cockroach.setDistance(raceDistance);

        Runnable[] cockroaches = new Runnable[numberOfCockroaches];
        Thread[] threadsOfCockroaches = new Thread[cockroaches.length];

        for (int i = 0; i < cockroaches.length; i++) {
            cockroaches[i] = new Cockroach(i);
            threadsOfCockroaches[i] = new Thread(cockroaches[i]);
        }

        for (int i = 0; i < threadsOfCockroaches.length; i++) {
            threadsOfCockroaches[i].start();
        }

        for (int i = 0; i < threadsOfCockroaches.length; i++) {
            threadsOfCockroaches[i].join();
        }

        if (Cockroach.getWinnerName() != -1) {
            System.out.printf("Congratulations to cockroach #%d (winner).\n", Cockroach.getWinnerName());
        } else {
            System.out.println("Something went wrong, please contact the developers.");
        }

    }

}
