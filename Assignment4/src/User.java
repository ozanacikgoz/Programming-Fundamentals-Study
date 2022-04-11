public class User {
    private int userID;
    private String userName;
    private String password;
    private String displayedName;
    private String userType;

    public User(int userID, String userName, String password, String displayedName, String userType) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.displayedName = displayedName;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public String getDisplayedName() {
        return displayedName;
    }

    @Override
    public String toString() {
        return
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", displayedName='" + displayedName + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
