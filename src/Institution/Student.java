package Institution;
import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradesDB;
import WorkWithDataBase.PaymentBookDB;

import java.util.GregorianCalendar;
//TODO подумать над названием - т.к это оболочка на год
public class Student {
    private int ID;
    private Person person;
    private int group;


    //студент пересоздаётся каждый год (если непонятно - спроси у Замиры)
    public Student(Person person, int group) {
        this.person = person;
        this.group = group;
        PaymentBook paymentBook = new PaymentBook(this.ID);
        PaymentBookDB db = new PaymentBookDB();
        db.write(paymentBook);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void receiveGrade(String subjectName, char mark){
        Grade grade = new Grade(this.ID, subjectName, mark, new GregorianCalendar().getTime());
        GradesDB db = new GradesDB();
        db.write(grade);
    }

    public void payTuition(double amount)
    {
        PaymentBookDB db = new PaymentBookDB();
        PaymentBook paymentBook = db.load(this.ID).stream().findFirst().get();
        paymentBook.increaseInvestment(amount);
        db.write(paymentBook);
    }

    public void attendClass(String subjectName)
    {
        AttendanceDB db = new AttendanceDB();
        Attendance attendance = new Attendance(this.ID, subjectName, true);
        db.write(attendance);
    }
}
