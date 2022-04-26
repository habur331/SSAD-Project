import Institution.Person;
import Institution.Student;
import PatternVisitor.Element;
import PatternVisitor.ReportByDayVisitor;
import PatternVisitor.ReportByStudentIDVisitor;
import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;
import WorkWithDataBase.StudentDB;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HOD {

    // Демонстрация
    public static void main(String[] args) {
        //
        // Ours DataBases' Tools
        //
        Element gradeDataBase = GradeDB.getInstance();
        Element paymentDataBase = PaymentBookDB.getInstance();
        Element attendanceDataBase = AttendanceDB.getInstance();

        //
        // Create Students
        //
        Student studentA = new Student(new Person(
                "Lev",
                "Ivanov",
                new GregorianCalendar(2000, Calendar.MARCH, 3).getTime()), 1);

        Student studentB = new Student(new Person(
                "Peter",
                "Orlov",
                new GregorianCalendar(2000, Calendar.DECEMBER, 7).getTime()), 1);

        Student studentC = new Student(new Person(
                "Artem",
                "Latyshev",
                new GregorianCalendar(2001, Calendar.JULY, 15).getTime()), 2);

        Student studentD = new Student(new Person(
                "Boris",
                "Vorontsov",
                new GregorianCalendar(2000, Calendar.OCTOBER, 26).getTime()), 2);

        //
        // Students attend
        //
        studentA.attendClass("SSAD");
        studentB.attendClass("SSAD");
        studentC.attendClass("SSAD");

        //
        // Students receive grades
        //
        studentA.receiveGrade("SSAD", 'A');
        studentA.receiveGrade("AGLA", 'C');
        studentB.receiveGrade("SSAD", 'B');
        studentC.receiveGrade("SSAD", 'C');
        studentC.receiveGrade("AGLA", 'C');
        studentD.receiveGrade("SSAD", 'D');

        //
        // Students pay
        //
        studentA.payTuition(10000);
        studentB.payTuition(9000.5);
        studentC.payTuition(100.0);
        studentD.payTuition(100);

        //
        // Report By Student ID
        //
        gradeDataBase.accept(new ReportByStudentIDVisitor(studentA.getID()));
        paymentDataBase.accept(new ReportByStudentIDVisitor(studentA.getID()));
        attendanceDataBase.accept(new ReportByStudentIDVisitor(studentB.getID()));
        attendanceDataBase.accept(new ReportByStudentIDVisitor(studentC.getID()));
        paymentDataBase.accept(new ReportByStudentIDVisitor(studentD.getID()));

        //
        // Report By Day
        //
        gradeDataBase.accept(new ReportByDayVisitor(new GregorianCalendar(2022, Calendar.APRIL, 26).getTime()));
        attendanceDataBase.accept(new ReportByDayVisitor(new GregorianCalendar(2022, Calendar.APRIL, 26).getTime()));
        paymentDataBase.accept(new ReportByDayVisitor(new GregorianCalendar(2022, Calendar.APRIL, 26).getTime()));

    }
}
