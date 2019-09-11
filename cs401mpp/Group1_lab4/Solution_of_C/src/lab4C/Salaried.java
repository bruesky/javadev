/**
 * 
 */
package lab4C;

/**
 * @author 610122
 *
 */
public class Salaried extends Employee {
	double salary;

	Salaried(String empId, double salary) {
		super.setEmpId(empId);
		this.salary = salary;
	}

	@Override
	double calcGrossPay(int month, int year) {
		return salary;
	}
}
