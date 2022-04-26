package WorkWithDataBase;

import Institution.Attendance;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class AttendanceDB implements WorkWithDataBase<Attendance>, Element
{
    private static AttendanceDB instance = null;
    private final DataBase db = DataBase.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

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
    public Collection<Attendance> load(Calendar date)
    {
        Collection<Attendance> data = new ArrayList<>();
        for (Attendance attendant : db.getAttendanceTable())
        {
            if (sdf.format(attendant.getDate().getTime()).equals(sdf.format(date.getTime())))
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
