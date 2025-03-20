import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private static ShoppingCart shoppingCart;
    private static Item milk;

    @BeforeAll
    static void init() {
        shoppingCart = new ShoppingCart();
        milk = new Item("milk", 2);
    }

    @BeforeEach
    void reset() {
        shoppingCart.getItems().clear();
    }

    @org.junit.jupiter.api.Test
    void addItem() {
        shoppingCart.addItem(milk);
        assertEquals("milk", shoppingCart.getItems().getFirst().getName());
    }

    @org.junit.jupiter.api.Test
    void getTotalPriceForItem() {
        for (int i = 0; i < 10; i++) {
            Item juice = new Item("juice", 3.2);
            shoppingCart.addItem(juice);
        }
        assertEquals(32, shoppingCart.getTotalPriceForItem("juice"), 0.01);
    }

    @org.junit.jupiter.api.Test
    void getTotalPrice() {
        for (int i = 0; i < 10; i++) {
            Item juice = new Item("juice", 3.2);
            Item chocolate = new Item("chocolate",4.5);
            shoppingCart.addItem(juice);
            shoppingCart.addItem(chocolate);
        }
        assertEquals(77, shoppingCart.getTotalPrice(), 0.01);
    }
}