public class Admin extends User{
    private int adminID;
    public Admin(int userID, String userName, String password, String displayedName, String userType) {
        super(userID, userName, password, displayedName, userType);
    }


    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public int getAdminID() {
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
        return "Admin{" +
                "AdminID=" + getAdminID() +" "+super.toString();
    }
}
