import java.io.IOException;
import java.util.Arrays;

/**
 * We are using StoreQuery class as an helper class for our
 * ChainStoreApp class. That class has the basic querying methods to
 * satisfy homework requirements.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class StoreQuery {

    Item[] items = FileIO.itemReader("HW1_Items.csv");
    ItemTransaction[] annualSale = AnnualSale.annualSaleGetter(items);

    public StoreQuery() throws IOException {
    }

    public String mostProfitableItem() {
        double maxProfit = 0;
        Item mostProfitableItem = null;
        for (int i = 0; i < 32; i++) {
            double totalProfit = 0;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 12; k++) {
                    double profit = (annualSale[i].getTransactions()[j][k].getSalePrice() - annualSale[i].getTransactions()[j][k].getPurchasePrice()) * annualSale[i].getTransactions()[j][k].getNumberOfSales();
                    totalProfit += profit;
                }
            }
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                mostProfitableItem = annualSale[i].getItem();
            }
        }
        return mostProfitableItem.getName();
    }

    public String mostProfitableCategory() {
        double[] profitArray = categoryProfit();
        double maxProfitCategory = findMaximum(profitArray);
        String answer = null;

        if (maxProfitCategory == profitArray[0]) {
            answer = "Food";
        }
        else if (maxProfitCategory == profitArray[1]) {
            answer = "Beverage";
        }
        else if (maxProfitCategory == profitArray[2]) {
            answer =  "Snack";
        }
        else if (maxProfitCategory == profitArray[3]) {
            answer = "Home";
        }
        else if (maxProfitCategory == profitArray[4]) {
            answer = "Personal";
        }
        return answer;
    }

    public String leastProfitableItem() {
        double minProfit = 10000;
        Item leastProfitableItem = null;
        for (int i = 0; i < 32; i++) {
            double totalProfit = 0;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 12; k++) {
                    double profit = (annualSale[i].getTransactions()[j][k].getSalePrice() - annualSale[i].getTransactions()[j][k].getPurchasePrice()) * annualSale[i].getTransactions()[j][k].getNumberOfSales();
                    totalProfit += profit;
                }
            }
            if (totalProfit < minProfit) {
                minProfit = totalProfit;
                leastProfitableItem = annualSale[i].getItem();
            }
        }
        return leastProfitableItem.getName();
    }

    public String leastProfitableCategory() {
        double[] profitArray = categoryProfit();
        double minProfitCategory = findMinimum(profitArray);
        String answer = null;

        if (minProfitCategory == profitArray[0]) {
            answer = "Food";
        }
        else if (minProfitCategory == profitArray[1]) {
            answer = "Beverage";
        }
        else if (minProfitCategory == profitArray[2]) {
            answer =  "Snack";
        }
        else if (minProfitCategory == profitArray[3]) {
            answer = "Home";
        }
        else if (minProfitCategory == profitArray[4]) {
            answer = "Personal";
        }
        return answer;
    }

    public String mostProfitableSingleSaleItem() {
        double maxProfitSingle = 0;
        Item mostProfitableItem = null;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 12; k++) {
                    double profit = annualSale[i].getTransactions()[j][k].getSalePrice() - annualSale[i].getTransactions()[j][k].getPurchasePrice();
                    if (profit > maxProfitSingle) {
                        maxProfitSingle = profit;
                        mostProfitableItem = annualSale[i].getItem();
                    }
                }
            }
        }
        return mostProfitableItem.getName();
    }

    public String bestSellingItem() {
        int maxNumberOfSales = 0;
        Item bestSellingItem = null;
        for (int i = 0; i < 32; i++) {
            int numberOfSales = 0;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 12; k++) {
                    int numberOfSale = annualSale[i].getTransactions()[j][k].getNumberOfSales();
                    numberOfSales += numberOfSale;
                }
            }
            if (numberOfSales > maxNumberOfSales) {
                maxNumberOfSales = numberOfSales;
                bestSellingItem = annualSale[i].getItem();
            }
        }
        return bestSellingItem.getName();
    }

    public String mostProfitableStoreForEachMonth() {
        int[] mostProfitableStoreIndices = new int[12];
        String[] mostProfitableStores = new String[12];
        String answer;
        double[][] allProfits = new double[12][4];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++) {
                double profitSum = 0;
                for (int k = 0; k < 32; k++) {
                    double profit = (annualSale[k].getTransactions()[j][i].getSalePrice() - annualSale[k].getTransactions()[j][i].getPurchasePrice()) * annualSale[k].getTransactions()[j][i].getNumberOfSales();
                    profitSum += profit;
                }
                allProfits[i][j] = profitSum;
            }
        }
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 4; j++) {
                double max = findMaximum(allProfits[i]);
                if (max == allProfits[i][j]) {
                    mostProfitableStoreIndices[i] = (j + 1);
                }
            }
            mostProfitableStores[i] = "Month: " + (i+1) + " - " + "Most Profitable Store: " + mostProfitableStoreIndices[i] +"\n";
        }
        answer = Arrays.toString(mostProfitableStores).replace("[", "").replace("]", "").replace(", ","");
        return answer;
    }

    private double[] categoryProfit() {

        double foodSum = 0;
        double beverageSum = 0;
        double snackSum = 0;
        double homeSum = 0;
        double personalSum = 0;

        double[] profitArray = new double[5];

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 12; k++) {
                    double salePrice = annualSale[i].getTransactions()[j][k].getSalePrice();
                    double purchasePrice = annualSale[i].getTransactions()[j][k].getPurchasePrice();
                    int numberOfSales = annualSale[i].getTransactions()[j][k].getNumberOfSales();

                    switch (annualSale[i].getItem().getCategory()) {
                        case "Food": {
                            double profit = (salePrice - purchasePrice) * numberOfSales;
                            foodSum += profit;
                            break;
                        }
                        case "Beverage": {
                            double profit = (salePrice - purchasePrice) * numberOfSales;
                            beverageSum += profit;
                            break;
                        }
                        case "Snack": {
                            double profit = (salePrice - purchasePrice) * numberOfSales;
                            snackSum += profit;
                            break;
                        }
                        case "Home": {
                            double profit = (salePrice - purchasePrice) * numberOfSales;
                            homeSum += profit;
                            break;
                        }
                        case "Personal": {
                            double profit = (salePrice - purchasePrice) * numberOfSales;
                            personalSum += profit;
                            break;
                        }
                    }
                }
            }
        }
        profitArray[0] = foodSum / 12;
        profitArray[1] = beverageSum / 6;
        profitArray[2] = snackSum / 6;
        profitArray[3] = homeSum / 4;
        profitArray[4] = personalSum / 4;

        return profitArray;
    }

    private static double findMaximum(double[] array){
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static double findMinimum(double[] array){
        double min = array[0];
        for(int i = 1; i < array.length;i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}