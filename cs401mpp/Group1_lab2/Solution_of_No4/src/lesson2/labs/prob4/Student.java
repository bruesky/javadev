package lesson2.labs.prob4;

import java.util.*;

public class Student {
	String id;

	String name;
	List<TranscriptEntry> grades;
	
	public Transcript getTranscript() {
		return new Transcript(grades, this);
		
	}
	
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TranscriptEntry> getGrades() {
        return grades;
    }

    public void setGrades(List<TranscriptEntry> grades) {
        this.grades = grades;
    }
}
