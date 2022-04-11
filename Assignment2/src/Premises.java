public class Premises extends InsuredValue {

    private String premisesCity;
    private int numberOfFloors;
    private int yearOfConstruction;
    private String typeOfConstruction;
    private int surfaceArea;

    public Premises(String insuranceNumber, int yearOfInsurance, String premisesCity, int numberOfFloors, int yearOfConstruction, String typeOfConstruction, int surfaceArea) {
        super(insuranceNumber, yearOfInsurance);
        this.premisesCity = premisesCity;
        this.numberOfFloors = numberOfFloors;
        this.yearOfConstruction = yearOfConstruction;
        this.typeOfConstruction = typeOfConstruction;
        this.surfaceArea = surfaceArea;
    }

    public Premises(){

    }

    protected double numberOfFloors() {

        if (numberOfFloors >= 1 && numberOfFloors <= 3) {
            return 0.1;
        } else if (numberOfFloors >= 4 && numberOfFloors <= 7) {
            return 0.25;
        } else if (numberOfFloors >= 8 && numberOfFloors <= 18) {
            return 0.5;
        } else if (numberOfFloors > 18) {
            return 0.85;
        }

        return -10;
    }
    protected double premisesCity() {

        switch (premisesCity) {
            case "Izmir":
                return 0.4;
            case "Istanbul":
                return 0.6;
            case "Ankara":
                return 0.5;
        }

        return -10;
    }
    protected double yearOfConstruction() {

        if (yearOfConstruction < 1975) {
            return 0.58;
        } else if (yearOfConstruction >= 1975 && yearOfConstruction <= 1999) {
            return 0.32;
        } else if(yearOfConstruction > 1999){
            return 0.1;
        }
        return -10;
    }
    protected double typeOfConstruction() {

        switch (typeOfConstruction) {
            case "steel":
                return 0.1;
            case "concrete":
                return 0.37;
            case "wood":
                return 0.58;
            default:
                return 0.92;
        }
    }

    public int getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    public int getAge() {
        return 2020-yearOfConstruction;
    }

    @Override
    public String toString() {
        return super.toString()+" Premises{" +
                "premisesCity='" + premisesCity + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", yearOfConstruction=" + yearOfConstruction +
                ", typeOfConstruction='" + typeOfConstruction + '\'' +
                ", surfaceArea=" + surfaceArea +
                '}';
    }
}