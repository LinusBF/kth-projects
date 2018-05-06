package model;

import integration.ItemDTO;

import java.util.Map;

/**
 * Created by Linus on 2018-05-05.
 */
public class Sale {
    private final double TAX = 25.7;

    private int memberId;
    private SaleInfo saleInfo = null;

    //Creates the instance of the object and creates an instance specific SaleInfo object
    public Sale(){
        this.saleInfo = new SaleInfo();
    }

    //Returns the SaleInfo object
    public SaleInfo getSaleInfo(){
        return this.saleInfo;
    }

    //Returns a Map of each item and the quantity of it in the basket
    public Map<ItemDTO, Integer> getItems(){
        return this.saleInfo.getItems();
    }

    //Adds an item to the current sale
    public void addToSale(ItemDTO item, int quantity){
        this.saleInfo.addItem(item, quantity);
    }

    //Returns the total of the sale with taxes applied
    public double getTotalWithTax(){
        return this.saleInfo.getTotal()*(1 + TAX / 100);
    }

    //Returns the amount of change to give to the customer
    public double pay(double amount){
        double amountToPay = getTotalWithTax();
        return amount - amountToPay;
    }

    //Applies a discount to the total of the sale
    public double applyDiscount(DiscountDTO discount){
        this.saleInfo.setDiscount(discount);

        return this.getTotalWithTax();
    }
}
