


public class listMan {

    //
    // Public
    //

    // Constructor
    public listMan() {
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

    public gameItems getHead() {
        return head;
    }
    public void setHead(gameItems head) {
        this.head = head;
    }



    public void add(gameItems item) {
        // System.out.println("adding " + item.toString());
        if (this.head == null) {
            // The list is empty.
            this.head = item;
            this.last = item;
        } else {
            // The list is NOT empty.
            this.last.setNext(item);
            this.last = item;

            // Before:
            // 1. Move to the end of the list.
            /*
            ListItem lastItem = this.head;
            while (lastItem.getNext() != null) {
                lastItem = lastItem.getNext();
            }
            // 2. Attach the passed-in item to the last item in the list.
            lastItem.setNext(item);
            */
        }



    }

    // Other methods
    @Override
    public String toString() {
        String retVal = new String();
        retVal = super.toString() + " name=" + this.name + " desc=" + this.desc + "\n";
        gameItems currentItem = this.head;
        while (currentItem != null) {
            retVal = retVal + "   " + currentItem.toString() + "\n";
            currentItem = currentItem.getNext();
        }
        return retVal;
    }


    //
    // Private
    //
    private String name;
    private String desc;

    private gameItems head = null;
    private gameItems last = null;


}