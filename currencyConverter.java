import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import org.json.JSONObject;

public class encryptix1 {

    public static void main(String[] args) {
        String[] availableCurrencies = {"USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available currencies:");
        for (String currency : availableCurrencies) {
            System.out.print(currency + " ");
        }
        System.out.println();

        System.out.print("Enter the base currency: ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        boolean validBaseCurrency = false;
        boolean validTargetCurrency = false;

        for (String currency : availableCurrencies) {
            if (currency.equals(baseCurrency)) {
                validBaseCurrency = true;
            }
            if (currency.equals(targetCurrency)) {
                validTargetCurrency = true;
            }
        }

        if (!validBaseCurrency || !validTargetCurrency) {
            System.out.println("Invalid currency selection.");
            return;
        }

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);
        if (convertedAmount != -1) {
            System.out.printf("Converted amount: %.2f %s%n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Error fetching exchange rate.");
        }

        scanner.close();
    }

    private static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        try {
            String apiKey = "YOUR_API_KEY"
            String apiUrl = String.format("https://open.er-api.com/v6/latest/%s", baseCurrency);

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("apikey", apiKey);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStream responseStream = connection.getInputStream();
                Scanner scanner = new Scanner(responseStream);
                String responseBody = scanner.useDelimiter("\\A").next();
                scanner.close();

                JSONObject jsonObject = new JSONObject(responseBody);
                double exchangeRate = jsonObject.getJSONObject("rates").getDouble(targetCurrency);
                return amount * exchangeRate;
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
