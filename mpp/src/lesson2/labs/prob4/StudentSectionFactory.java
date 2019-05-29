package lesson2.labs.prob4;

public class StudentSectionFactory {

    public Section createSection(int secNum, String courseName){
        return new Section(courseName,secNum);
    }

    public Student createStudent(String id, String name){
        return new Student(name,id);
    }

    public void newTranscriptEntry(Student s, Section sect, String grade){
        TranscriptEntry transcriptEntry = new TranscriptEntry(s,sect,grade);
        s.addTranscriptEntry(transcriptEntry);
        sect.addTranscriptEntry(transcriptEntry);
    }
}
