import java.util.Comparator;

public class AtmCard extends Card  {
    private int amount;//so tien trong the

    public AtmCard(int amount) {
        this.amount = amount;
    }

    public AtmCard(String id, String cardNumber, String dateRelease, int type, int amount) {
        super(id, cardNumber, dateRelease, type);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  " Card id: " +       getId()             +
                " Card Numbers: "+   getCardNumber()     +
                " Date Release: "+   getDateRelease()    +
                " Type: "        +           getType()   +
                " Amount: "      +               amount  ;
    }



}
