

public class locationClass {

    private int    id;
    private String name;
    private String desc;
    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }





    public locationClass(int theId) {
        id = theId;
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


    public String toString() {
        return "[location class: id=" + this.id + " name="+ this.name + " desc=" + this.desc + "]";

    }


}