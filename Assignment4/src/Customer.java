public class Customer extends User {
    public Customer(int userID, String userName, String password, String displayedName, String userType) {
        super(userID, userName, password, displayedName, userType);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public int getCustomerID(){
        return super.getUserID();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }


    @Override
    public String getUserType() {
        return super.getUserType();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID=" + getCustomerID() +" "+super.toString();
    }


}
