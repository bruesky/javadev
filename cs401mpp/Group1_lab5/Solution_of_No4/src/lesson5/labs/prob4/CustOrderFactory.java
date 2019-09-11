/**
 * 
 */
package lesson5.labs.prob4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiang
 *
 */
public class CustOrderFactory {
	public static Customer createCustomer(String name, List<LocalDate> lDateList) {
		Customer cust = new Customer(name);
		for (LocalDate ld : lDateList) {
			Order ord = new Order(ld);
			cust.addOrder(ord);
		}
		return cust;
	}
	public static void addItems(Order ord, List<String> itemList) {
		for (String item : itemList) {
			if (ord.getItems() == null) {
				ord.setItems(new ArrayList<Item>());
			}
			ord.getItems().add(new Item(item));
		}
	}
}
