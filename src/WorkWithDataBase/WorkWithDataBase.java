package WorkWithDataBase;

import java.util.Calendar;
import java.util.Collection;

public interface WorkWithDataBase<T> {
    Collection<T> load(int studentID);

    Collection<T> load(Calendar date);

    void write(T newItem);
}
