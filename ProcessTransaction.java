import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProcessTransaction {
    static ArrayList<Transaction> transactions = new ArrayList<>();
    public void readTransaction() {

    }

    public void processDealing() {
        int choice = Validation.inputInt("Input you choice ", 1, 3);
        String id = Validation.inputString("Enter id: ", Validation.NAME);
        switch (choice) {
            case 1:
                processCredit(id);
            case 2:
                processDebit(id);
            case 3:
                processATM(id);
        }
    }


    public void processCredit(String id) {
        Card card = ProcessCard.findId(id);
        String transactionID = Validation.inputString("Enter transaction id :", Validation.NAME);
        Date transactionDate = Calendar.getInstance().getTime();
        if (card instanceof CreditCard creditCard) {
            do {
                int amountDue = Validation.inputInt("Enter amount due of credit card:", 0, Integer.MAX_VALUE);
                int money = Validation.inputInt("Enter money: ", 0, Integer.MAX_VALUE);
                if ((amountDue + money) > ((CreditCard) card).getAmountMax()) System.err.println("amount need to be less than amount max ");
                creditCard.setAmountDue(creditCard.getAmountDue() + money);
                String note = Validation.inputString("Note : ", ".+");
                transactions.add(new Transaction(transactionID, card.getId(), transactionDate, money, note));
            } while (Validation.checkInputYN("Are you want continuous ?: ==> plz Input Y for continues and N for Stop "));
        }
    }
    public void processDebit(String id){
        Card card = ProcessCard.findId(id);
        String transactionID = Validation.inputString("Enter transaction id :", Validation.NAME);
        Date transactionDate = Calendar.getInstance().getTime();
        if (card instanceof DebitCard debitCard) {
            do {
                int amountRemaind = Validation.inputInt("Enter amount remaind: ", 0, Integer.MAX_VALUE);
                int money = Validation.inputInt("Enter money: ", 0, Integer.MAX_VALUE);
                if (amountRemaind < money) System.err.println("amount remaind need to be > money");
                debitCard.setAmountRemaind(debitCard.getAmountRemaind()-money);
                String note = Validation.inputString("Note : ", ".+");
                transactions.add(new Transaction(transactionID, card.getId(), transactionDate, money, note));
            } while (Validation.checkInputYN("Are you want continuous ?: ==> plz Input Y for continues and N for Stop "));
        }
    }
    public void processATM(String id){
        Card card = ProcessCard.findId(id);
        String transactionID = Validation.inputString("Enter transaction id :", Validation.NAME);
        Date transactionDate = Calendar.getInstance().getTime();
        if (card instanceof AtmCard atmCard) {
            do {
                int amount = Validation.inputInt("Enter amonnt:",0,Integer.MAX_VALUE);
                int money = Validation.inputInt("Enter money: ", 0, Integer.MAX_VALUE);
                if (amount < money) System.err.println("amount remaind need to be > money");
                atmCard.setAmount(atmCard.getAmount() - money);
                String note = Validation.inputString("Note : ", ".+");
                transactions.add(new Transaction(transactionID, card.getId(), transactionDate, money, note));
            } while (Validation.checkInputYN("Are you want continuous ?: ==> plz Input Y for continues and N for Stop "));
        }
    }
    public void readFile() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/TransactionHistory.txt"));
            String lineText;
            while ((lineText = in.readLine()) != null) {
                String[] line = lineText.split(",");
                transactions.add(new Transaction(line[0],line[1],dateFormat.parse(line[2]),Integer.parseInt(line[3]),line[4]));
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public void printTransaction() {
        for (Transaction c : transactions) {
            System.out.println(c.toString());
        }
    }
    public void findHighest() {
        transactions.sort(Comparator.comparingInt(Transaction::getMoney));
        Collections.reverse(transactions);
        System.out.println("Highest money dealing: " + transactions.get(0).getTransactionID() + "with money" + transactions.get(0).getMoney());
        System.out.println("Highest money dealing: " + transactions.get(1).getTransactionID() + "with money" + transactions.get(1).getMoney());
        System.out.println("Highest money dealing: " + transactions.get(3).getTransactionID() + "with money" + transactions.get(3).getMoney());

    }



}
