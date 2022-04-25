package WorkWithDataBase;

import Institution.Grades;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.util.Collection;
import java.util.Date;

public class GradesDB implements WorkWithDataBase<Grades>, Element {
    @Override
    public Collection<Grades> load(int studentID) {
        return null;
    }

    @Override
    public Collection<Grades> load(Date date) {
        return null;
    }

    @Override
    public void write(Grades newItem) {

    }

    @Override
    public void accept(Visitor visitor) {

    }
}
