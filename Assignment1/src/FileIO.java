import java.io.*;
import java.util.Scanner;

/**
 * This is our fileIO class. We read items and all transaction stores data source files
 * by using two related methods in this class. Also there are two other methods that constructs
 * data of these files.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class FileIO {

    public static Item[] itemReader(String itemCSV) throws IOException {

        Scanner sc = new Scanner(new File(itemCSV));
        sc.useDelimiter("\n");
        Item[] items = new Item[32];
        int count = 0;
        while (sc.hasNext()) {
            String line = sc.next();
            String[] linesplit = line.split(",");
            Item itemR = itemConstructor(linesplit);
            items[count] = itemR;
            count++;
        }
        sc.close();
        return items;
    }

    public static Transaction[][] transactionsReader(String storeCSV) throws IOException {

        int lineCounter = 0;
        Transaction[][] transactionR = new Transaction[32][12];
        int count = 1;
        Scanner sc = new Scanner(new File(storeCSV));
        sc.useDelimiter("\n");
        while (sc.hasNext()) {
            String line = sc.next();
            for(int i = 0; i < 12; i++){
                String[] linesplit = line.split(",");
                transactionR[lineCounter][i] = transactionConstructor(linesplit, count);
                count += 3;
            }
            count = 1;
            lineCounter++;
        }
        sc.close();
        return transactionR;
    }

    private static Item itemConstructor(String[] data) {

        String name = data[0];
        int id = Integer.parseInt(data[1]);
        String category = data[2];
        Item itemC = new Item(name, id, category);

        return itemC;
    }

    private static Transaction transactionConstructor(String[] data,int i) {

        double purchasePrice = Double.parseDouble(data[i]);
        double salePrice = Double.parseDouble(data[i + 1]);
        int numberOfSales = Integer.parseInt(data[i + 2]);
        Transaction transactionC = new Transaction(purchasePrice, salePrice, numberOfSales);

        return transactionC;
    }
}