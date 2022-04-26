package Institution;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PaymentBook
{
    private int studentID;
    private double price;
    private double investment;
    private Boolean isRepaid;
    private Calendar repaymentDate;
    private Calendar appointmentDate;

    public PaymentBook(int studentID)
    {
        this.studentID = studentID;
        this.price = 10000;
        this.investment = 0;
        this.isRepaid = false;
        this.appointmentDate = new GregorianCalendar();
    }

    public int getStudentID()
    {
        return studentID;
    }

    public double getPrice()
    {
        return price;
    }

    public double getInvestment()
    {
        return investment;
    }

    public Boolean getRepaid()
    {
        return isRepaid;
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
    public void changePrice(double price)
    {
        this.price = price;
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
}
