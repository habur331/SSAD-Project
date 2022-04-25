package Institution;

public class Attendance {
    private int ID;
    private int studentID;
    private String subjectName;
    private Boolean isAttended;

    public Attendance(int studentID, String subject, Boolean isAttended) {
        this.studentID = studentID;
        this.subjectName = subject;
        this.isAttended = isAttended;
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


    public Boolean getAttended() {
        return isAttended;
    }

    public void setAttended(Boolean attended) {
        isAttended = attended;
    }
}
