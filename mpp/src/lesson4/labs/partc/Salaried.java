package lesson4.labs.partc;

public class Salaried extends Employee {
    private double salary;

    public Salaried(String id,double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }
}
