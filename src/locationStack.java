
public class locationStack  {
    //
    // Public
    //
    public locationStack(){
        init();
    }

    public void push(int item) {
        // Check for stack overflow.
        if (topPtr > 0) {
            topPtr = topPtr - 1;
            arr[topPtr] = item;
        } else {


        }
    }

    public int pop(){
        int retVal = 0;
        // Check for stack underflow.
        if (topPtr < CAPACITY) {
            retVal = arr[topPtr];
            topPtr = topPtr + 1;
        } else {
            // In case of underflow, return -1.
            // TODO: Throw an underflow exception.
            retVal = -1;
        }
        return retVal;
    }

    public boolean isEmpty() {
        boolean retVal = false;
        if (topPtr == CAPACITY) {
            retVal = true;
        }
        return retVal;
    }


    public int getCAPACITY() {
        return CAPACITY;
    }

    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    //
    // Private
    //
    private int CAPACITY = 1;
    private int[] arr = new int[CAPACITY];
    private int topPtr = 0;

    private void init() {
        for (int i = 0; i < CAPACITY; i++) {
            arr[i] = 0;
        }
        topPtr = CAPACITY;
    }


}
