package ait.integral.task;

import java.util.function.Function;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (13.06.2025)
 */
public class SumRectangles implements Runnable {
    private double a;
    private double b;
    private Function<Double, Double> func;
    private int nParts;
    private int nTasks;
    private int threadNumber;
    private double result;

    public SumRectangles(double a, double b, Function<Double, Double> func, int nParts, int nTasks, int threadNumber) {
        this.a = a;
        this.b = b;
        this.func = func;
        this.nParts = nParts;
        this.nTasks = nTasks;
        this.threadNumber = threadNumber;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        double delta = (b - a) / nParts;
        for (int i = threadNumber; i < nParts; i += nTasks) {
            double l = a + i * delta; // left point of func part
            double r = l + delta; // right point
            double mid = (l + r ) / 2; // middle point
            result += delta * func.apply(mid); // S - of a func part
        }
    }
}
