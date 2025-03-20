import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPriceForItem(String name) {
        double price = 0;
        for (Item item: items) {
            if (item.getName().equals(name)) {
                price += item.getPrice();
            }
        }
        return price;
    }

    public double getTotalPrice() {
        double price = 0;
        for (Item item: items) {
            price += item.getPrice();
        }
        return price;
    }
}
