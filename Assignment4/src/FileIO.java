import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    private ArrayList<User> userCsv;
    private ArrayList<Product> productCsv;
    private ArrayList<Complaint> complaintCsv;
    private ArrayList<Admin> adminArrayList;
    private ArrayList<Customer> customerArrayList;
    private ArrayList<Producer> producerArrayList;
    private ArrayList<ArrayList> allthings;

    public FileIO() {
        this.userCsv = new ArrayList();
        this.productCsv = new ArrayList();
        this.complaintCsv = new ArrayList();
        this.allthings=new ArrayList<>();
        this.adminArrayList=new ArrayList<>();
        this.customerArrayList=new ArrayList<>();
        this.producerArrayList=new ArrayList<>();
    }

    public ArrayList<ArrayList> read(String csv) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(csv));
        scanner.useDelimiter("[\r\n]+");
        while (scanner.hasNext()) {
            String line = scanner.next();
            String[] lineSplit = line.split(",");

            if(lineSplit.length==5) {
                userCsv.add(userConstructor(lineSplit));

                if(lineSplit[4].equals("admin")){
                    adminArrayList.add(adminConstructor(lineSplit));
                }
                else if(lineSplit[4].equals("customer")){
                    customerArrayList.add(customerConstructor(lineSplit));
                }
                else if(lineSplit[4].equals("producer")){
                    producerArrayList.add(producerConstructor(lineSplit));
                }

            }
            if(lineSplit.length==4){
                productCsv.add(productConstructor(lineSplit));
            }
            if(lineSplit.length==7){
                complaintCsv.add(complaintConstructor(lineSplit));
            }
        }
        allthings.add(userCsv);
        allthings.add(adminArrayList);
        allthings.add(customerArrayList);
        allthings.add(producerArrayList);
        allthings.add(productCsv);
        allthings.add(complaintCsv);

        return allthings;
    }
    private User userConstructor(String[] data){
        int userID=Integer.parseInt(data[0]);
        String userName=data[1];
        String password=data[2];
        String displayedName=data[3];
        String userType=data[4];
        return new User(userID,userName,password,displayedName,userType);
    }
    private Admin adminConstructor (String[] data ){
        int adminID=Integer.parseInt(data[0]);
        String adminName=data[1];
        String password=data[2];
        String displayedName=data[3];
        String userType=data[4];
        return new Admin(adminID,adminName,password,displayedName,userType);
    }
    private Customer customerConstructor(String[] data){
        int customerID=Integer.parseInt(data[0]);
        String customerName=data[1];
        String password=data[2];
        String displayedName=data[3];
        String userType=data[4];
        return new Customer(customerID,customerName,password,displayedName,userType);
    }

    private Producer producerConstructor(String[] data){
        int producerID=Integer.parseInt(data[0]);
        String producerName=data[1];
        String password=data[2];
        String displayedName=data[3];
        String userType=data[4];
        return new Producer(producerID,producerName,password,displayedName,userType);
    }
    private Product productConstructor(String[] data){
     int productID=Integer.parseInt(data[0]);
     int producerID=Integer.parseInt(data[1]);
     String productName=data[2];
     String productType=data[3];
     return new Product(productID,producerID,productName,productType);
    }

    private Complaint complaintConstructor(String[] data){
        int complaintID=Integer.parseInt(data[0]);
        int customerID=Integer.parseInt(data[1]);
        int producerID=Integer.parseInt(data[2]);
        int productID=Integer.parseInt(data[3]);
        String complaintTitle=data[4];
        String complaint=data[5];
        String status=data[6];
        return new Complaint(complaintID,customerID,producerID,productID,complaintTitle,complaint,status);
    }
}
