import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is our fileIO class. We read the file that has all the
 * insured values and we have 5 methods, that constructs data from
 * the insured values and 1 method to construct objects.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class FileIO {

    public ArrayList fileReader(String insurancecsv) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(insurancecsv));
        scanner.useDelimiter("[\r\n]+");
        ArrayList<InsuredValue> insuredValueList = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.next();
            String[] lineSplit = line.split(",");
            insuredValueList .add(insuredValueConstructor(lineSplit));
        }
        return insuredValueList ;
    }

    private Workplace workplaceConstructor(String[] data){
        String insuranceNumber=data[0];
        int yearOfInsurance=Integer.parseInt(data[1]);
        String premisesCity=data[2];
        int numberOfFloors=Integer.parseInt(data[3]);
        int yearOfConstruction=Integer.parseInt(data[4]);
        String typeOfConstruction=data[5];
        int surfaceArea=Integer.parseInt(data[6]);
        int annualRevenue=Integer.parseInt(data[7]);
        Workplace workplace= new Workplace(insuranceNumber, yearOfInsurance, premisesCity, numberOfFloors, yearOfConstruction, typeOfConstruction, surfaceArea,annualRevenue);

        return workplace;
    }

    private Housing housingConstructor(String[] data){
        String insuranceNumber=data[0];
        int yearOfInsurance=Integer.parseInt(data[1]);
        String premisesCity=data[2];
        int numberOfFloors=Integer.parseInt(data[3]);
        int yearOfConstruction=Integer.parseInt(data[4]);
        String typeOfConstruction=data[5];
        int surfaceArea=Integer.parseInt(data[6]);
        String residentSituation=data[7];
        Housing housing = new Housing(insuranceNumber, yearOfInsurance, premisesCity, numberOfFloors, yearOfConstruction, typeOfConstruction, surfaceArea,residentSituation);

        return housing;
    }

    private Person personConstructor(String[] data){
        String insuranceNumber=data[0];
        int yearOfInsurance=Integer.parseInt(data[1]);
        String residenceCity=data[2];
        String name=data[3];
        long nationalID=Long.parseLong(data[4]);
        String gender=data[5];
        int yearOfBirth=Integer.parseInt(data[6]);
        String typeOfChronicleIllness=data[7];
        Person person = new Person(insuranceNumber,yearOfInsurance,residenceCity, name,nationalID,gender,yearOfBirth,typeOfChronicleIllness);

        return person;
    }

    private Automobile automobileConstructor(String[] data){
        String insuranceNumber=data[0];
        int yearOfInsurance=Integer.parseInt(data[1]);
        String plateCity=data[2];
        double engineVolume=Double.parseDouble(data[3]);
        int yearOfProduction=Integer.parseInt(data[4]);
        String typeOfGear=data[5];
        int fuelTankVolume=Integer.parseInt(data[6]);
        String typeOfRoof=data[7];
        Automobile automobile = new Automobile(insuranceNumber, yearOfInsurance, plateCity, engineVolume, yearOfProduction, typeOfGear, fuelTankVolume,typeOfRoof);

        return automobile;
    }

    private Truck truckConstructor(String[] data){
        String insuranceNumber=data[0];
        int yearOfInsurance=Integer.parseInt(data[1]);
        String plateCity=data[2];
        double engineVolume=Double.parseDouble(data[3]);
        int yearOfProduction=Integer.parseInt(data[4]);
        String typeOfGear=data[5];
        int fuelTankVolume=Integer.parseInt(data[6]);
        String typeOfTruckBed=data[7];
        Truck truck = new Truck(insuranceNumber, yearOfInsurance, plateCity, engineVolume, yearOfProduction, typeOfGear, fuelTankVolume,typeOfTruckBed);

        return truck;
    }

    private InsuredValue insuredValueConstructor(String[] data){
        InsuredValue insured = new InsuredValue();

        if(data[0].substring(0,1).equals("W")){
            insured=workplaceConstructor(data);
        }
        else if(data[0].substring(0,1).equals("T")){
            insured= truckConstructor(data);
        }
        else if(data[0].substring(0,1).equals("A")){
            insured=automobileConstructor(data);
        }
        else if(data[0].substring(0,1).equals("P")){
            insured=personConstructor(data);
        }
        else if(data[0].substring(0,1).equals("H")){
            insured=housingConstructor(data);
        }
        return insured;
    }
}