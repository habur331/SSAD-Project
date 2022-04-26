package Institution;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Grade {
    private int studentID;
    private String subjectName;
    private char mark;
    private final Calendar date;

    public Grade(int studentID, String subjectName, char mark, Date date) {
        this.studentID = studentID;
        this.subjectName = subjectName;
        this.mark = mark;
        this.date = new GregorianCalendar();
        this.date.setTime(date);
    }

    public int getStudentID() {
        return studentID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public char getMark() {
        return mark;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date.setTime(date);
    }
}
