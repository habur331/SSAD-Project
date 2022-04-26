package Institution;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Attendance {
    private int studentID;
    private String subjectName;
    private Boolean isAttended;
    private final Calendar date;

    public Attendance(int studentID, String subject, Boolean isAttended, Date date) {
        this.studentID = studentID;
        this.subjectName = subject;
        this.isAttended = isAttended;
        this.date = new GregorianCalendar();
        this.date.setTime(date);
    }

    public int getStudentID() {
        return studentID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Boolean getAttended() {
        return isAttended;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date.setTime(date);
    }
}
