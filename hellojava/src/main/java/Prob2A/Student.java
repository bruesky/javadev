package Prob2A;

public class Student {
	private String name;
	private GradeReport gradeReport;
	
	public Student(String name, String gradeName) {
		this.name = name;
		this.gradeReport = new GradeReport(gradeName,this);
	}

	public GradeReport getGradeReport() {
		return gradeReport;
	}
	
	public String getName() {
		return name;
	}
}
