import java.time.DayOfWeek;
import java.time.LocalDate;

public class ECommerceCargo<T> extends CargoTrack implements ICargo {
    private String ecommerce_site_name;
    private T cargo_code;
    private Acceptance status = Acceptance.ACCEPTED;

    public ECommerceCargo(String type, String ecommerce_site_name,T cargo_code, int weight, int width, int height, int length) {
        super(type, weight, width, length, height);
        this.ecommerce_site_name = ecommerce_site_name;
        this.cargo_code = cargo_code;
    }

    public String getEcommerce_site_name() {
        return ecommerce_site_name;
    }

    public T getCargo_code() {
        return cargo_code;
    }

    public Acceptance getStatus() {
        return status;
    }

    public void setStatus(Acceptance status) {
        this.status = status;
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

        if(dow.equals(DayOfWeek.FRIDAY) || dow.equals(DayOfWeek.SATURDAY) || dow.equals(DayOfWeek.SUNDAY)) {
            dow = dow.plus(3);
        }
        else {
            dow = dow.plus(2);
        }
        return dow;
    }
}
