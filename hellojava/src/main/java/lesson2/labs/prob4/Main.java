package lesson2.labs.prob4;
import java.util.*;

/** Shows how the design in this package of classes
 *  allows you to navigate in the way that the class
 *  diagram suggests
 */
public class Main {
	StudentSectionFactory studentSectionFactory = new StudentSectionFactory();
	Student bob = studentSectionFactory.createStudent("1","Bob");
	Student tim = studentSectionFactory.createStudent("2","tim");
	Student allen = studentSectionFactory.createStudent("3","allen");
	Student[] students = {bob, tim, allen};
	Section bio1 = studentSectionFactory.createSection(1,"Biology");
	Section bio2 = studentSectionFactory.createSection(2,"Biology");
	Section math = studentSectionFactory.createSection(3,"Mathematics");
	public static void main(String[] args) {
		Main m = new Main();
		m.readDataFromDb();
		System.out.println(m.getTranscript(m.bob));
		System.out.println("Grades for math section:\n " + m.getGrades(m.math));
		System.out.println("Courses that Tim took: " + m.getCourseNames(m.tim));
		System.out.println("Students who got A's: " + m.getStudentsWith("A"));
	}
	
	private Transcript getTranscript(Student s) {
		return s.getTranscript();
	}
	private List<String> getCourseNames(Student s) {
		List<TranscriptEntry> all = s.getGrades();
		List<String> courseNames = new ArrayList<>();
		for(TranscriptEntry te : all) {
			courseNames.add(te.getSection().getCourseName());
		}
		return courseNames;
	}
	private List<String> getGrades(Section s) {
		List<String> grades  = new ArrayList<>();
		for(TranscriptEntry t : s.getGradeSheet()) {
			grades.add(t.getGrade());
		}
		return grades;
	}
	private List<String> getStudentsWith(String grade) {
		List<String> studentNames = new ArrayList<>();
		for(Student s : students) {
			boolean found = false;
			for(TranscriptEntry te : s.getGrades()) {
				if(!found) {
					if(te.getGrade().equals(grade)) {
						found = true;
						studentNames.add(s.getName());
					}
				}
			}
		}
		return studentNames;
	}
	private void readDataFromDb() {
		studentSectionFactory.newTranscriptEntry(bob,bio1,"A");
		studentSectionFactory.newTranscriptEntry(bob,math,"B");
		studentSectionFactory.newTranscriptEntry(tim,bio1,"B+");
		studentSectionFactory.newTranscriptEntry(tim,math,"A-");
		studentSectionFactory.newTranscriptEntry(allen,math,"B");
		studentSectionFactory.newTranscriptEntry(allen,bio1,"B+");

	}

}
