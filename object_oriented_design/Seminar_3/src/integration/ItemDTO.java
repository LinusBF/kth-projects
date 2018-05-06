package integration;

/**
 * Created by Linus on 2018-05-05.
 */
public class ItemDTO {
    private int itemId;
    private double price;
    private String description;

    ItemDTO(int itemId, double price, String description) {
        this.itemId = itemId;
        this.price = price;
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    //Returns a string that represents the item and the price of the item depending on the quantity of the item.
    public String toDisplay(int quantity) {
        return description + "\nPrice: " + String.format("%.2f", price * quantity);
    }
}
