import java.util.ArrayList;

public class Printer<T> {
    private FileIO f;
    private ArrayList<T> allcargos;
    private PriceCalculator priceCalculator;
    private Agency agency;

    public Printer(FileIO f, ArrayList<T> allcargos, PriceCalculator priceCalculator, Agency agency) {
        this.f = f;
        this.allcargos = allcargos;
        this.priceCalculator = priceCalculator;
        this.agency = agency;
    }

    public void greeterPrinter() {
        agency.statusChanger();
        int[] acceptedOrNotCounter = agency.acceptanceCounterChecker();//First element is for accepted counter, second is for not accepteds.
        System.out.println("WELCOME!"+"\n");
        System.out.println("Number of Accepted Cargo: " + acceptedOrNotCounter[0]);
        System.out.println("Number of Not Accepted Cargo: " + acceptedOrNotCounter[1]+"\n");
        System.out.println("Here are the details:\n");
    }

    public void normalCargoPrinter() {
        System.out.println("Normal Cargo Packages:\n");
        System.out.printf("%-5s %-20s %-20s %-25s %-25s %-40s %-10s %-10s %-15s","No", "Cargo Code", "Sender ID", "Sender Name", "Recipient Name", "Recipient Address", "Size", "Price", "Delivery Day");
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int counter = 0;
        for (T cargo : allcargos) {
            if (cargo instanceof NormalCargo) {
                counter++;
                System.out.format("%-5s %-20s %-20s %-25s %-25s %-40s %-10s %-10s %-15s\n",
                        counter,
                        ((NormalCargo<?>) cargo).getCargoCode(),
                        ((NormalCargo<?>) cargo).getSenderID(),
                        ((NormalCargo<?>) cargo).getSenderName(),
                        ((NormalCargo<?>) cargo).getRecipientName(),
                        ((NormalCargo<?>) cargo).getRecipientAddress(),
                        ((NormalCargo<?>) cargo).getSize(),
                        priceCalculator.calculatePrice((NormalCargo<?>) cargo),
                        ((NormalCargo<?>) cargo).getDeliveryDay());
            }
        }
    }

    public void eCommerceCargoPrinter() {
        System.out.println("\n");
        System.out.println("ECommerce Cargo Packages:\n");
        System.out.printf("%-5s %-25s %-20s %-20s %-10s %-20s","No", "ECommerce Site","Cargo Code","Status", "Size", "Delivery Day");
        System.out.println("\n-------------------------------------------------------------------------------------------------");

        int counter = 0;
        for (T cargo : allcargos) {
            if (cargo instanceof ECommerceCargo) {
                counter++;
                System.out.format("%-5s %-25s %-20s %-20s %-10s %-20s\n",
                        counter,
                        ((ECommerceCargo<?>) cargo).getEcommerce_site_name(),
                        ((ECommerceCargo<?>) cargo).getCargo_code(),
                        ((ECommerceCargo<?>) cargo).getStatus(),
                        ((ECommerceCargo<?>) cargo).getSize(),
                        ((ECommerceCargo<?>) cargo).getDeliveryDay());
            }
        }
    }
}