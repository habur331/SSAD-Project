package Institution;

import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;

import java.util.GregorianCalendar;

public class StudentActivityControl
{
    public static void giveGrade(Student student, String subjectName, char mark)
    {
        Grade grade = new Grade(student.getID(), subjectName, mark, new GregorianCalendar().getTime());
        GradeDB db = GradeDB.getInstance();
        db.write(grade);
        markClass(student, subjectName);
    }

    public static void acceptPayment(Student student, double amount)
    {
        PaymentBookDB db = PaymentBookDB.getInstance();
        PaymentBook paymentBook = db.load(student.getID()).stream().findFirst().get();
        paymentBook.increaseInvestment(amount);
        db.write(paymentBook);
    }

    public static void markClass(Student student, String subjectName)
    {
        AttendanceDB db = AttendanceDB.getInstance();
        Attendance attendance = new Attendance(student.getID(), subjectName, true, new GregorianCalendar().getTime());
        db.write(attendance);
    }
}
