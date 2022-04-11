public class Product {
    private int productID;
    private int producerID;
    private String productName;
    private String productType;

    public Product(int productID, int producerID, String productName, String productType) {
        this.productID = productID;
        this.producerID = producerID;
        this.productName = productName;
        this.productType = productType;
    }

    public int getProductID() {
        return productID;
    }

    public int getProducerID() {
        return producerID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", producerID=" + producerID +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }
}
