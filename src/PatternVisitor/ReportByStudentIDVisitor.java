package PatternVisitor;

import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;

public class ReportByStudentIDVisitor implements Visitor{
    @Override
    public void visitGradesDB(GradeDB db) {

    }

    @Override
    public void visitAttendanceDB(AttendanceDB db) {

    }

    @Override
    public void visitPaymentDB(PaymentBookDB db) {

    }
}
