package Prob2B;

public class OrderLine {
	private int linenum;
	private float price;
	private int quatity;
	private Order order;
	
	OrderLine(Order order,int quatity,float price, int linenum) {
		this.quatity = quatity;
		this.price = price;
		this.linenum = linenum;
		
		this.order = order;
	}
	
	
	public int getLinenum() {
		return linenum;
	}

	public float getPrice() {
		return price;
	}

	public int getQuatity() {
		return quatity;
	}

	public Order getOrder() {
		return order;
	}
	
	@Override
	public String toString() {
		return linenum+"_"+quatity+"_"+price;
	}
}
