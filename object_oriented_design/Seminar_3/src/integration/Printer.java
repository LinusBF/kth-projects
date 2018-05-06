package integration;

import model.SaleInfo;

/**
 * Created by Linus on 2018-05-05.
 */
public class Printer {
    //Representation of the printer in the store
    public static String printReceipt(SaleInfo saleInfo){
        return "Total after taxes: " + saleInfo.getTotal();
    }
}
