package Prob2B.extpackage;

import java.util.Date;

import Prob2B.Order;
import Prob2B.OrderLine;

public class Main {
	
	public static void main(String[]args) {
		
		// Order(Date date, int orderNum,int quatity, float price, int linenum)
		Order order = new Order(new Date(), 1, 10, 99.0f ,1);
		order.addOrderLine(3, 24.0f, 2);
		order.addOrderLine(1, 0.99f, 3);
		
		System.out.println(order.getOrderLines());
	}
	
}
