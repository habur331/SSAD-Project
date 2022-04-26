package WorkWithDataBase;

import Institution.Attendance;
import Institution.Grade;
import Institution.PaymentBook;
import Institution.Student;

import java.util.ArrayList;
import java.util.Collection;

public class DataBase {
    private final Collection<Attendance> AttendanceTable = new ArrayList<>();
    private final Collection<Grade> GradeTable = new ArrayList<>();
    private final Collection<PaymentBook> PaymentBookTable = new ArrayList<>();
    private final Collection<Student> StudentTable = new ArrayList<>();
    private static DataBase instance = null;


    public static DataBase getInstance() {
        if (instance == null)
            instance = new DataBase();
        return instance;
    }

    private DataBase() {
    }

    public Collection<Attendance> getAttendanceTable() {
        return AttendanceTable;
    }

    public void addAttendance(Attendance newItem) {
        AttendanceTable.add(newItem);
    }

    public boolean removeAttendance(Attendance removeItem) {
        return AttendanceTable.remove(removeItem);
    }

    public Collection<Grade> getGradeTable() {
        return GradeTable;
    }

    public void addGrade(Grade newItem) {
        GradeTable.add(newItem);
    }

    public boolean removeGrade(Grade removeItem) {
        return GradeTable.remove(removeItem);
    }

    public Collection<PaymentBook> getPaymentBookTable() {
        return PaymentBookTable;
    }

    public void addPaymentBook(PaymentBook newItem) {
        PaymentBookTable.add(newItem);
    }

    public boolean removePaymentBook(PaymentBook removeItem) {
        return PaymentBookTable.remove(removeItem);
    }

    public Collection<Student> getStudentTable() {
        return StudentTable;
    }

    public void addStudent(Student newItem) {
        StudentTable.add(newItem);
    }

    public boolean removeStudent(Student removeItem) {
        return StudentTable.remove(removeItem);
    }
}
