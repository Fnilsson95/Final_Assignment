import java.util.Scanner;

public class IOScanner {
    //Initializing Scanner
    Scanner input = new Scanner(System.in);
    // Retrieve integer input
    public int getInt() {
        return input.nextInt();
    }
    // Retrieve double input
    public double getDouble() {
        return input.nextDouble();
    }
    // Retrieving String input and nextLine();
    public String getNextLine() {
        return input.nextLine();
    }
    // Closing scanner.
    public void closeScanner() {
        input.close();
    }
}
