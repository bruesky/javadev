package Prob2B;

import java.util.*;

public class Order {
	private int orderNum;
	private Date orderDate;
	private List<OrderLine> orderLines;
	
	public Order(Date date, int orderNum,int quatity, float price, int linenum) {
		this.orderDate = date;
		this.orderNum = orderNum;
		this.orderLines = new ArrayList<>();
		addOrderLine(quatity,price,linenum);
	}
	
	public void addOrderLine(int quatity, float price, int linenum) {
		this.orderLines.add(new OrderLine(this, quatity,price,linenum));
	}
	
	
	public int getOrderNum() {
		return orderNum;
	}


	public Date getOrderDate() {
		return orderDate;
	}
	
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	
}
