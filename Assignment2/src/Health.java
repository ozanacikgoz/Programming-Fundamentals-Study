/**
 * We calculate the policy charge for person.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class Health extends Insurance {

    public Health() {
        super();
    }

    @Override
    public  double calculatePolicyCharge(InsuredValue person) {
        int rankingOfInsurance = 2020 - person.getYearOfInsurance();
        if (rankingOfInsurance < 3 && person.calculateRiskFactor() > 50) {
            System.out.println("Insurance application is denied.");
            return 1000000;
        }
        else {
            return (getFixedFee() * person.calculateRiskFactor() * person.calculateRiskFactor() * person.calculateRiskFactor() / 208);
        }
    }

    @Override
    public int getFixedFee() {
        return super.getFixedFee();
    }

}