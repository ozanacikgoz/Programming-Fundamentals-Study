import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        FileIO f =new FileIO();
        ArrayList<User> userCsv;
        ArrayList<Product> productCsv;
        ArrayList<Complaint> complaintCsv;
        ArrayList<Producer> producerArrayList;
        ArrayList<String> productTypeList = new ArrayList<>();

        ArrayList<ArrayList> all = f.read("User.csv");
        all.add(f.read("Product.csv"));
        all.add(f.read("Complaint.csv"));

        userCsv = all.get(0);
        producerArrayList = all.get(3);
        productCsv = all.get(4);
        complaintCsv = all.get(5);


        CustomerComplaintApp c1 = new CustomerComplaintApp(0,0,0,0,0,0);

        PrintWriter userwriter = new PrintWriter(new BufferedWriter(new FileWriter("User.csv", true)));
        PrintWriter productwriter = new PrintWriter(new BufferedWriter(new FileWriter("Product.csv", true)));
        PrintWriter complaintwriter = new PrintWriter(new BufferedWriter(new FileWriter("Complaint.csv", true)));

        productTypeList= (ArrayList) productTypeList.stream().distinct().collect(Collectors.toList());

        for (Product item : productCsv) {
            productTypeList.add(item.getProductType());
        }

        while (true){
            System.out.println("Sign up?(S) or Login?(L)");
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("[\r\n]+");
            String input = scanner.next().toUpperCase();
            System.out.println(input);
            if(input.equals("S")){
                c1.signup(userCsv,userwriter,scanner);
            }
            else if(input.equals("L")){
                c1.login(scanner,userCsv,productwriter,complaintwriter,complaintCsv,productCsv,producerArrayList,productTypeList);
            }
            else {
                System.out.println("S or L is the right operations.");
                continue;
            }
        }
    }
}
