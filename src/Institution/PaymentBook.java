package Institution;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PaymentBook
{
    private int ID;
    private int studentID;
    private double price;
    private double investment;
    private Boolean isRepaid;
    private Calendar repaymentDate; // день погашения
    private Calendar appointmentDate; // день назначения платежа

    /**
     * Заметка для БД при поиске по дате - брать все платежи, чья дата назначения платежа меньше этой даты (спроси у Замиры, если непонятно)
     */

    public PaymentBook(int studentID)
    {
        this.studentID = studentID;
        this.price = 10000;
        this.investment = 0;
        this.isRepaid = false;
        this.appointmentDate = new GregorianCalendar();
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getStudentID()
    {
        return studentID;
    }


    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getInvestment()
    {
        return investment;
    }

    public void increaseInvestment(double investment)
    {
        this.investment += investment;
        if (investment >= price)
        {
            isRepaid = true;
            repaymentDate = new GregorianCalendar();
        }
    }

    public Boolean getRepaid()
    {
        return isRepaid;
    }

    public void setRepaid(Boolean repaid)
    {
        isRepaid = repaid;
    }

    public void setInvestment(double investment)
    {
        this.investment = investment;
    }

    public Calendar getRepaymentDate()
    {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate)
    {
        this.repaymentDate = new GregorianCalendar();
        this.repaymentDate.setTime(repaymentDate);
    }

    public Calendar getAppointmentDate()
    {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate)
    {
        this.appointmentDate = new GregorianCalendar();
        this.appointmentDate.setTime(appointmentDate);
    }
}
