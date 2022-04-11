public class Person extends InsuredValue{
    private String residenceCity;
    private String name;
    private long nationalID;
    private String gender;
    private int yearOfBirth;
    private String typeOfChronicleIllness;

    public Person(String insuranceNumber, int yearOfInsurance, String residenceCity, String name, long nationalID, String gender, int yearOfBirth, String typeOfChronicleIllness) {
        super(insuranceNumber, yearOfInsurance);
        this.residenceCity = residenceCity;
        this.name = name;
        this.nationalID = nationalID;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.typeOfChronicleIllness = typeOfChronicleIllness;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return super.toString()+" Person{" +
                "residenceCity='" + residenceCity + '\'' +
                ", name='" + name + '\'' +
                ", nationalID=" + nationalID +
                ", gender='" + gender + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", typeOfChronicleIllness='" + typeOfChronicleIllness + '\'' +
                '}';
    }

    private double typeOfChronicleIllness() {

        switch (typeOfChronicleIllness) {
            case "cardiovascular":
                return 1.85;
            case "diabetes":
                return 1.84;
            case "respiratory":
                return 1.86;
            case "none":
                return 0.1;
            default:
                return 1.8;
        }
    }

    @Override
    public int getAge() {
        return 2020-yearOfBirth;
    }

    @Override
    public double calculateRiskFactor() {
        double riskFactor= getAge()*getAge() / typeOfChronicleIllness() * 18;
        return riskFactor;
    }
}
