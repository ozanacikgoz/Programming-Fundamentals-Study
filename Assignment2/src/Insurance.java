/**
 * This Insurance class is base class of health,household
 * and traffic classes. We get the fixed fee to calculate
 * the policy charge in this class.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class Insurance {

    public Insurance() {

    }

    public double calculatePolicyCharge(InsuredValue insuredValues){
        return 0.0;
    }

    public int getFixedFee(){
        int min = 1000;
        int max = 3000;
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        return random_int;
    }

}