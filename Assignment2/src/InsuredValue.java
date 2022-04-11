/**
 * Insured value is the base class of the
 * premises, person and vehicle classes.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class InsuredValue {
    private String insuranceNumber;
    private int yearOfInsurance;
    private int riskFactor;
    private int age;

    public InsuredValue(String insuranceNumber, int yearOfInsurance) {
        this.insuranceNumber = insuranceNumber;
        this.yearOfInsurance = yearOfInsurance;
        this.riskFactor = getRiskFactor();
    }

    public InsuredValue() {
    }

    public double calculateRiskFactor() {
        return 1.0;
    }

    public int getRiskFactor() {
        return riskFactor;
    }

    public int getAge() {
        return age;
    }

    public int getYearOfInsurance() { return yearOfInsurance;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    @Override
    public String toString() {
        return "InsuredValue{" +
                "insuranceNumber='" + insuranceNumber + '\'' +
                ", yearOfInsurance=" + yearOfInsurance +
                '}';
    }
}