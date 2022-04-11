/**
 * Item object class with all getter methods.
 *
 * @author  Ozan Açıkgöz - 250201060
 * @author  Burak Ersever - 240201014
 */

public class Item {
    private String name;
    private int id;
    private String category;

    public Item(String name, int id, String category) {
        this.name = name;
        this.id = id;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}