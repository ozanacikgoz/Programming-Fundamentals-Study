import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

public class NormalCargo<T> extends CargoTrack implements ICargo {
    private long senderID;
    private String senderName;
    private String recipientName;
    private String recipientAddress;

    public NormalCargo(String type, long senderID, String senderName, String recipientName, String recipientAddress, int weight, int width, int length, int height) {
        super(type, weight, width, length, height);
        this.senderID = senderID;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
    }

    public long getSenderID() {
        return senderID;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public Integer getCargoCode() {
        Random rnd = new Random();
        return 1000000 + rnd.nextInt(9000000);
    }

    @Override
    public int getSize() {
        int desi = (getWidth() * getLength() * getHeight()) / 3000;
        return Math.max(getWeight(), desi);
    }

    @Override
    public DayOfWeek getDeliveryDay() {
        LocalDate date = LocalDate.now();
        DayOfWeek dow = date.getDayOfWeek();
        if(dow.equals(DayOfWeek.FRIDAY)){
            dow = dow.plus(3);
        }
        else
            dow = dow.plus(2);
        return dow;

    }
}