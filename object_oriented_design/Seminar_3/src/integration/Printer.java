package integration;

import model.SaleInfo;

/**
 * Created by Linus on 2018-05-05.
 */
public class Printer {
    public static String printReceipt(SaleInfo saleInfo){
        return "Total after taxes: " + saleInfo.getTotal();
    }
}
