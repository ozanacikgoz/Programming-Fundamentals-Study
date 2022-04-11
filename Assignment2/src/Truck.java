public class Truck extends Vehicle {
    private String typeOfTruckBed;

    public Truck(String insuranceNumber, int yearOfInsurance, String plateCity, double engineVolume, int yearOfProduction, String typeOfGear, int fuelTankVolume, String typeOfTruckBed) {
        super(insuranceNumber, yearOfInsurance, plateCity, engineVolume, yearOfProduction, typeOfGear, fuelTankVolume);
        this.typeOfTruckBed = typeOfTruckBed;
    }

    public Truck() {
        super();
    }


    private double typeOfTruckOfBed(){

        switch (typeOfTruckBed) {
            case "trailer":
                return 0.87;
            case "tanker":
                return 0.84;
            case "regular":
                return 0.15;
        }
        return -10;
    }

    @Override
    public double calculateRiskFactor() {
        double riskFactor=(getAge()*getAge()*getAge()) / (getFuelTankVolume()*getEngineVolume()*plateCity()*0.03 / (typeOfTruckOfBed()*typeOfTruckOfBed()));
        return riskFactor;
    }
    @Override
    public String toString() {
        return super.toString() +"typeOfTruckBed: "+typeOfTruckBed;
    }

}
