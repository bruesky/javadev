/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2.labs.prob4;

import java.util.ArrayList;

/**
 *
 * @author jiang
 */
public class StudentSectionFactory {
    public Section createSection(int secNum, String courseName){
            Section section = new Section();
            section.setSectionNumber(secNum);
            section.setCourseName(courseName);
            return section;
    }
    
    public Student createStudent(String id, String name){
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            return student;
        
    }
    
    public void newTranscriptEntry(Student s, Section sect, String grade){
        TranscriptEntry transcriptEntry = new TranscriptEntry();
        transcriptEntry.setGrade(grade);
        transcriptEntry.setStudent(s);
        transcriptEntry.setSection(sect);
        if (s.getGrades() == null) {
            s.setGrades(new ArrayList<TranscriptEntry>());
        }
        s.getGrades().add(transcriptEntry);
        if (sect.getGradeSheet() == null) {
            sect.setGradeSheet(new ArrayList<TranscriptEntry>());
        }
        sect.getGradeSheet().add(transcriptEntry);
    }
}
