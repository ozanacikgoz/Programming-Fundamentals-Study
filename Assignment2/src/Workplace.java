public class Workplace extends Premises {
    private int annualRevenue;

    public Workplace(String insuranceNumber, int yearOfInsurance, String premisesCity, int numberOfFloors, int yearOfConstruction, String typeOfConstruction, int surfaceArea, int annualRevenue) {
        super(insuranceNumber, yearOfInsurance, premisesCity, numberOfFloors, yearOfConstruction, typeOfConstruction, surfaceArea);
        this.annualRevenue = annualRevenue;
    }

    public Workplace() {
        super();
    }

    @Override
    public double calculateRiskFactor() {
        double riskFactor = this.premisesCity() * this.numberOfFloors() * this.yearOfConstruction() * this.typeOfConstruction() * (getSurfaceArea() * 0.2) * (annualRevenue * 0.003);
        return riskFactor;
    }
    @Override
    public String toString() {
        return super.toString()+" annualRevenue: " +annualRevenue;
    }
}