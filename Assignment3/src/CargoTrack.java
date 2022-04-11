import java.time.DayOfWeek;

public abstract class CargoTrack<T> implements ICargo<T> {
    private String type;
    private int weight;
    private int width;
    private int height;
    private int length;

    public CargoTrack(String type, int weight, int width, int height, int length) {
        this.type = type;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getLength() {
        return length;
    }

    public abstract DayOfWeek getDeliveryDay();
    public abstract int getSize();
}