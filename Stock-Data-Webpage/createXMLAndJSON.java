import java.util.*;
import java.text.DecimalFormat;

public class Main
{
	public static void main(String[] args) {
	    Random rand = new Random();
	    String[] companyNames = {"Company N1, Company N2, Company N3, Company N4, Company N5, Company N6, Company N7, Company N8, Company N9, Company N10"};
	    Set<Currency> currencies = Currency.getAvailableCurrencies();
        String[] countryCodes = Locale.getISOCountries();
        String[] countries = new String[companyNames.length];
        String[] currencyTypes = new String[companyNames.length];
        int[] totalEmployees = new int[companyNames.length];
        for (int i = 0; i < companyNames.length; i++) {
            countries[i] = countryCodes[rand.nextInt(countryCodes.length)];
            totalEmployees[i] = rand.nextInt(200) + 1;
            int r = rand.nextInt(currencies.size());
		    int j = 0;
            for(Currency currency : currencies) {
                if (j == r) {
                  currencyTypes[i] = currency.getCurrencyCode();
                  break;
                }
                j++;
            }
        }
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        xml += "\n\n<allStocks xmlns:xs=\"http://www.w3.org/2001/XMLSchema-instance\" xs:noNamespaceSchemaLocation=\"Q1.xsd\">";
        String json = "{\n  \"allStocks\": {\n    \"stock\": [";
		  for (int i = 0; i < 100; i++) {
		    // Stock
		    xml += "\n\n  <stock>";
		    json += "\n\n      {";
		    
		    // Ticker symbol
		    char[] c = {(char)(rand.nextInt(26)+'A'), (char)(rand.nextInt(26)+'A'), (char)(rand.nextInt(26)+'A')};
		    xml += "\n    <tickerSymbol>" + c[0] + "" + c[1] + "" + c[2] + "</tickerSymbol>";
		    json += "\n        \"tickerSymbol\": \""+ c[0] + "" + c[1] + "" + c[2] + "\",";
		    
		    // Release date
		    int year = rand.nextInt(219) + 1800;
		    int month = rand.nextInt(12) + 1;
		    int day;
		    if (month == 2)
		        day = rand.nextInt(28) + 1;
		    else if (month == 4 || month == 6 || month == 9 || month == 11)
		        day = rand.nextInt(30) + 1;
		    else
		        day = rand.nextInt(31) + 1;
		    xml += "\n    <releaseDate>" + year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) + "</releaseDate>";
		    json += "\n        \"releaseDate\": \""+ year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) +"\",";
		    
		    // Price
		    int index = rand.nextInt(companyNames.length);
		    double price = rand.nextDouble() + rand.nextInt(100);
		    xml += "\n    <price currencyType=\"" + currencyTypes[index] +"\">" + String.format("%.2f", price) + "</price>";
		    json += "\n        \"price\": [{\"currencyType\": \"" + currencyTypes[index] + "\", \"value\": \"" + String.format("%.2f", price) + "\"}],";
		    
		    // Company
		    //    Name
		    xml += "\n    <company>\n      <name>" + companyNames[index] + "</name>";
		    json += "\n        \"company\": {\n          \"name\": \"" + companyNames[index] + "\",";
		    
		    //    Total Employees
		    xml += "\n      <totalEmployees>" + totalEmployees[index] + "</totalEmployees>";
		    json += "\n          \"totalEmployees\": \"" + totalEmployees + "\",";
		    
		    //    Country
		    xml += "\n      <country>" + countries[index] + "</country>";
		    json += "\n          \"country\": \"" + countries[index] + "\"";
		    
		    // End organization and stock
		    xml += "\n    </company>\n  </stock>";
		    json += "\n        }\n      }";
		    if (i < 99) json += ",";
	    }
      xml += "\n</allStocks>";
      json += "\n    ]\n  }\n}";
    
      System.out.println("\n\n ----------JSON----------:\n\n"+json);
      System.out.println("\n\n ----------XML----------:\n"+xml);
	}
}