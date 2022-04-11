public class Housing extends Premises {
    String residentSituation;

    public Housing(String insuranceNumber, int yearOfInsurance, String premisesCity, int numberOfFloors, int yearOfConstruction, String typeOfConstruction, int surfaceArea, String residentSituation) {
        super(insuranceNumber, yearOfInsurance, premisesCity, numberOfFloors, yearOfConstruction, typeOfConstruction, surfaceArea);
        this.residentSituation = residentSituation;
    }

    public Housing() {
    }

    private double residentSituation() {

            switch (residentSituation) {
                case "tenant":
                    return 0.18;
                case "landlord":

                    return 0.42;
            }
        return -10;
    }

    @Override
    public String toString() {
        return super.toString()+"resident situation is "+residentSituation;
    }

    @Override
    public double calculateRiskFactor() {
        double riskFactor = premisesCity()*numberOfFloors()*yearOfConstruction()*typeOfConstruction()*getSurfaceArea()/residentSituation();
            return riskFactor;
    }
}
