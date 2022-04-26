package WorkWithDataBase;

import Institution.Attendance;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class AttendanceDB implements WorkWithDataBase<Attendance>, Element
{
    private static AttendanceDB instance = null;
    private final DataBase db = new DataBase();

    private AttendanceDB()
    {
    }

    public static AttendanceDB getInstance()
    {
        if (instance == null)
            instance = new AttendanceDB();
        return instance;
    }

    @Override
    public Collection<Attendance> load(int studentID)
    {
        Collection<Attendance> data = new ArrayList<>();
        for (Attendance attendant : db.getAttendanceTable())
        {
            if (attendant.getStudentID() == studentID)
            {
                data.add(attendant);
            }
        }
        return data;
    }

    @Override
    public Collection<Attendance> load(Date date)
    {
        Collection<Attendance> data = new ArrayList<>();
        for (Attendance attendant : db.getAttendanceTable())
        {
            if (attendant.getDate().equals(date))
            {
                data.add(attendant);
            }
        }
        return data;
    }

    @Override
    public void write(Attendance newItem)
    {
        db.removeAttendance(newItem);
        db.addAttendance(newItem);
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visitAttendanceDB(this);
    }
}
