public class Automobile extends Vehicle {
    String typeOfRoof;

    public Automobile(String insuranceNumber, int yearOfInsurance, String plateCity, double engineVolume, int yearOfProduction, String typeOfGear, int fuelTankVolume, String typeOfRoof) {
        super(insuranceNumber, yearOfInsurance, plateCity, engineVolume, yearOfProduction, typeOfGear, fuelTankVolume);
        this.typeOfRoof = typeOfRoof;
    }

    public Automobile() {
        super();
    }

    private double typeOfRoof(){

        switch (typeOfRoof) {
            case "regular":
                return 0.1;
            case "sunroof":
                return 0.64;
            case "moonroof":
                return 0.48;
        }
        return -10;
}

    @Override
    public String toString() {
        return super.toString()+"typeOfRoof is " + typeOfRoof;
    }

    @Override
    public double calculateRiskFactor() {
        double riskFactor = getEngineVolume() * 0.004 * getFuelTankVolume() * getAge() * plateCity() * 0.03 / typeOfRoof();
        return  riskFactor;
    }
}
