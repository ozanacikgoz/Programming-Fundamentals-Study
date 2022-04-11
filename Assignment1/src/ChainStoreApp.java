import java.io.IOException;

/**
 * This is our ChainStoreApp where has the main method.
 * So program starts from here and creates an StoreQuery class
 * then calls our homework questions one by one.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class ChainStoreApp {
    public static void main(String[] args) throws IOException {

        StoreQuery sq = new StoreQuery();
        System.out.println("Most profitable item for the whole year is: " + sq.mostProfitableItem() + ".");
        System.out.println("Most profitable category for the whole year is: " + sq.mostProfitableCategory() + ".");
        System.out.println("Least profitable item for the whole year is: " + sq.leastProfitableItem() + ".");
        System.out.println("Least profitable category for the whole year is: " + sq.leastProfitableCategory() + ".");
        System.out.println("Most profitable item for a single sale is: " + sq.mostProfitableSingleSaleItem() + ".");
        System.out.println("Best-selling item for the whole year is: " + sq.bestSellingItem() + ".");
        System.out.println("Most profitable stores for each month is: \n" + sq.mostProfitableStoreForEachMonth());
    }
}