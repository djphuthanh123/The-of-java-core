import java.util.Comparator;
import java.util.Date;

public abstract class Card  {
    private String id;
    private String cardNumber;
    private String dateRelease;
    private int type;

    public Card() {
    }

    public Card(String id, String cardNumber, String dateRelease, int type) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.dateRelease = dateRelease;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
