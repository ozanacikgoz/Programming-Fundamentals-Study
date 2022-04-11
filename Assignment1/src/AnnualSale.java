import java.io.IOException;

/**
 * AnnualSale object class holds ItemTransaction objects.
 * Basic responsibility of that class is to convert string
 * arrays to object array that has read, using file reader methods
 * in fileIO class.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class AnnualSale {

    private ItemTransaction[] itemTransaction;
    private static FileIO file = new FileIO();

    public AnnualSale(ItemTransaction[] itemTransaction) {
        this.itemTransaction = itemTransaction;
    }

    public static ItemTransaction[] annualSaleGetter(Item[] items) throws IOException {

        items = FileIO.itemReader("HW1_Items.csv");
        return annualSaleConstructor(items);
    }

    private static ItemTransaction[] annualSaleConstructor(Item[] items) throws IOException {

        Transaction[][] transactionsR;
        ItemTransaction[] annualSale = new ItemTransaction[32];

        for(Item item : items){
            Transaction[][] transactions = new Transaction[4][12];
            for(int storeCount = 0; storeCount < 4; storeCount++){
                int realStoreCount = storeCount + 1;
                transactionsR = file.transactionsReader("HW1_Transactions_Store" + realStoreCount + ".csv");
                for(int monthCount = 0; monthCount < 12; monthCount++){
                    transactions[storeCount][monthCount] = transactionsR[item.getId()-1][monthCount];
                }
            }
            ItemTransaction it = new ItemTransaction(item,transactions);
            annualSale[item.getId()-1] = it;
        }
        return annualSale;
    }
}