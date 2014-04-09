
public class locationListMan {

    private locationClass head = null;
    private locationClass last = null;


    public locationClass getHead() {
        return head;
    }
    public void setHead(locationClass head) {
        this.head = head;
    }

    public void add(locationClass item) {

        if (this.head == null) {

            this.head = item;
            this.last = item;
        } else {

            this.last.setNext(item);
            this.last = item;


        }



    }
}
