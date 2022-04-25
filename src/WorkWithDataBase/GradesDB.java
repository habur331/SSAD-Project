package WorkWithDataBase;

import Institution.Grade;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.util.Collection;
import java.util.Date;

public class GradesDB implements WorkWithDataBase<Grade>, Element {
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

    }
}
