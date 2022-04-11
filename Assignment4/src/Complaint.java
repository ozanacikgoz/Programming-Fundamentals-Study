import java.util.ArrayList;

public class Complaint {
    private int complaintID;
    private int customerID;
    private int producerID;
    private int productID;
    private String complaintTitle;
    private String complaint;
    private String status;

    public Complaint(int complaintID, int customerID, int producerID, int productID, String complaintTitle, String complaint, String status) {
        this.complaintID = complaintID;
        this.customerID = customerID;
        this.producerID = producerID;
        this.productID = productID;
        this.complaintTitle = complaintTitle;
        this.complaint = complaint;
        this.status = status;
    }

    public int getComplaintID() {
        return complaintID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getProducerID() {
        return producerID;
    }

    public int getProductID() {
        return productID;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintID=" + complaintID +
                ", customerID=" + customerID +
                ", producerID=" + producerID +
                ", productID=" + productID +
                ", complaintTitle='" + complaintTitle + '\'' +
                ", complaint='" + complaint + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
