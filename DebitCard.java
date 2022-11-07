import java.util.Comparator;
import java.util.Date;

public class DebitCard extends Card  {
    private String dateValid;//
    private int amountRemaind;// so tien trong the


    public DebitCard(String dateValid, int amountRemaind) {
        this.dateValid = dateValid;
        this.amountRemaind = amountRemaind;
    }

    public DebitCard(String id, String cardNumber, String dateRelease, int type, String dateValid, int amountRemaind) {
        super(id, cardNumber, dateRelease, type);
        this.dateValid = dateValid;
        this.amountRemaind = amountRemaind;
    }

    public String getDateValid() {
        return dateValid;
    }

    public void setDateValid(String dateValid) {
        this.dateValid = dateValid;
    }

    public int getAmountRemaind() {
        return amountRemaind;
    }

    public void setAmountRemaind(int amountRemaind) {
        this.amountRemaind = amountRemaind;
    }

    @Override
    public String toString() {
        return  " Card id: "              + getId()           +
                " Card Numbers: "        +getCardNumber()    +
                " Date Release: "        +getDateRelease()   +
                " Type: "                +getType()          +
                " Date Valid: "          +getDateValid()     +
                " Amount Remaind: "+     getAmountRemaind();


    }


}
