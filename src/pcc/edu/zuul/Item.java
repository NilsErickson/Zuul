/**
 * Created new Java class to integrate with newer IDE
 * Added new lines under "Help" Command to further explain newer commands
 * author: Nils Erickson
 * version: 05.02.2017
 */

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
