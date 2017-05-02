package pcc.edu.zuul;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private HashSet items;

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap();
        this.items = new HashSet();
    }

    public void setExits(String direction, Room neighbor) {
        this.exits.put(direction, neighbor);
    }

    public String getDescription() {
        return this.description;
    }

    public Room getExit(String direction) {
        return (Room)this.exits.get(direction);
    }

    public String getItemString() {
        String returnString = "Items:";

        for(Iterator iter = this.items.iterator(); iter.hasNext(); returnString = returnString + " " + ((Item)iter.next()).getDescription()) {
            ;
        }

        return returnString;
    }

    public String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = this.exits.keySet();

        String exit;
        for(Iterator var3 = keys.iterator(); var3.hasNext(); returnString = returnString + " " + exit) {
            exit = (String)var3.next();
        }

        return returnString;
    }

    public String getLongDescription() {
        return "You are " + this.description + ".\n" + this.getExitString() + ".\n" + this.getItemString();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
