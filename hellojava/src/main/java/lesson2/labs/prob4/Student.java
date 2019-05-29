package lesson2.labs.prob4;

import java.util.*;

public class Student {
	private String name;
	private String id;
	private List<TranscriptEntry> grades;

	Student(String name, String id){
		this.name = name;
		this.id = id;

		grades = new ArrayList<>();
	}

	public void addTranscriptEntry(TranscriptEntry transcriptEntry){
		this.grades.add(transcriptEntry);
	}

	
	public Transcript getTranscript() {
		return new Transcript(this);
		
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public List<TranscriptEntry> getGrades() {
		return grades;
	}
}
