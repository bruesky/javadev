package lesson2.labs.prob4;

import java.util.*;

public class Section {
	private String courseName;
	private int sectionNumber;
	private List<TranscriptEntry> gradeSheet = new ArrayList<>();

	Section(String courseName, int sectionNumber){
		this.courseName = courseName;
		this.sectionNumber = sectionNumber;
	}

	public void addTranscriptEntry(TranscriptEntry transcriptEntry){
		gradeSheet.add(transcriptEntry);
	}


	public String getCourseName() {
		return courseName;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public List<TranscriptEntry> getGradeSheet() {
		return gradeSheet;
	}
}
