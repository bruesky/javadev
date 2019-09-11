package lesson5.labs.prob4.extpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lesson5.labs.prob4.CustOrderFactory;
import lesson5.labs.prob4.Customer;

public class Main {
	public static void main(String[] args) {
//		Customer cust = new Customer("Bob");
//		Order order = Order.newOrder(cust, LocalDate.now());
//		order.addItem("Shirt");
//		order.addItem("Laptop");

//		order = Order.newOrder(cust, LocalDate.now());
//		order.addItem("Pants");
//		order.addItem("Knife set");
		
		List<LocalDate> lDateList = new ArrayList<>();
		lDateList.add(LocalDate.now());
		lDateList.add(LocalDate.now());
		Customer cust = CustOrderFactory.createCustomer("Bob", lDateList);
		List<String> ls1 = new ArrayList<>();
		ls1.add("Pants");
		ls1.add("Knife set");
		CustOrderFactory.addItems(cust.getOrders().get(0),ls1);
		List<String> ls2 = new ArrayList<>();
		ls2.add("Shirt");
		ls2.add("Laptop");
		CustOrderFactory.addItems(cust.getOrders().get(1),ls2);

		System.out.println(cust.getOrders());
	}
}

		
