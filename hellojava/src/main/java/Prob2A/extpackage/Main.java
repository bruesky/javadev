package Prob2A.extpackage;

import Prob2A.GradeReport;
import Prob2A.Student;

public class Main {
	
	public static void main(String[]args) {
		Student student = new Student("Guo","MPP");
		
		GradeReport gradeReport = student.getGradeReport();
		System.out.println(gradeReport.getGrade());
		
		student = gradeReport.getStudent();
		System.out.println(student.getName());
	}

}
