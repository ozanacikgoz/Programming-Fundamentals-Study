import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * This is our InsurancePolicyCalculatorApp where has the main method.
 * So program starts from here, then calls our
 * homework questions one by one.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class InsurancePolicyCalculatorApp {

    public static void main(String[] args) throws FileNotFoundException {
        FileIO f = new FileIO();
        ArrayList<InsuredValue> insuredValues = f.fileReader("HW2_InsuredValues.csv");

        PolicyRecord policyRecord = new PolicyRecord(insuredValues);

        ArrayList<Workplace> workplaces = policyRecord.getWorkPlaceList();
        ArrayList<Housing> housings = policyRecord.getHousingList();
        ArrayList<Person> persons = policyRecord.getPersonList();
        ArrayList<Automobile> automobiles = policyRecord.getAutomobileList();
        ArrayList<Truck> trucks = policyRecord.getTruckList();
        ArrayList<InsuredValue> orderedInsuredValues = policyRecord.getOrderedInsuredValueList();

        Insurance householdCharge = new Household();
        Insurance healthCharge = new Health();
        Insurance trafficCharge = new Traffic();

        System.out.println("1 All insured values, 2 Workplaces, 3 Housings, 4 Persons, 5 Automobiles, 6 Trucks.\n" +
                "Please enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        Locale currentLocale = Locale.getDefault();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);

        double work = 0.0;
        double house = 0.0;
        double person = 0.0;
        double automobile = 0.0;
        double truck = 0.0;

        switch (input) {
            case 1:
                for(int k = 0; k < 20; k++) {

                    if (orderedInsuredValues.get(k) instanceof Workplace) {
                        work = (householdCharge.calculatePolicyCharge(orderedInsuredValues.get(k)));
                        System.out.println("\nInsured Value: " + orderedInsuredValues.get(k).getClass().getName() + " Insurance Number: " + orderedInsuredValues.get(k).getInsuranceNumber() + " Year of Insurance: " + orderedInsuredValues.get(k).getYearOfInsurance());
                        System.out.println("The policy charge of " + orderedInsuredValues.get(k).getInsuranceNumber() + ": " + currencyFormatter.format(work));
                    }
                    else if (orderedInsuredValues.get(k) instanceof Housing) {
                        house = (householdCharge.calculatePolicyCharge(orderedInsuredValues.get(k)));
                        System.out.println("\nInsured Value: " + orderedInsuredValues.get(k).getClass().getName() + " Insurance Number: " + orderedInsuredValues.get(k).getInsuranceNumber() + " Year of Insurance: " + orderedInsuredValues.get(k).getYearOfInsurance());
                        System.out.println("The policy charge of " + orderedInsuredValues.get(k).getInsuranceNumber() + ": " + currencyFormatter.format(house));
                    }
                    else if (orderedInsuredValues.get(k) instanceof Person) {
                        person = (householdCharge.calculatePolicyCharge(orderedInsuredValues.get(k)));
                        System.out.println("\nInsured Value: " + orderedInsuredValues.get(k).getClass().getName() + " Insurance Number: " + orderedInsuredValues.get(k).getInsuranceNumber() + " Year of Insurance: " + orderedInsuredValues.get(k).getYearOfInsurance());
                        System.out.println("The policy charge of " + orderedInsuredValues.get(k).getInsuranceNumber() + ": " + currencyFormatter.format(person));
                    }
                    else if (orderedInsuredValues.get(k) instanceof Automobile) {
                        automobile = (householdCharge.calculatePolicyCharge(orderedInsuredValues.get(k)));
                        System.out.println("\nInsured Value: " + orderedInsuredValues.get(k).getClass().getName() + " Insurance Number: " + orderedInsuredValues.get(k).getInsuranceNumber() + " Year of Insurance: " + orderedInsuredValues.get(k).getYearOfInsurance());
                        System.out.println("The policy charge of " + orderedInsuredValues.get(k).getInsuranceNumber() + ": " + currencyFormatter.format(automobile));
                    }
                    else if (orderedInsuredValues.get(k) instanceof Truck) {
                        truck = (householdCharge.calculatePolicyCharge(orderedInsuredValues.get(k)));
                        System.out.println("\nInsured Value: " + orderedInsuredValues.get(k).getClass().getName() + " Insurance Number: " + orderedInsuredValues.get(k).getInsuranceNumber() + " Year of Insurance: " + orderedInsuredValues.get(k).getYearOfInsurance());
                        System.out.println("The policy charge of " + orderedInsuredValues.get(k).getInsuranceNumber() + ": " + currencyFormatter.format(truck));
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 4; i++) {
                    double a = (householdCharge.calculatePolicyCharge(workplaces.get(i)));
                    System.out.println("Insured Value: " + workplaces.get(i).getClass().getName() + " Insurance Number: " + workplaces.get(i).getInsuranceNumber() + " Year of Insurance: " + workplaces.get(i).getYearOfInsurance());
                    System.out.println("The policy charge of " + workplaces.get(i).getInsuranceNumber() + ": " + currencyFormatter.format(a));
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    double b = (householdCharge.calculatePolicyCharge(housings.get(i)));
                    System.out.println("Insured Value: " + housings.get(i).getClass().getName() + " Insurance Number: " + housings.get(i).getInsuranceNumber() + " Year of Insurance: " + housings.get(i).getYearOfInsurance());
                    System.out.println("The policy charge of " + housings.get(i).getInsuranceNumber() + ": " + currencyFormatter.format(b));
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    double c = (healthCharge.calculatePolicyCharge(persons.get(i)));
                    System.out.println("Insured Value: " + persons.get(i).getClass().getName() + " Insurance Number: " + persons.get(i).getInsuranceNumber() + " Year of Insurance: " + persons.get(i).getYearOfInsurance());
                    System.out.println("The policy charge of " + persons.get(i).getInsuranceNumber() + ": " + currencyFormatter.format(c));
                }
                break;
            case 5:
                for (int i = 0; i < 4; i++) {
                    double d = trafficCharge.calculatePolicyCharge(automobiles.get(i));
                    System.out.println("Insured Value: " + automobiles.get(i).getClass().getName() + " Insurance Number: " + automobiles.get(i).getInsuranceNumber() + " Year of Insurance: " + automobiles.get(i).getYearOfInsurance());
                    System.out.println("The policy charge of " + automobiles.get(i).getInsuranceNumber() + ": " + currencyFormatter.format(d));
                }
                break;
            case 6:
                for (int i = 0; i < 4; i++) {
                    double e = trafficCharge.calculatePolicyCharge(trucks.get(i));
                    System.out.println("Insured Value: " + trucks.get(i).getClass().getName() + " Insurance Number: " + trucks.get(i).getInsuranceNumber() + " Year of Insurance: " + trucks.get(i).getYearOfInsurance());
                    System.out.println("The policy charge of " + trucks.get(i).getInsuranceNumber() + ": " + currencyFormatter.format(e));
                }
                break;
        }
    }
}