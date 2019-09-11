/**
 * 
 */
package lab4C;

/**
 * @author 610122
 *
 */
public abstract class Employee {
	private String empId;

	abstract double calcGrossPay(int month, int year);

	Paycheck calcCompensation(int month, int year) {
		double grossPay = this.calcGrossPay(month, year);
		return new Paycheck(grossPay);
	}

	void print(int month, int year) {
		System.out.println("Employee ID:" + empId);
		System.out.println("Paystub:");
		calcCompensation(month, year).print();
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
