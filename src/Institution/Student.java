package Institution;
import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;
import WorkWithDataBase.StudentDB;

import java.util.GregorianCalendar;
//TODO подумать над названием - т.к это оболочка на год
public class Student {
    private int ID;
    private Person person;
    private int group;
    private static int counter = 0;


    public Student(Person person, int group) {
        this.person = person;
        this.group = group;
        this.ID = counter++;
        StudentDB studentDB = StudentDB.getInstance();
        studentDB.write(this);
        PaymentBook paymentBook = new PaymentBook(this.ID);
        PaymentBookDB db = PaymentBookDB.getInstance();
        db.write(paymentBook);
    }

    public Person getPerson() {
        return person;
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
        GradeDB db = GradeDB.getInstance();
        db.write(grade);
        attendClass(subjectName);
    }

    public void payTuition(double amount)
    {
        PaymentBookDB db = PaymentBookDB.getInstance();
        PaymentBook paymentBook = db.load(this.ID).stream().findFirst().get();
        paymentBook.increaseInvestment(amount);
        db.write(paymentBook);
    }

    public void attendClass(String subjectName)
    {
        AttendanceDB db = AttendanceDB.getInstance();
        Attendance attendance = new Attendance(this.ID, subjectName, true,  new GregorianCalendar().getTime());
        db.write(attendance);
    }
}
