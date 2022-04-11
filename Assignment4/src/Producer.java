public class Producer extends User{
    private int producerID;
    public Producer(int userID, String userName, String password, String displayedName, String userType) {
        super(userID, userName, password, displayedName, userType);
        this.producerID=userID;
    }


    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public int getProducerID() {
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
        return "Producer{" +
                "ProducerID=" + getProducerID() +" "+super.toString();
    }

}
