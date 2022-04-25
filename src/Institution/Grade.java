package Institution;

import java.util.Date;

public class Grade {

    private int ID;
    private int studentID;
    private String subjectName;
    private char mark;
    private Date date;

    public Grade(int studentID, String subjectName, char mark, Date date) {
        this.studentID = studentID;
        this.subjectName = subjectName;
        this.mark = mark;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
