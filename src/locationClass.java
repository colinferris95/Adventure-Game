

public class locationClass {

    private int    id;
    private String name;
    private String desc;
    private String item;
    private boolean hasVisited = false;



    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public locationClass(int theId) {
        this.id = theId;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String value) {


       desc = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public boolean getHasVisited() {
        return hasVisited;
    }

    public void setHasVisited(boolean hasVisited) {
        this.hasVisited = hasVisited;
    }



    public String toString() {
        return "[location class: id=" + this.id + " name="+ this.name + " desc=" + this.desc + "]";

    }


}