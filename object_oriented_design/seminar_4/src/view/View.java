package view;

import controller.Controller;
import exceptions.ItemNotFoundException;
import exceptions.OperationFailedException;
import integration.ItemDTO;
import utils.ErrorHandler;
import utils.SaleLogger;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Linus on 2018-05-05.
 */
public class View {
    private Controller controller;
    private SaleLogger logger;
    private ErrorHandler errorHandler;

    public View(Controller cont) throws IOException {
        this.controller = cont;
        controller.addSaleObserver(new TotalRevenueView());
        this.logger = new SaleLogger();
        this.errorHandler = new ErrorHandler();
    }

    private String displayItemInfo(ItemDTO item, int quantity){
        return "Item scanned: (x" + quantity + ")\n" + item.toDisplay(quantity) + "\nTotal: " + String.format("%.2f", controller.getCurrentTotal());
    }

    private String displayTotal(double amountDue){
        return "Amount to pay: " + String.format("%.2f", amountDue) + "kr";
    }

    private void itemsLeftDialog(){
        System.out.println("Please take an action:\n0: Complete sale\n1: Enter item\n2: Enter multiple items");
    }

    private void completedSaleDialog(){
        System.out.println("Please take an action:\n1: Register payment\n2: Request discount");
    }

    private void welcomeScreen(){
        System.out.println("New Sale started!");
    }

    private void baseDisplay(String currentDisplay){
        System.out.println(
                "\n\n\n\n" +
                "CURRENT DISPLAY:\n" +
                "--------------------\n" +
                currentDisplay +
                "\n--------------------"
        );
    }

    private void finishSale(Scanner scan){
        System.out.println("Please enter the amount payed:");
        double payment = scan.nextDouble();
        double change = controller.completePayment(payment);
        baseDisplay("Purchase completed:\nAmount paid: " + String.format("%.2f", payment) + "\nChange: " + String.format("%.2f", change));
    }

    private void reportException(String uiOutput, Exception exc){
        logger.logException(exc);
        errorHandler.showErrorMessage(uiOutput);
    }

    public void POSloop(){
        Scanner scan = new Scanner(System.in);
        boolean itemsLeft = true;
        ItemDTO lastScannedItem = null;
        int lastQuantity = 0;
        int identifier;

        controller.startSale();
        welcomeScreen();

        while(itemsLeft){
            if(lastScannedItem != null){
                baseDisplay(displayItemInfo(lastScannedItem, lastQuantity));
            }
            itemsLeftDialog();
            int choice = scan.nextInt();
            switch (choice){
                case 0:
                    itemsLeft = false;
                    break;
                case 1:
                    System.out.println("Please enter the item identifier");
                    identifier = scan.nextInt();
                    try{
                        lastScannedItem = controller.enterItem(identifier, 1);
                        lastQuantity = 1;
                    } catch (ItemNotFoundException e) {
                        reportException("Could not find an item with that identifier!", e);
                        lastScannedItem = null;
                    } catch (OperationFailedException e) {
                        reportException("Could not get item information, please contact an administrator", e);
                        System.exit(0);
                    }
                    break;
                case 2:
                    System.out.println("Please enter the item identifier");
                    identifier = scan.nextInt();

                    int lastQuantityTemp = lastQuantity;
                    System.out.println("Please enter the amount of items");
                    lastQuantity = scan.nextInt();
                    try {
                        lastScannedItem = controller.enterItem(identifier, lastQuantity);
                    } catch (ItemNotFoundException e) {
                        lastQuantity = lastQuantityTemp;
                        reportException("Could not find an item with that identifier!", e);
                        lastScannedItem = null;
                    } catch (OperationFailedException e) {
                        reportException("Could not get item information, please contact an administrator", e);
                        System.exit(0);
                    }
                    break;
            }
        }

        System.out.println("Completing sale...");

        double totalWithTax = controller.completeSale();

        System.out.println("Sale completed");
        baseDisplay(displayTotal(totalWithTax));
        completedSaleDialog();

        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                finishSale(scan);
                break;
            case 2:
                System.out.println("Please enter member identification:");
                int memberId = scan.nextInt();
                totalWithTax = controller.getCustomerDiscount(memberId);
                baseDisplay(displayTotal(totalWithTax));
                finishSale(scan);
                break;
        }
    }
}
