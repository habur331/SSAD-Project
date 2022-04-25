package WorkWithDataBase;

import Institution.Grade;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.util.Collection;
import java.util.Date;

public class GradeDB implements WorkWithDataBase<Grade>, Element {
    private static GradeDB instance = null;

    private GradeDB() {}

    public static GradeDB getInstance()
    {
        if (instance == null)
            return new GradeDB();
        else
            return instance;
    }

    @Override
    public Collection<Grade> load(int studentID) {
        return null;
    }

    @Override
    public Collection<Grade> load(Date date) {
        return null;
    }

    @Override
    public void write(Grade newItem) {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitGradesDB(this);
    }
}
