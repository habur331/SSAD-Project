package PatternVisitor;

import WorkWithDataBase.AttendanceDB;
import WorkWithDataBase.GradeDB;
import WorkWithDataBase.PaymentBookDB;

import java.util.Date;

public class ReportByDayVisitor implements Visitor{

    private Date date;

    public ReportByDayVisitor(Date date) {
        this.date = date;
    }

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
