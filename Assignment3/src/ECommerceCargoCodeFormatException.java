public class ECommerceCargoCodeFormatException extends Exception {
    public ECommerceCargoCodeFormatException(int counter){
        super("Your E-CommerceCargo's code format is wrong in line " + counter + ".");
    }
}