import java.util.Comparator;

public class CreditCard extends Card {
    private String dateValid; // ngay het han
    private int amountDue; // tien du no cua the
    private int amountMax; // han muc chi tieu

    public CreditCard(String dateValid, int amountDue, int amountMax) {
        this.dateValid = dateValid;
        this.amountDue = amountDue;
        this.amountMax = amountMax;
    }

    public CreditCard(String id, String cardNumber, String dateRelease, int type, String dateValid, int amountDue, int amountMax) {
        super(id, cardNumber, dateRelease, type);
        this.dateValid = dateValid;
        this.amountDue = amountDue;
        this.amountMax = amountMax;
    }

    public String getDateValid() {
        return dateValid;
    }

    public void setDateValid(String dateValid) {
        this.dateValid = dateValid;
    }

    public int getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(int amountDue) {
        this.amountDue = amountDue;
    }

    public int getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(int amountMax) {
        this.amountMax = amountMax;
    }

    @Override
    public String toString() {
    return  " Card id: "          + getId()           +
            " Card Numbers: "    +getCardNumber()    +
            " Date Release: "    +getDateRelease()   +
            " Type: "            +getType()          +
            " Date Valid: "      +getDateValid()     +
            " Amount Due: "      +getAmountDue()     +
            " Amount Max: "     +amountMax;}


}
