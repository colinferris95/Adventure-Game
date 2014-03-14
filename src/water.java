
public class water extends locationClass {
    private String water;


    // Constructor
    public water(int id){
        super(id);
    }

    // Getters and Setters
    public String getWater() {
        return water;
    }
    public void setWater(String water) {
        this.water = water;
    }


    @Override
    public String toString() {
        return "Space..." + super.toString() + " nearestPlanet=" + this.water;
    }

    //
    // Private
    //

}
