package Prob2A;

public class GradeReport {
	private String grade;
	private Student student;
	
	GradeReport(String grade,Student student) {
		this.grade = grade;
		this.student = student;
	}

	public String getGrade() {
		return grade;
	}

	public Student getStudent() {
		return student;
	}
	
}
