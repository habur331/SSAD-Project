package PatternVisitor;

import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradesDB;
import WorkWithDataBase.PaymentBookDB;

public class ReportByDayVisitor implements Visitor{
    @Override
    public void visitGradesDB(GradesDB db) {

    }

    @Override
    public void visitAttendanceDB(AttendanceDB db) {

    }

    @Override
    public void visitPaymentDB(PaymentBookDB db) {

    }
}
