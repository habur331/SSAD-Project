package WorkWithDataBase;

import Institution.Grade;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class GradeDB implements WorkWithDataBase<Grade>, Element {
    private static GradeDB instance = null;
    private final DataBase db = new DataBase();

    private GradeDB() {}

    public static GradeDB getInstance()
    {
        if (instance == null)
            instance = new GradeDB();

            return instance;
    }

    @Override
    public Collection<Grade> load(int studentID) {
        Collection<Grade> data = new ArrayList<>();
        for(Grade grade: db.getGradeTable()){
            if(grade.getStudentID() == studentID){
                data.add(grade);
            }
        }
        return data;
    }

    @Override
    public Collection<Grade> load(Calendar date) {
        Collection<Grade> data = new ArrayList<>();
        for(Grade grade: db.getGradeTable()){
            if(grade.getDate().equals(date)){
                data.add(grade);
            }
        }
        return data;
    }

    @Override
    public void write(Grade newItem) {
        db.removeGrade(newItem);
        db.addGrade(newItem);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitGradesDB(this);
    }
}
