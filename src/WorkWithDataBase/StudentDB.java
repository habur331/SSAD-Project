package WorkWithDataBase;

import Institution.Student;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class StudentDB implements WorkWithDataBase<Student>
{

    private static StudentDB instance = null;
    private final DataBase db = DataBase.getInstance();

    private StudentDB() {}

    public static StudentDB getInstance() {
        if (instance == null)
            instance = new StudentDB();
        return instance;
    }

    @Override
    public Collection<Student> load(int studentID) {
        Collection<Student> data = new ArrayList<>();
        for(Student student: db.getStudentTable()){
            if(student.getID() == studentID){
                data.add(student);
            }
        }
        return data;
    }

    @Override
    public Collection<Student> load(Calendar date) {
        // не нужно имплементировать
        throw new NotImplementedException();
    }

    @Override
    public void write(Student newItem) {
        db.removeStudent(newItem);
        db.addStudent(newItem);
    }
}
