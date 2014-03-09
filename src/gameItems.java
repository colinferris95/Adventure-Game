/**
 * Created by cfer on 3/8/14.
 */
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


    public String toString() {
        return "[item: id=" + this.id + " name="+ this.itemName + " desc=" + this.desc + "]";

    }

    private int    id;



    private String itemName;
    private String desc;
}
