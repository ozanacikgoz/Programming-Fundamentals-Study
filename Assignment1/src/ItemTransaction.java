import java.util.Arrays;

/**
 * ItemTransaction object class that contains item and transaction objects with all getter methods.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class ItemTransaction {
    private Item item;
    private Transaction[][] transactions;

    public ItemTransaction(Item item, Transaction[][] transactions) {
        this.item = item;
        this.transactions = transactions;
    }

    public Item getItem() {
        return item;
    }

    public Transaction[][] getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "ItemTransaction{" +
                "item=" + item +
                ", transactions=" + Arrays.toString(transactions) +
                '}';
    }
}
