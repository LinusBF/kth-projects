package model;

import integration.ItemDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Linus on 2018-05-05.
 */
public class SaleInfo {
    private double total = 0;
    private DiscountDTO discount;
    private Map<ItemDTO, Integer> items;

    SaleInfo(){
        this.items = new HashMap<>();
    }

    void addItem(ItemDTO item, int quantity){
        if(!items.containsKey(item)) {
            this.items.put(item, quantity);
        } else{
            this.items.replace(item, this.items.get(item) + quantity);
        }
        this.total += item.getPrice() * quantity;
    }

    //Returns the total value of the sale, with discounts applied if it exists
    public double getTotal() {
        double totalWithDiscounts = this.total;
        if(this.discount != null){
            totalWithDiscounts = totalWithDiscounts * ((100 - this.discount.getPercentage()) / 100);
        }
        return totalWithDiscounts;
    }

    DiscountDTO getDiscount() {
        return this.discount;
    }

    void setDiscount(DiscountDTO dis){
        this.discount = dis;
    }

    Map<ItemDTO, Integer> getItems() {
        return this.items;
    }
}
