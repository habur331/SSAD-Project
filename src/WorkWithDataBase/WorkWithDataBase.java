package WorkWithDataBase;

import java.util.Collection;
import java.util.Date;

public interface WorkWithDataBase <T>{

    Collection<T> load(int studentID);
    Collection<T> load(Date date);
    void write(T newItem);
}
