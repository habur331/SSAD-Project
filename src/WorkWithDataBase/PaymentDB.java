package WorkWithDataBase;

import Institution.Payment;
import PatternVisitor.Element;
import PatternVisitor.Visitor;

import java.util.Collection;
import java.util.Date;

public class PaymentDB implements WorkWithDataBase<Payment>, Element {
    @Override
    public Collection<Payment> load(int studentID) {
        return null;
    }

    @Override
    public Collection<Payment> load(Date date) {
        return null;
    }

    @Override
    public void write(Payment newItem) {

    }

    @Override
    public void accept(Visitor visitor) {

    }
}
