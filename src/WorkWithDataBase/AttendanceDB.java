package WorkWithDataBase;

import Institution.Attendance;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.util.Collection;
import java.util.Date;

public class AttendanceDB implements WorkWithDataBase<Attendance>, Element {
    private static AttendanceDB instance = null;

    private AttendanceDB() {}

    public static AttendanceDB getInstance()
    {
        if (instance == null)
            return new AttendanceDB();
        else
            return instance;
    }
    @Override
    public Collection<Attendance> load(int studentID) {
        return null;
    }

    @Override
    public Collection<Attendance> load(Date date) {
        return null;
    }

    @Override
    public void write(Attendance newItem) {

    }

    @Override
    public void accept(Visitor visitor) {

    }
}
