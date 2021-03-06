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
import java.util.Collection;
import java.util.Optional;

public class ReportByStudentIDVisitor implements Visitor {

    private Optional<Student> student;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public ReportByStudentIDVisitor(int studentId) {
        this.student = StudentDB.getInstance().load(studentId).stream().findFirst();
    }

    @Override
    public void visitGradesDB(GradeDB db) {

        if (student.isPresent()) {
            Collection<Grade> grades = GradeDB.getInstance().load(student.get().getID());
            printTitle("Grades");
            grades.forEach(i -> System.out.println(sdf.format(i.getDate().getTime()) + i.getSubjectName() + " grade is " + i.getMark()));
        }
    }

    @Override
    public void visitAttendanceDB(AttendanceDB db) {

        if (student.isPresent()) {
            Collection<Attendance> attendances = AttendanceDB.getInstance().load(student.get().getID());
            printTitle("Attendance");
            attendances.forEach(i -> System.out.println(sdf.format(i.getDate().getTime()) + (i.getAttended() ? " were present " : " were absent ") + " on " + i.getSubjectName()));
        }
    }

    @Override
    public void visitPaymentDB(PaymentBookDB db) {
        if (student.isPresent()) {
            Collection<PaymentBook> paymentBook = PaymentBookDB.getInstance().load(student.get().getID());
            printTitle("PaymentBook");

            paymentBook.forEach(i -> System.out.println(!i.getRepaid() ?
                    (" has dept " + (i.getPrice() - i.getInvestment())) : ("paid the bill in full " + sdf.format(i.getRepaymentDate().getTime()))));
        }
    }

    private void printTitle(String titlePart) {
        System.out.println("\n\n--------------------" + titlePart + " Report for Student " + student.get().getPerson().getName() + " " + student.get().getPerson().getLastName() + "--------------------------\n");

    }
}
