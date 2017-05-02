package pcc.edu.zuul;

public class Item {
    private String description;
    private int weight;

    public Item(String description, int weight) {
        this.description = description;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getDescription() {
        return this.description;
    }
}
