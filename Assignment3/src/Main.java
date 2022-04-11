import java.util.ArrayList;
/**
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class Main {
    public static <T> void main(String[] args) {
        FileIO f = new FileIO();
        ArrayList<T> allcargos = f.filereader("HW3_PackagesToAccept.csv");
        PriceCalculator priceCalculator = new PriceCalculator();
        Agency agency = new Agency(allcargos);
        Printer printer = new Printer(f, allcargos, priceCalculator, agency);

        printer.greeterPrinter();
        printer.normalCargoPrinter();
        printer.eCommerceCargoPrinter();
    }
}