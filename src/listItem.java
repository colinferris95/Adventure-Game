public class listItem {

    //
    // Public
    //

    // Constructor
    public listItem(){
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public listItem getNext() {
        return next;
    }
    public void setNext(listItem next) {
        this.next = next;
    }

    // Other methods
    @Override
    public String toString() {
        return super.toString() + " name=" + this.name + " desc=" + this.desc;
    }


    //
    // Private
    //
    private String name;
    private String desc;
    private listItem next = null;

}