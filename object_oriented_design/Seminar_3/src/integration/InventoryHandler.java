package integration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Linus on 2018-05-05.
 */
public class InventoryHandler {
    private Map<Integer, ItemStock<ItemDTO, Integer>> items;

    //Creates instance of object and initiates a "Database" of items, each with 10 in stock
    public InventoryHandler(){
        items = new HashMap<>();
        items.put(1, new ItemStock<>(new ItemDTO(1, 14.99, "Sour cream"), 10));
        items.put(2, new ItemStock<>(new ItemDTO(2, 29.99, "Tortillas"), 10));
        items.put(3, new ItemStock<>(new ItemDTO(3, 9.99, "Salsa"), 10));
        items.put(4, new ItemStock<>(new ItemDTO(4, 49.99, "Ground beef"), 10));
        items.put(5, new ItemStock<>(new ItemDTO(5, 4.99, "Spice mix"), 10));
        items.put(6, new ItemStock<>(new ItemDTO(6, 9.99, "Corn"), 10));
    }

    //Returns the ItemDTO of the item asked for
    public ItemDTO getItemInfo(int itemId){
        return this.items.get(itemId).getItem();
    }

    //Removes the amount specified in "quantity" from the active stock of the item
    public boolean removeFromStock(int itemId, int quantity){
        ItemStock<ItemDTO, Integer> item = items.get(itemId);
        if(item.getStock() >= quantity){
            item.setStock(item.getStock() - quantity);
            return true;
        } else{
            return false;
        }
    }

    private class ItemStock<I, S>{
        private I item;
        private S stock;

        ItemStock(I item, S stock){
            this.item = item;
            this.stock = stock;
        }

        I getItem(){ return item; }

        S getStock(){ return stock; }

        void setStock(S stock){
            this.stock = stock;
        }
    }
}
