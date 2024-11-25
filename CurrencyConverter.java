import java.util.Scanner;

public class CurrencyConverter {

    // Define conversion rates (source to target currency)
    static double[][] conversionRates = {
        {1.0, 0.93, 84.5, 1.42, 113.2},  // USD to others (EUR, INR, GBP, JPY)
        {1.07, 1.0, 91.2, 1.53, 122.2},  // EUR to others (USD, INR, GBP, JPY)
        {0.012, 0.011, 1.0, 0.017, 1.35}, // INR to others (USD, EUR, GBP, JPY)
        {0.70, 0.65, 58.8, 1.0, 80.0},   // GBP to others (USD, EUR, INR, JPY)
        {0.0088, 0.0082, 0.74, 0.012, 1.0}  // JPY to others (USD, EUR, INR, GBP)
    };

    // Currency labels
    static String[] currencyOptions = {"USD", "EUR", "INR", "GBP", "JPY"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the currency options
        System.out.println("Currency options:");
        for (int i = 0; i < currencyOptions.length; i++) {
            System.out.println((i + 1) + ": " + currencyOptions[i]);
        }

        // Ask the user to select source currency (A1) with validation
        int fromCurrency = getValidCurrencyOption(scanner, "Select the source currency (1-5): ");

        // Ask the user to select target currency (A2) with validation
        int toCurrency = getValidCurrencyOption(scanner, "Select the target currency (1-5): ");

        // Ask the user to input the amount in source currency
        System.out.print("Enter the amount in " + currencyOptions[fromCurrency] + ": ");
        double amount = scanner.nextDouble();

        // Perform the conversion
        double convertedAmount = amount * conversionRates[fromCurrency][toCurrency];

        // Display the result
        System.out.printf("%.2f %s = %.2f %s\n", amount, currencyOptions[fromCurrency], convertedAmount, currencyOptions[toCurrency]);

        scanner.close();
    }

    // Method to get a valid currency option from the user
    private static int getValidCurrencyOption(Scanner scanner, String message) {
        int option;
        while (true) {
            System.out.print(message);
            option = scanner.nextInt() - 1; // Subtract 1 to match array indices (0-4)
            if (option >= 0 && option < currencyOptions.length) {
                return option;
            } else {
                System.out.println("Invalid option. Please select a valid currency option (1-5).");
            }
        }
    }
}
