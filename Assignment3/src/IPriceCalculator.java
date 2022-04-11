public interface IPriceCalculator {
    double calculatePrice(NormalCargo<?> normalCargo);
    double discountCalculator(double price,int discountPercentage);
}
