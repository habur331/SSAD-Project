package Institution;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    private int ID;
    private final String Name;
    private final String LastName;
    private final Calendar birthday;

    public Person(String name, String lastName, Date birthday) {
        Name = name;
        LastName = lastName;
        this.birthday = new GregorianCalendar();
        this.birthday.setTime(birthday);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

}
