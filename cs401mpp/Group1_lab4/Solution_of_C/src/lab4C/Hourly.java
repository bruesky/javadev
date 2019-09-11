/**
 * 
 */
package lab4C;

/**
 * @author 610122
 *
 */
public class Hourly extends Employee {
	double hourlyWage;
	double hoursPerWeek;

	Hourly(String empId, double hourlyWage, double hoursPerWeek) {
		super.setEmpId(empId);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}

	@Override
	double calcGrossPay(int month, int year) {
		return hourlyWage * hoursPerWeek * 4;
	}
}
