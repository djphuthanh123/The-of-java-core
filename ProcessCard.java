
import java.io.*;
import java.util.*;


public class ProcessCard {

    static List<Card> cards = new ArrayList<>();

    static public Card findId(String id) {
        for (Card card : cards) {
            if (card.getId().equalsIgnoreCase(id)) return card;
        }
        return null;
    }

    public void createCard() throws IOException {
        do {
            String id = Validation.inputString("Enter id :", Validation.NAME);
            String cardNumber = generationCardNumber();
            String dateRl = Validation.inputDate("Enter date rl:");
            int choice = Validation.inputInt("Enter type of card |1.Credit card |2.Debit Card|3.Atm Card:", 1, 3);
            switch (choice) {
                case 1 -> createCreditCard(id, cardNumber, dateRl, choice);
                case 2 -> createDebitCard(id, cardNumber, dateRl, choice);
                case 3 -> createAtmCard(id, cardNumber, dateRl, choice);
            }
        } while (Validation.checkInputYN("Are you want continuous ?: ==> plz Input Y for continues and N for Stop"));
    }

    public void createCreditCard(String id, String cardNumber, String dateRelease, int choice) {
        String dateValid = Validation.inputDate("Enter date valid"); // ngay het han
        int amountDue = 0; // tien du no cua the
        int amountMax = Validation.inputInt("Enter amount max: ", 0, Integer.MAX_VALUE); // han muc chi tieu
        cards.add(new CreditCard(id, cardNumber, dateRelease, choice, dateValid, amountDue, amountMax));
    }

    public void createDebitCard(String id, String cardNumber, String dateRelease, int choice) {
        String dateValid = Validation.inputDate("Enter date valid :");
        int amountRemaind = Validation.inputInt("Enter amount remaind: ", 1, Integer.MAX_VALUE);// so tien trong the
        cards.add(new DebitCard(id, cardNumber, dateRelease, choice, dateValid, amountRemaind));
    }

    public void createAtmCard(String id, String cardNumber, String dateRelease, int choice) {
        int amount = Validation.inputInt("Enter amount ", 0, Integer.MAX_VALUE);
        cards.add(new AtmCard(id, cardNumber, dateRelease, choice, amount));
    }

    public void readInformation() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/CardI4.txt"));
        String lineText;
        try {
            while ((lineText = in.readLine()) != null) {
                String[] line = lineText.split(",");
                if (Integer.parseInt(line[3]) == 1) {
                    cards.add(new CreditCard(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4], Integer.parseInt(line[5]), Integer.parseInt(line[6])));
                } else if (Integer.parseInt(line[3]) == 2) {
                    cards.add(new DebitCard(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4], Integer.parseInt(line[5])));
                } else {
                    cards.add(new AtmCard(line[0], line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                }
            }
            in.close();
        } catch (
                IOException e) {
            System.out.println("File Read Error");
        }

    }
    public void writeFile() throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/CardI4.txt", true)))) {
            for (Card card:cards) {
                out.write(card.getCardNumber() + " "+ card.getDateRelease());
                if (card instanceof CreditCard creditCard) out.write(creditCard.toString());
                else if (card instanceof DebitCard debitCard) out.write(debitCard.toString());
                else if (card instanceof AtmCard atmCard) out.write(atmCard.toString());
                out.write("\n");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void sorting() {
        cards.sort((s1, s2) -> {
            if (s1.getDateRelease() != null && s2.getDateRelease() != null && s1.getDateRelease().compareTo(s2.getDateRelease()) != 0) {
                return s1.getDateRelease().compareTo(s2.getDateRelease());
            } else {
                String[] b1 = s1.getId().split(" ");
                int lastIndexOfb1 = b1.length -1;
                String[] b2 = s1.getId().split(" ");
                int lastIndexOfb2 = b2.length -1;
                return b1[lastIndexOfb1].compareTo(b2[lastIndexOfb2]);
            }
        });
        cards.forEach(System.out::println);
        }

    public String generationCardNumber() {
        StringBuilder str = new StringBuilder("1681000");
        for (int i = 0; i < 6; i++) {
            str.append((char) ('0' + Math.random() * ('9' - '0' + 1)));
        }
        return str.toString();

    }

    public void printCard() {
        for (Card c : cards) {
            System.out.println(c.getCardNumber());
        }
    }


}
