package PatternVisitor;

import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradesDB;
import WorkWithDataBase.PaymentBookDB;

public interface Visitor {
    void visitGradesDB(GradesDB db);
    void visitAttendanceDB(AttendanceDB db);
    void visitPaymentDB(PaymentBookDB db);
}
