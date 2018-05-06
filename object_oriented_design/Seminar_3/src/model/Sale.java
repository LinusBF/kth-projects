package model;

import integration.ItemDTO;

import java.util.Map;

/**
 * Created by Linus on 2018-05-05.
 */
public class Sale {
    private final double TAX = 25.7;

    private DiscountDTO discount = null;
    private SaleInfo saleInfo = null;

    public Sale(){
        this.saleInfo = new SaleInfo();
    }

    public SaleInfo getSaleInfo(){
        return this.saleInfo;
    }

    public Map<ItemDTO, Integer> getItems(){
        return this.saleInfo.getItems();
    }

    public void addToSale(ItemDTO item, int quantity){
        this.saleInfo.addItem(item, quantity);
    }

    public double getTotalWithTax(){
        return this.saleInfo.getTotal()*(1 + TAX / 100);
    }

    public double pay(double amount){
        double amountToPay = getTotalWithTax();
        return amount - amountToPay;
    }

    public double applyDiscount(DiscountDTO discount){
        this.saleInfo.setDiscount(discount);

        return this.getTotalWithTax();
    }
}
