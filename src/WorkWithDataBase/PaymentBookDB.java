package WorkWithDataBase;

import Institution.PaymentBook;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class PaymentBookDB implements WorkWithDataBase<PaymentBook>, Element
{
    private static PaymentBookDB instance = null;
    private final DataBase db = DataBase.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private PaymentBookDB()
    {
    }

    public static PaymentBookDB getInstance()
    {
        if (instance == null)
            instance = new PaymentBookDB();
        return instance;
    }

    @Override
    public Collection<PaymentBook> load(int studentID)
    {
        Collection<PaymentBook> data = new ArrayList<>();
        for (PaymentBook payment : db.getPaymentBookTable())
        {
            if (payment.getStudentID() == studentID)
            {
                data.add(payment);
            }
        }
        return data;
    }

    @Override
    public Collection<PaymentBook> load(Calendar date)
    {
        Collection<PaymentBook> data = new ArrayList<>();
        for (PaymentBook payment : db.getPaymentBookTable())
        {
            if (sdf.format(payment.getAppointmentDate().getTime()).equals(sdf.format(date.getTime())))
            {
                data.add(payment);
            }
        }
        return data;
    }

    @Override
    public void write(PaymentBook newItem)
    {
        db.removePaymentBook(newItem);
        db.addPaymentBook(newItem);
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visitPaymentDB(this);
    }
}
