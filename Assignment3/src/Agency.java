import java.util.ArrayList;

public class Agency<T> {
    private ArrayList<T> allcargos;
    private int amazonCounter;
    private int hepsiburadaCounter;
    private int n11Counter;
    private int trendyolCounter;
    private int acceptedCounter = 0;
    private int notAcceptedCounter = 0;
    private ECommerceCargo E;

    public Agency(ArrayList<T> allcargos) {
        this.allcargos = new ArrayList<>(allcargos);
    }

    public void statusChanger() {
        for (T allcargo : allcargos) {
            if (allcargo instanceof ECommerceCargo) {
                switch (((ECommerceCargo<?>) allcargo).getEcommerce_site_name()) {
                    case "Amazon":
                        int dailyPackageLimit = 5;
                        amazonCounter++;
                        if (amazonCounter > dailyPackageLimit) {
                            ((ECommerceCargo<?>) allcargo).setStatus(Acceptance.NOT_ACCEPTED);
                        }
                        break;
                    case "Hepsiburada":
                        dailyPackageLimit = 7;
                        hepsiburadaCounter++;
                        if (hepsiburadaCounter > dailyPackageLimit) {
                            ((ECommerceCargo<?>) allcargo).setStatus(Acceptance.NOT_ACCEPTED);
                        }
                        break;
                    case "N11":
                        dailyPackageLimit = 6;
                        n11Counter++;
                        if (n11Counter > dailyPackageLimit) {
                            ((ECommerceCargo<?>) allcargo).setStatus(Acceptance.NOT_ACCEPTED);
                        }
                        break;
                    case "Trendyol":
                        dailyPackageLimit = 9;
                        trendyolCounter++;
                        if (trendyolCounter > dailyPackageLimit) {
                            ((ECommerceCargo<?>) allcargo).setStatus(Acceptance.NOT_ACCEPTED);
                        }
                        break;
                }
            }
        }
    }
    public int[]  acceptanceCounterChecker() {
        for (T cargo : allcargos) {
            if (cargo instanceof ECommerceCargo) {
                E = (ECommerceCargo) cargo;
                if (((ECommerceCargo<?>) cargo).getStatus().equals(Acceptance.ACCEPTED)) {
                    acceptedCounter++;
                } else if (((ECommerceCargo<?>) cargo).getStatus().equals(Acceptance.NOT_ACCEPTED)) {
                    notAcceptedCounter++;
                }
            }
        }
        return new int[] {acceptedCounter,notAcceptedCounter};
    }
}