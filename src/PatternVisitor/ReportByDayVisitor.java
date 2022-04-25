package PatternVisitor;

import Institution.Attendance;
import Institution.Grade;
import Institution.PaymentBook;
import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;
import WorkWithDataBase.StudentDB;

import java.util.Collection;
import java.util.Date;

public class ReportByDayVisitor implements Visitor {

    private Date date;

    public ReportByDayVisitor(Date date) {
        this.date = date;
    }

    @Override
    public void visitGradesDB(GradeDB db) {
        Collection<Grade> grades = GradeDB.getInstance().load(date);
        printTitle("Grades");
        grades.forEach(i -> System.out.println( StudentDB.getInstance().load(i.getStudentID()) + " has received " + i.getMark() + " on " +  i.getSubjectName()));
    }

    @Override
    public void visitAttendanceDB(AttendanceDB db) {
        Collection<Attendance> attendances = AttendanceDB.getInstance().load(date);
        printTitle("Attendance");
        attendances.forEach(i -> System.out.println( StudentDB.getInstance().load(i.getStudentID())  + (i.getAttended() ? " were present ":" were absent ") + " on " + i.getSubjectName()));
    }

    @Override
    public void visitPaymentDB(PaymentBookDB db) {
        Collection<PaymentBook> paymentBook = PaymentBookDB.getInstance().load(date);
        printTitle("PaymentBook");
        paymentBook.forEach(i -> System.out.println((StudentDB.getInstance().load(i.getStudentID())) + (i.getRepaid() ? (" has dept " + (i.getPrice() - i.getInvestment())) : ("paid the bill in full on " + i.getAppointmentDate()))));

    }

    private void printTitle(String titlePart) {
        System.out.println("\n\n--------------------" + titlePart + " Report of " + titlePart + " on " + date + " --------------------------\n");
    }
}
