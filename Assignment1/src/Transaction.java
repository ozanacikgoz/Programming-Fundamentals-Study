/**
 * Transaction object class with all getter methods.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class Transaction {
    private double purchasePrice;
    private double salePrice;
    private int numberOfSales;

    public Transaction(double purchasePrice, double salePrice, int numberOfSales) {
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.numberOfSales = numberOfSales;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "purchasePrice=" + purchasePrice +
                ", salePrice=" + salePrice +
                ", numberOfSales=" + numberOfSales +
                '}';
    }
}