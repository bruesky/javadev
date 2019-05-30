package lesson4.labs.partc;

import lesson4.lecture.staticinherit.second.Super;

import java.time.LocalDate;
import java.util.List;

public class Commissioned extends Employee {
    private double commision;
    private double baseSalary;
    private List<Order> orders;

    public Commissioned(String id, double commision, double baseSalary, List<Order> orders) {
        super(id);
        this.commision = commision;
        this.baseSalary = baseSalary;
        this.orders = orders;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        double sum = baseSalary;
        for (Order order:
             orders) {
            if (order.getOrderDate().getYear()==year&&order.getOrderDate().getMonthValue()+1==month)
            sum+=commision*order.getOrderAmount();
        }
        return sum;
    }
}
