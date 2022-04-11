public class PriceCalculator implements IPriceCalculator {
    @Override
    public double calculatePrice(NormalCargo<?> normalCargo) {
        return 18.5 + (3 * normalCargo.getSize());
    }

    @Override
    public double discountCalculator(double price,int discountPercentage) {
        return 0;
    }
}
