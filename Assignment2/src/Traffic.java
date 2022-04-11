/**
 * We calculate the policy charge for vehicles.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class Traffic extends Insurance {

    public Traffic() {
        super();
    }

    @Override
    public double calculatePolicyCharge(InsuredValue vehicle) {
        int rankingOfInsurance = 2020 - vehicle.getYearOfInsurance();
        if (rankingOfInsurance > 1) {
            return (getFixedFee() * 0.9) + (getFixedFee() * Math.sqrt(vehicle.calculateRiskFactor()) * 0.8);
        } else {
            return (getFixedFee() * 0.9) + (getFixedFee() * Math.sqrt(vehicle.calculateRiskFactor()));
        }
    }

    @Override
    public int getFixedFee() {
        return super.getFixedFee();
    }
}