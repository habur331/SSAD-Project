package Institution;

import java.util.Date;
import java.util.GregorianCalendar;

public class PaymentBook {
    private int ID;
    private int studentID;
    private double price;
    private double investment;
    private Boolean isRepaid;
    private Date repaymentDate; // день погашения
    private Date appointmentDate; // день назначения платежа

    /**
     * Заметка для БД при поиске по дате - брать все платежи, чья дата назначения платежа меньше этой даты(спроси у Замиры, если непонятно)

     */

    public PaymentBook(int studentID) {
        this.studentID = studentID;
        this.price = 1000;
        this.investment = 0;
        this.isRepaid = false;
        this.appointmentDate = new GregorianCalendar().getTime();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getInvestment() {
        return investment;
    }

    public void increaseInvestment(double investment) {
        this.investment += investment;
        if (investment >= price)
        {
            isRepaid = true;
            repaymentDate = new GregorianCalendar().getTime();
        }
    }

    public Boolean getRepaid() {
        return isRepaid;
    }

    public void setRepaid(Boolean repaid) {
        isRepaid = repaid;
    }
}
