import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    protected static final String NAME
            = "[A-Za-z0-9\\s]+";
    private final static Scanner sc = new Scanner(System.in);

    public static int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number ");
            }
        }
    }


    public static String inputString(String string, String regex) {
        System.out.print(string);
        while (true) {
            String input = sc.nextLine();
            if (!input.matches(regex)) {
                System.out.println("Plz input  followed the regex: " + regex);
                continue;
            }
            if (input.equals(" ")) {
                System.out.print("Plz input a non-empty string: ");
                continue;
            }
            return input;
        }
    }

    public static String inputDate(String string) {
        System.out.print(string);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            String input = sc.nextLine();
            try {
                Date date1 = dateFormat.parse(input);
                Date currentDate = Calendar.getInstance().getTime();// get current date of computer
                if (currentDate.compareTo(date1) < 0) {
                    System.err.println("Plz select right this regex " + currentDate);
                    continue;
                }
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(date1);
            } catch (Exception e) {
                System.out.print("Plz input valid date (dd/MM/yyyy): ");
            }
        }
    }

    public static boolean checkInputYN(String string) {
        System.out.println(string);
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static Double inputDouble(String mess, double min, double max) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number ");
            }
        }
    }


}
