public class Vehicle extends InsuredValue {
    private String plateCity;
    private double engineVolume;
    private int yearOfProduction;
    private String typeOfGear;
    private int fuelTankVolume;

    public Vehicle(String insuranceNumber, int yearOfInsurance, String plateCity, double engineVolume, int yearOfProduction, String typeOfGear, int fuelTankVolume) {
        super(insuranceNumber, yearOfInsurance);
        this.plateCity = plateCity;
        this.engineVolume = engineVolume;
        this.yearOfProduction = yearOfProduction;
        this.typeOfGear = typeOfGear;
        this.fuelTankVolume = fuelTankVolume;
    }

    public Vehicle() {

    }

    protected double plateCity(){

        switch (plateCity) {
            case "Izmir":
                return 0.78;
            case "Istanbul":
                return 0.97;
            case "Ankara":
                return 0.85;
            default:
                return 0.65;
        }
    }
    protected double typeOfGear(){
        switch (typeOfGear) {
            case "manual":
                return 0.47;
            case "automatic":
                return 0.98;
        }
        return -10;
    }

    protected double getEngineVolume() {
        return engineVolume;
    }

    protected int getFuelTankVolume() {
        return fuelTankVolume;
    }

    @Override
    public String toString() {
        return super.toString()+" Vehicle{" +
                "plateCity='" + plateCity + '\'' +
                ", engineVolume=" + engineVolume +
                ", yearOfProduction=" + yearOfProduction +
                ", typeOfGear='" + typeOfGear + '\'' +
                ", fuelTankVolume=" + fuelTankVolume +
                '}';
    }

    @Override
    public int getAge() {
        return 2020 - yearOfProduction;
    }
}
