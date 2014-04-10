
public class locationListMan {

    private locationClass head = null;
    private locationClass last = null;


    public locationClass getHead() {
        return head;
    }
    public void setHead(locationClass head) {
        this.head = head;
    }

    public void add(locationClass location) {

        if (this.head == null) {

            this.head = location;
            this.last = location;
        } else {

            this.last.setNext(location);
            this.last = location;


        }



    }
}
