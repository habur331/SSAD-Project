package Institution;

import java.util.Date;

public class Person {
    private int ID;
    private String Name;
    private String LastName;
    private Date birthday;

    public Person(String name, String lastName, Date birthday) {
        Name = name;
        LastName = lastName;
        this.birthday = birthday;
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
