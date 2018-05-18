package view;

import model.SaleInfo;
import model.SaleObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Linus on 2018-05-18.
 */
class TotalRevenueView implements SaleObserver{
    private Map<SaleInfo, Double> saleTotals = new HashMap<>();

    @Override
    public void newTotal(SaleInfo saleInfo) {
        addToSale(saleInfo);
        printCurrentState();
    }

    private void addToSale(SaleInfo sale){
        saleTotals.put(sale, sale.getTotal());
    }

    private void printCurrentState(){
        int index = saleTotals.size();
        System.out.println("### TODAY'S SALE TOTALS ###");
        for (Map.Entry<SaleInfo, Double> saleTotal : saleTotals.entrySet()){
            System.out.println("Sale nr " + index + " total: " + saleTotal.getValue());
            index--;
        }
        System.out.println("###########################");
    }
}
