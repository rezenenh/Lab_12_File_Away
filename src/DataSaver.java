import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        System.out.println("Enter User Data. Type 'exit' in First Name field to finish.");

        while (true) {
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name: ");
            if (firstName.equalsIgnoreCase("exit")) {
                break;
            }
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name: ");
            int idNumber = SafeInput.getInt(scanner, "Enter ID Number (6 digits): ");
            String email = SafeInput.getNonZeroLenString(scanner, "Enter Email: ");
            int yearOfBirth = SafeInput.getInt(scanner, "Enter Year of Birth (4 digits): ");

            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);
        }
        if (records.isEmpty()) {
            System.out.println("No data to save.");
        } else {
            String fileName = SafeInput.getNonZeroLenString(scanner, "Enter the file name (with .csv extension): ");

            try (FileWriter writer = new FileWriter("src/" + fileName)) {
                for (String record : records) {
                    writer.write(record + "\n");
                }
                System.out.println("Data saved to " + fileName);
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
