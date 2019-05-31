package lesson4.labs.partc;

import java.time.LocalDate;

public class Order {
    private String orderNo;
    private LocalDate orderDate;
    private int orderAmount;



    public Order(String orderNo, LocalDate orderDate, int orderAmount) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public double getProfit(double commision){
        return this.orderAmount*commision;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
