package WorkWithDataBase;

import Institution.PaymentBook;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.util.Collection;
import java.util.Date;

public class PaymentBookDB implements WorkWithDataBase<PaymentBook>, Element {
    private static PaymentBookDB instance = null;

    private PaymentBookDB() {}

    public static PaymentBookDB getInstance()
    {
        if (instance == null)
            return new PaymentBookDB();
        else
            return instance;
    }

    @Override
    public Collection<PaymentBook> load(int studentID) {
        return null;
    }

    @Override
    public Collection<PaymentBook> load(Date date) {
        return null;
    }

    @Override
    public void write(PaymentBook newItem) {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPaymentDB(this);
    }
}
