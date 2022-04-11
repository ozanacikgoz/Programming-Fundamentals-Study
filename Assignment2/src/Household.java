/**
 * We calculate the policy charge for premises.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class Household extends Insurance {

    public Household() {
        super();
    }

    @Override
    public  double calculatePolicyCharge(InsuredValue premises) {
        int rankingOfInsurance = 2020 - premises.getYearOfInsurance();
        if (rankingOfInsurance > 2) {
            return (getFixedFee() * premises.calculateRiskFactor() * premises.calculateRiskFactor() * 0.9);
        }
        else {
            return getFixedFee() * premises.calculateRiskFactor() * premises.calculateRiskFactor();
        }
    }

    @Override
    public int getFixedFee() {
        return super.getFixedFee();
    }
}