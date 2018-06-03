package model;

import integration.ItemDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Linus on 2018-05-05.
 */
public class Sale {
    private final double TAX = 25.7;

    private int memberId;
    private SaleInfo saleInfo = null;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * Creates the instance of the object and creates an instance specific SaleInfo object
     */
    public Sale(){
        this.saleInfo = new SaleInfo();
    }

    /**
     * Returns the SaleInfo object
     *
     * @return SaleInfo
     */
    public SaleInfo getSaleInfo(){
        return this.saleInfo;
    }

    /**
     * Returns a Map of each item and the quantity of it in the basket
     *
     * @return Map with each ItemDTO in the basket and the quantity of the item
     */
    public Map<ItemDTO, Integer> getItems(){
        return this.saleInfo.getItems();
    }

    /**
     * Adds an item to the current sale
     *
     * @param item ItemDTO
     * @param quantity int
     */
    public void addToSale(ItemDTO item, int quantity){
        this.saleInfo.addItem(item, quantity);
    }

    /**
     * Returns the total of the sale with taxes applied
     *
     * @return double
     */
    public double getTotalWithTax(){
        return this.saleInfo.getTotal()*(1 + TAX / 100);
    }

    /**
     * Returns the amount of change to give to the customer
     *
     * @param amount double
     * @return double
     */
    public double pay(double amount){
        double amountToPay = getTotalWithTax();
        notifyObservers();
        return amount - amountToPay;
    }

    /**
     * Applies a discount to the total of the sale
     *
     * @param discount DiscountDTO
     * @return double
     */
    public double applyDiscount(DiscountDTO discount){
        this.saleInfo.setDiscount(discount);

        return this.getTotalWithTax();
    }

    private void notifyObservers(){
        for (SaleObserver obs : saleObservers){
            obs.newTotal(saleInfo);
        }
    }

    public void addSaleObserver(SaleObserver obs){
        saleObservers.add(obs);
    }

    public void addSaleObservers(List<SaleObserver> obsList){
        saleObservers.addAll(obsList);
    }
}
