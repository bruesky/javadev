package lesson2.labs.prob4;

import java.util.*;

public class Section {
	String courseName;
	int sectionNumber;
	List<TranscriptEntry> gradeSheet;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public List<TranscriptEntry> getGradeSheet() {
        return gradeSheet;
    }

    public void setGradeSheet(List<TranscriptEntry> gradeSheet) {
        this.gradeSheet = gradeSheet;
    }
	
    
}
