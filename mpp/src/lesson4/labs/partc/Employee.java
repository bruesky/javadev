package lesson4.labs.partc;

public abstract class Employee {
    private String empId;

    public Employee(String empId) {
        this.empId = empId;
    }

    public void print(int month, int year){
        System.out.println("Employee ID:"+empId);
        System.out.println("Paystub:");
        calcCompensation(month,year).print();

    }

    public Paycheck calcCompensation(int month, int year){
        return new Paycheck(calcGrossPay(month, year));
    }

    public abstract double calcGrossPay(int month, int year);
}
