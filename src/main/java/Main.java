import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale locale;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter language (en, fi, se, ja): ");
        String lang = sc.next();
        switch (lang) {
            case "fi" -> locale = new Locale("fi", "FI");
            case "se" -> locale = new Locale("se", "SE");
            case "ja" -> locale = new Locale("ja", "JP");
            default -> locale = new Locale("en", "US");
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);

        ShoppingCart shoppingCart = new ShoppingCart();
        String milkString = resourceBundle.getString("milk");
        String chocString = resourceBundle.getString("chocolate");
        int quantity;

        System.out.println(resourceBundle.getString("howMuch") + " (" + milkString + ")?");
        quantity = sc.nextInt();
        for (int i = 0; i < quantity; i++) {
            Item milk = new Item(milkString, 2);
            shoppingCart.addItem(milk);
        }
        System.out.println(resourceBundle.getString("itemCost") + milkString + ": " + shoppingCart.getTotalPriceForItem(milkString));

        System.out.println(resourceBundle.getString("howMuch") + " (" + chocString + ")?");
        quantity = sc.nextInt();
        for (int i = 0; i < quantity; i++) {
            Item chocolate = new Item(chocString, 4.5);
            shoppingCart.addItem(chocolate);
        }
        System.out.println(resourceBundle.getString("itemCost") + chocString + ": " + shoppingCart.getTotalPriceForItem(chocString));

        System.out.println(resourceBundle.getString("totalCost") + ": " + shoppingCart.getTotalPrice());

    }
}
