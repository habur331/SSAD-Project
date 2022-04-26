import Institution.Person;
import Institution.Student;
import Institution.StudentActivityControl;
import PatternVisitor.Element;
import PatternVisitor.ReportByDayVisitor;
import PatternVisitor.ReportByStudentIDVisitor;
import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;

import java.util.Calendar;
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
        // 1.Create Students
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
        // 2. Students attend
        //
        StudentActivityControl.markClass(studentA, "SSAD");
        StudentActivityControl.markClass(studentB, "SSAD");
        StudentActivityControl.markClass(studentC, "SSAD");

        //
        // 2. Students receive grades
        //
        StudentActivityControl.giveGrade(studentA, "SSAD", 'A');
        StudentActivityControl.giveGrade(studentA, "AGLA", 'C');
        StudentActivityControl.giveGrade(studentB, "SSAD", 'B');
        StudentActivityControl.giveGrade(studentC, "SSAD", 'C');
        StudentActivityControl.giveGrade(studentC, "AGLA", 'C');
        StudentActivityControl.giveGrade(studentD, "SSAD", 'D');

        //
        // 2. Students pay
        //
        StudentActivityControl.acceptPayment(studentA, 10000);
        StudentActivityControl.acceptPayment(studentB, 9000.5);
        StudentActivityControl.acceptPayment(studentC, 100.0);
        StudentActivityControl.acceptPayment(studentD, 100);

        //
        // 3. Report By Student ID
        //
        gradeDataBase.accept(new ReportByStudentIDVisitor(studentA.getID()));
        paymentDataBase.accept(new ReportByStudentIDVisitor(studentA.getID()));
        attendanceDataBase.accept(new ReportByStudentIDVisitor(studentB.getID()));
        attendanceDataBase.accept(new ReportByStudentIDVisitor(studentC.getID()));
        paymentDataBase.accept(new ReportByStudentIDVisitor(studentD.getID()));

        //
        // 3. Report By Day
        //
        gradeDataBase.accept(new ReportByDayVisitor(new GregorianCalendar(2022, Calendar.APRIL, 26).getTime()));
        attendanceDataBase.accept(new ReportByDayVisitor(new GregorianCalendar(2022, Calendar.APRIL, 26).getTime()));
        paymentDataBase.accept(new ReportByDayVisitor(new GregorianCalendar(2022, Calendar.APRIL, 26).getTime()));

    }
}
