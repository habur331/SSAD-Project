package PatternVisitor;

import Institution.Attendance;
import Institution.Grade;
import Institution.PaymentBook;
import Institution.Student;
import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;
import WorkWithDataBase.StudentDB;

import java.text.SimpleDateFormat;
import java.util.*;

public class ReportByDayVisitor implements Visitor {

    private final Calendar date;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public ReportByDayVisitor(Date date) {
        this.date = new GregorianCalendar();
        this.date.setTime(date);
    }

    @Override
    public void visitGradesDB(GradeDB db) {
        Collection<Grade> grades = GradeDB.getInstance().load(date);
        printTitle("Grades");
        grades.forEach(i -> {
            Optional<Student> student = StudentDB.getInstance().load(i.getStudentID()).stream().findFirst();
            student.ifPresent(value -> System.out.println(value.getPerson().getName() + " " + value.getPerson().getLastName() + " has received " + i.getMark() + " on " + i.getSubjectName()));
        });
    }

    @Override
    public void visitAttendanceDB(AttendanceDB db) {
        Collection<Attendance> attendances = AttendanceDB.getInstance().load(date);
        printTitle("Attendance");
        attendances.forEach(i -> {
            Optional<Student> student = StudentDB.getInstance().load(i.getStudentID()).stream().findFirst();
            student.ifPresent(value -> System.out.println(value.getPerson().getName() + " " + value.getPerson().getLastName() + (i.getAttended() ? " were present " : " were absent ") + " on " + i.getSubjectName()));
        });
    }

    @Override
    public void visitPaymentDB(PaymentBookDB db) {
        Collection<PaymentBook> paymentBook = PaymentBookDB.getInstance().load(date);
        printTitle("PaymentBook");
        paymentBook.forEach(i -> {
            Optional<Student> student = StudentDB.getInstance().load(i.getStudentID()).stream().findFirst();
            student.ifPresent(value -> System.out.println(value.getPerson().getName() + " " + value.getPerson().getLastName() + (!i.getRepaid() ? (" has dept " + (i.getPrice() - i.getInvestment())) : ("paid the bill in full on " + sdf.format(i.getRepaymentDate().getTime())))));
        });
    }

    private void printTitle(String titlePart) {
        System.out.println("\n\n--------------------" + titlePart + " Report of " + titlePart + " on " + sdf.format(date.getTime()) + " --------------------------\n");
    }
}
