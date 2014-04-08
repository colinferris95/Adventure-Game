
public class gameItems {


    public gameItems(int theId) {
        id = theId;
    }
    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public gameItems getNext() {
        return next;
    }

    public void setNext(gameItems next) {
        this.next = next;
    }


    public String toString() {
        return "[item: id=" + this.id + " name="+ this.itemName + " desc=" + this.desc +  " cost " + this.cost + "]";

    }



    private int    id;
    private String itemName;
    private String desc;
    private int loc;
    private double cost;
    private gameItems next = null;
}
