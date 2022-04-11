import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public interface IComplaint {
    public void signup(ArrayList<User> userCsv, PrintWriter userprinter, Scanner scanner);
    public void login(Scanner scanner, ArrayList<User> userCsv, PrintWriter productprinter, PrintWriter complaintwriter, ArrayList<Complaint> complaintCsv, ArrayList<Product> productCsv, ArrayList<Producer> producerArrayList, ArrayList<String> productTypeList);

}
