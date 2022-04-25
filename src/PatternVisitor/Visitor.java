package PatternVisitor;

import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;

public interface Visitor {
    void visitGradesDB(GradeDB db);
    void visitAttendanceDB(AttendanceDB db);
    void visitPaymentDB(PaymentBookDB db);
}
