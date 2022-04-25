package WorkWithDataBase;

import Institution.Student;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Date;

public class StudentDB implements WorkWithDataBase<Student>
{

    private static StudentDB instance = null;

    private StudentDB()
    {
    }

    public static StudentDB getInstance()
    {
        if (instance == null)
            instance = new StudentDB();
        return instance;
    }

    @Override
    public Collection<Student> load(int studentID)
    {
        return null;
    }

    @Override
    public Collection<Student> load(Date date)
    {
        // не нужно имплементировать
        throw new NotImplementedException();
    }

    @Override
    public void write(Student newItem)
    {

    }
}
