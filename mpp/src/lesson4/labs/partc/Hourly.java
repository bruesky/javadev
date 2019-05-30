package lesson4.labs.partc;

public class Hourly extends Employee {
    private double hourlyWage;
    private double hoursPerWeek;

    public Hourly(String id,double hourlyWage, double hoursPerWeek) {
        super(id);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return hourlyWage*hoursPerWeek*4;
    }
}
