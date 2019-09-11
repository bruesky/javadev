/**
 * 
 */
package lab4C;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 610122
 *
 */
public class Commissioned extends Employee {
	double commission; // percentage
	double baseSalary;
	List<Order> orderList;

	Commissioned(String empId, double commission, double baseSalary, List<Order> orderList) {
		super.setEmpId(empId);
		this.commission = commission;
		this.baseSalary = baseSalary;
		this.orderList = orderList;
	}

	@Override
	double calcGrossPay(int month, int year) {
		return baseSalary + commission * getPrevMonthOrderAmounts(month, year);
	}

	double getPrevMonthOrderAmounts(int month, int year) {

		LocalDate countDate = LocalDate.of(year, month, 1);
		countDate = countDate.minusMonths(1);

		double sum = 0;
		for (Order ord : this.orderList) {
			if (ord.getOrderDate().getMonthValue() == countDate.getMonthValue()
					&& ord.getOrderDate().getYear() == countDate.getYear()) {
				sum += ord.getOrderAmount();
			}
		}
		return sum;
	}
}
