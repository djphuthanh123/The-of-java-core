import java.io.IOException;

public class MyMain {
    public static void main(String[] args) throws IOException {
        ProcessCard processCard = new ProcessCard();
        ProcessTransaction processTransaction = new ProcessTransaction();
        while (true) {
            int choice = Validation.inputInt("Enter choice:", 1, 8);
            switch (choice) {
                case 1:
                    processCard.createCard();
                    break;
                case 2:
                    processCard.readInformation();
                    break;
                case 3:
                    processCard.writeFile();
                    break;
                case 4:
                    processCard.sorting();
                    break;
                case 5:
                    processTransaction.processDealing();
                    break;
                case 6:
                    processTransaction.readFile();
                    break;
                case 7:
                    processTransaction.printTransaction();
                    break;
                case 8:
                    processTransaction.findHighest();
                    break;
                default: return;
            }
        }
    }
}
