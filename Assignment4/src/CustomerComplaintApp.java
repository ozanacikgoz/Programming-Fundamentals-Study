import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CustomerComplaintApp implements IComplaint {
    private int indexofUser = 0;
    private int indexofComplaint;
    private int customerrID = 0;
    private int producerrID = 0;
    private int producttID = 0;
    private int complainttID;

    public CustomerComplaintApp(int indexofUser, int indexofComplaint, int customerrID, int producerrID, int producttID, int complainttID) {
        this.indexofUser = indexofUser;
        this.indexofComplaint = indexofComplaint;
        this.customerrID = customerrID;
        this.producerrID = producerrID;
        this.producttID = producttID;
        this.complainttID = complainttID;
    }

    public void signup(ArrayList<User> userCsv, PrintWriter userprinter, Scanner scanner) {
        while (true) {
            String line;
            System.out.println("Customer?(C) or Producer?(P)");
            line = scanner.next();

            if (line.equals("C")) {
                System.out.println("Write your Username,password and DisplayedName respectively with separated commas:(username,password,displayedname)");
                String inputwrite = scanner.next();
                String[] currentCustomer = inputwrite.split(",");
                int customerID = userCsv.size() + 1;
                String customerName = currentCustomer[0];
                String password = currentCustomer[1];
                String displayedName = currentCustomer[2];
                userprinter.append("\n" + customerID + "," + customerName + "," + password + "," + displayedName + "," + "customer");
                userCsv.add(new User(customerID, customerName, password, displayedName, "customer"));
                userprinter.close();
                System.exit(0);
            } else if (line.equals("P")) {
                System.out.println("Write your Username,password and DisplayedName respectively with separated commas:(username,password,displayedname)");
                String inputwrite = scanner.next();
                String[] currentProducer = inputwrite.split(",");
                int producerID = userCsv.size() + 1;
                String producerName = currentProducer[0];
                String password = currentProducer[1];
                String displayedName = currentProducer[2];
                userprinter.append("\n" + producerID + "," + producerName + "," + password + "," + displayedName + "," + "producer");
                userCsv.add(new User(producerID, producerName, password, displayedName, "producer"));

                userprinter.close();
                System.exit(0);
            } else {
                System.out.println("There are only 2 types of user (Customer or Producer");
                continue;
            }

        }
    }

    public void login(Scanner scanner, ArrayList<User> userCsv, PrintWriter productprinter, PrintWriter complaintwriter, ArrayList<Complaint> complaintCsv, ArrayList<Product> productCsv, ArrayList<Producer> producerArrayList, ArrayList<String> productTypeList) {

        while (true) {
            boolean loginFlag = false;
            System.out.println("Username:");
            String username = scanner.next();
            System.out.println("Password:");
            String password = scanner.next();

            for (int i = 0; i < userCsv.size(); i++) {
                if (username.equals(userCsv.get(i).getUserName())) {
                    if (password.equals(userCsv.get(i).getPassword())) {
                        indexofUser = i;
                        System.out.println("Login successful");
                        loginFlag = true;
                    } else {
                        System.out.println("Login is not successful");
                        continue;
                    }
                }
            }
            if (loginFlag) {
                if (userCsv.get(indexofUser).getUserType().equals("customer")) {

                    System.out.println("Add a complaint?(A),View previous complaint?(V)");
                    String response = scanner.next();
                    if (response.equals("V")) {
                        System.out.println("Choose a complaint:");
                        for (int i = 0; i < complaintCsv.size(); i++) {
                            if (complaintCsv.get(i).getCustomerID() == userCsv.get(indexofUser).getUserID()) {
                                System.out.println(complaintCsv.get(i).getComplaintTitle());
                            }
                        }
                        String complaintResponse = scanner.next();
                        System.out.println("Wanna delete?(D) or See contents?(S)");
                        String response3 = scanner.next().toUpperCase();
                        if (response3.equals("D")) {
                            for (int i = 0; i < complaintCsv.size(); i++) {
                                if (complaintResponse.equals(complaintCsv.get(i).getComplaintTitle())) {
                                    if (!complaintCsv.get(i).getStatus().equals("not Fixed")) {
                                        complaintCsv.get(i).setStatus("Deleted");
                                        System.out.println("Status changed to deleted.");
                                        complaintwriter.append("\n").append(String.valueOf(complaintCsv.get(i).getComplaintID())).append(",").append(String.valueOf(complaintCsv.get(i).getCustomerID())).append(",").append(String.valueOf(complaintCsv.get(i).getProducerID())).append(",").append(String.valueOf(complaintCsv.get(i).getProductID())).append(",").append(complaintCsv.get(i).getComplaintTitle()).append(",").append(complaintCsv.get(i).getComplaint()).append(",").append("Deleted");
                                    }
                                     else
                                        System.out.println("Status is " + complaintCsv.get(i).getStatus() + ". You can't delete that. ");
                                    System.exit(0);
                                }
                            }

                        } else if (response3.equals("S")) {
                            for (int i = 0; i < complaintCsv.size(); i++) {
                                if (complaintResponse.equals(complaintCsv.get(i).getComplaintTitle())) {
                                    System.out.println(complaintCsv.get(i).getComplaintID() + "," + complaintCsv.get(i).getCustomerID() + "," + complaintCsv.get(i).getProducerID() + "," + complaintCsv.get(i).getProductID() + "," + complaintCsv.get(i).getComplaintTitle() + "," + complaintCsv.get(i).getComplaint() + "," + complaintCsv.get(i).getStatus());
                                    System.exit(0);
                                }
                            }
                        } else {
                            System.out.println("There are only 2 two types of operations:(See content or Delete Content(S/D))");
                            continue;
                        }
                    }
                    if (response.equals("A")) {
                        System.out.println("Choose a producer from the producer list.");

                        for (Producer producer : producerArrayList) {
                            System.out.println(producer.getDisplayedName());
                        }
                        String producerResponse = scanner.next();
                        System.out.println("Choose a product type from the  product type list.");
                        for (Product value : productCsv) {
                            System.out.println(value.getProductType());
                        }
                        String productTypeResponse = scanner.next();
                        System.out.println("Choose a product from the product list.");
                        for (Product product : productCsv) {
                            System.out.println(product.getProductName());
                        }
                        String productResponse = scanner.next();
                        System.out.println("Add your complaint title.");
                        String complaintTitleResponse = scanner.next();
                        scanner.nextLine();
                        System.out.println("Add your complaint.");
                        String complaintResponse = scanner.next();


                        for (User user : userCsv) {
                            if (username.equals(user.getUserName())) {
                                if (user.getUserType().equals("producer"))
                                    producerrID = user.getUserID();
                                else if (user.getUserType().equals("customer"))
                                    customerrID = user.getUserID();
                            }
                        }
                        for (int i = 0; i < productCsv.size(); i++) {
                            if (productResponse.equals(productCsv.get(i).getProductName())) {
                                producttID = productCsv.get(i).getProductID();
                                producerrID = producerArrayList.get(i).getProducerID();
                            }
                        }
                        complainttID = complaintCsv.size() + 1;

                        complaintwriter.append("\n").append(String.valueOf(complainttID)).append(",").append(String.valueOf(customerrID)).append(",").append(String.valueOf(producerrID)).append(",").append(String.valueOf(producttID)).append(",").append(complaintTitleResponse).append(",").append(complaintResponse).append(",").append("New");
                        complaintCsv.add(new Complaint(complainttID, customerrID, producerrID, producttID, complaintTitleResponse, complaintResponse, "New"));
                        complaintwriter.close();
                        System.exit(0);
                    }
                    else{
                        System.out.println("There is only two options,Try again");
                        continue;
                    }

                } else if (userCsv.get(indexofUser).getUserType().equals("producer")) {
                    System.out.println("See the complaints?(S) or Add a new product(A)");
                    String response = scanner.next().toUpperCase();
                    if (response.equals("A")) {
                        System.out.println("Add a new product with new type?(N) or Add a new product with existing type?(E)");
                        String inputwrite = scanner.next().toUpperCase();
                        if (inputwrite.equals("E")) {
                            System.out.println("These are existing product types: ");
                            HashSet<String> uniqueTypeList = new HashSet(productTypeList);
                            System.out.println(uniqueTypeList);
                            System.out.println("Please write the product type you will add");
                            String existingProductTypeinput = scanner.next();
                            for (int j = 0; j < productCsv.size(); j++) {
                                if (existingProductTypeinput.equals(productCsv.get(j).getProductType())) {
                                    System.out.println("Please enter your products name");
                                    String existingProductinput2 = scanner.next();

                                    String[] currentProduct = existingProductinput2.split(",");
                                    int productID = productCsv.size() + 1;
                                    int producerID = userCsv.get(indexofUser).getUserID();
                                    String productName = currentProduct[0];

                                    productprinter.append("\n").append(String.valueOf(productID)).append(",").append(String.valueOf(producerID)).append(",").append(productName).append(",").append(existingProductTypeinput);
                                    productCsv.add(new Product(productID, producerID, productName, existingProductTypeinput));
                                    System.out.println(productCsv);
                                    System.out.println("Add another product with same type?(A) or Exit?(E)");
                                    String input3 = scanner.next().toUpperCase();
                                    if (input3.equals("E")) {
                                        productprinter.close();
                                        System.out.println("Bye.");
                                        System.exit(0);
                                    } else if (input3.equals("A")) {
                                        continue;
                                    } else {
                                        System.out.println("There are only two types of operations(E/A)");
                                    }

                                }
                            }
                        }
                        if (inputwrite.equals("N")) {
                            while (true) {
                                System.out.println("Please write the product name and product type respectively, you will add.");
                                String newProductinput = scanner.next();
                                String[] newProduct = newProductinput.split(",");
                                int productID = productCsv.size() + 1;
                                int producerID = userCsv.get(indexofUser).getUserID();
                                String productName = newProduct[0];
                                String productType = newProduct[1];
                                productprinter.append("\n").append(String.valueOf(productID)).append(",").append(String.valueOf(producerID)).append(",").append(productName).append(",").append(productType);
                                productCsv.add(new Product(productID, producerID, productName, productType));

                                System.out.println("Add another new product?(A) or Exit(E)");
                                String responseInput = scanner.next().toUpperCase();
                                if (responseInput.equals("E")) {
                                    break;
                                } else if (responseInput.equals("A")) {
                                    continue;
                                }
                            }
                            System.out.println(productCsv);
                            productprinter.close();


                        } else {
                            System.out.println("There are only 2 two types of operations(E/N)");
                            continue;
                        }
                    } else if (response.equals("S")) {
                        System.out.println("Choose a complaint from the complaint list please:(1,2,3,4..)");


                        for (int i = 0; i < complaintCsv.size(); i++) {
                            if (productCsv.get(i).getProducerID() == complaintCsv.get(i).getProducerID()) {
                                System.out.println((i + 1) + ") " + complaintCsv.get(i).getComplaintTitle());
                            }
                        }

                        String complaintResponse = scanner.next();
                        indexofComplaint = Integer.parseInt(complaintResponse);
                        if(complaintCsv.get(indexofComplaint).getStatus().equals("New")){
                            complaintCsv.get(indexofComplaint).setStatus("Seen");
                            System.out.println("The complaint was new and the program set to seen.");
                        }
                        System.out.println("You wanna change the status of complaint?(Y/N)");
                        String producerinputt=scanner.next();
                        if(producerinputt.equals("Y")){
                            System.out.println("What do you want to change with?");
                            String producerinputtt=scanner.next();
                            if(producerinputtt.equals("Seen")){
                                System.out.println("It cannot changed to Seen");
                            }
                            else{
                                complaintCsv.get(indexofComplaint).setStatus(producerinputtt);
                                System.out.println("You have changed the status with "+producerinputtt);
                            }
                        }

                        for (Complaint complaint : complaintCsv) {
                            for (Product product : productCsv) {
                                if (product.getProducerID() == complaint.getProducerID()) {
                                    System.out.println(complaintCsv.get(indexofComplaint - 1));
                                    System.exit(0);
                                }
                            }
                        }
                    } else {
                        System.out.println("There are only 2 types of operations (See and Add(S/A))");
                        continue;
                    }
                } else if (userCsv.get(indexofUser).getUserType().equals("admin")) {
                    System.out.println("All the complaints:");
                    for (int i = 0; i < complaintCsv.size(); i++) {
                        indexofComplaint = i + 1;
                        System.out.println(indexofComplaint + ") " + complaintCsv.get(i).getComplaintTitle());
                    }
                    System.out.println("Choose a complaint(1,2,3,4..)");
                    int admininput1 = scanner.nextInt();

                    System.out.println("Do you want to see the contents of complaints?(Y/N)?");
                    String admininput2 = scanner.next();
                    if (admininput2.equals("Y")) {
                        System.out.println(admininput1 + "," + complaintCsv.get(admininput1 - 1).getCustomerID() + "," + complaintCsv.get(admininput1 - 1).getProducerID() + "," + complaintCsv.get(admininput1 - 1).getProductID() + "," + complaintCsv.get(admininput1 - 1).getComplaintTitle() + "," + complaintCsv.get(admininput1 - 1).getComplaint() + "," + complaintCsv.get(admininput1 - 1).getStatus());
                        System.out.println("wanna change status?(Y/N)?");
                        String statusinputt = scanner.next();
                        if (statusinputt.equals("Y")) {
                            System.out.println("Status is: " + complaintCsv.get(admininput1 - 1).getStatus());
                            System.out.println("Enter new status:");
                            String admininput3 = scanner.next();
                            complaintCsv.get(admininput1 - 1).setStatus(admininput3);
                            System.out.println("Status changed to " + admininput3);
                        }

                    } else
                        System.out.println("Okay, bye.");
                    System.exit(0);
                } else {
                    System.exit(0);
                }
            }
            else {
                System.out.println("Wrong username or password.");
                continue;
            }
        }

    }
}


