package ait.car.model;

import ait.utils.Id;
import ait.utils.Index;
import ait.utils.Table;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (05.06.2025)
 */
@Table(name = "auto")
public class Car {
    @Id
    @Index(unique = true)
    private String regNumber;
    @Index
    private String model;
    @Index
    private int year;
    private int gazTank;
    @Index
    private int odometer;
    private String color;
    @Index
    private double price;

    public Car(String regNumber, String model, int year, int gazTank, int odometer, String color, double price) {
        this.regNumber = regNumber;
        this.model = model;
        this.year = year;
        this.gazTank = gazTank;
        this.odometer = odometer;
        this.color = color;
        this.price = price;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getGazTank() {
        return gazTank;
    }

    public int getOdometer() {
        return odometer;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", gazTank=" + gazTank +
                ", odometer=" + odometer +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
