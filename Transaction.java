import java.util.Date;

public class Transaction {
    private String transactionID;
    private String cardID;
    private Date transactionDate;
    private int money;
    private String note;

    public Transaction(String transactionID, String cardID, Date transactionDate, int money, String note) {
        this.transactionID = transactionID;
        this.cardID = cardID;
        this.transactionDate = transactionDate;
        this.money = money;
        this.note = note;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Transaction{"                                   +
                "transactionID='"       + transactionID         + '\''                      +
                ", cardID='"            + cardID                + '\''                      +
                ", transactionDate='"   + transactionDate       + '\'' +
                ", money="              + money                 +
                ", note='"              + note                  + '\'' +
                '}';
    }
}
