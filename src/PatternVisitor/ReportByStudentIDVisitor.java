package PatternVisitor;

import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradesDB;
import WorkWithDataBase.PaymentDB;

public class ReportByStudentIDVisitor implements Visitor{
    @Override
    public void visitGradesDB(GradesDB db) {

    }

    @Override
    public void visitAttendanceDB(AttendanceDB db) {

    }

    @Override
    public void visitPaymentDB(PaymentDB db) {

    }
}
