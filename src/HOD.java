import Institution.*;
import PatternVisitor.ReportByDayVisitor;
import PatternVisitor.ReportByStudentIDVisitor;
import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;
import WorkWithDataBase.StudentDB;

import java.util.Calendar;
import java.util.Date;

public class HOD {

    // Демонстрация
    public static void main(String[] args) {
        //
        // Получаем бд
        //
        GradeDB gradeDataBase = GradeDB.getInstance();
        StudentDB studentDataBase = StudentDB.getInstance();
        PaymentBookDB paymentDataBase = PaymentBookDB.getInstance();
        AttendanceDB attendanceDataBase = AttendanceDB.getInstance();

        //
        // Примеры студентов
        //
        Student studentA = new Student(new Person(
                "Lev",
                "Ivanov",
                new Date(2000, Calendar.MARCH, 3)), 1);

        Student studentB = new Student(new Person(
                "Peter",
                "Orlov",
                new Date(2000, Calendar.DECEMBER, 7)), 1);

        Student studentC = new Student(new Person(
                "Artem",
                "Latyshev",
                new Date(2001, Calendar.JULY, 15)), 2);

        Student studentD = new Student(new Person(
                "Boris",
                "Vorontsov",
                new Date(2000, Calendar.OCTOBER, 26)), 2);

        //
        // Примеры посещения
        //
        studentA.attendClass("SSAD");
        studentB.attendClass("SSAD");
        studentC.attendClass("SSAD");

        //
        // Примеры оценок
        //
        studentA.receiveGrade("SSAD", 'A');
        studentB.receiveGrade("SSAD", 'B');
        studentC.receiveGrade("SSAD", 'C');
        studentD.receiveGrade("SSAD", 'D');

        //
        // Примеры оплаты
        //
        // TODO: падает
        studentA.payTuition(10000);
        studentB.payTuition(9000.5);
        studentC.payTuition(100.0);
        studentD.payTuition(1000000);

        //
        // Отчетность
        //
        gradeDataBase.accept(new ReportByStudentIDVisitor(studentA.getID()));
        attendanceDataBase.accept(new ReportByDayVisitor(new Date()));

    }
}
