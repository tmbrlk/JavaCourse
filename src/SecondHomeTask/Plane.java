package SecondHomeTask;

public class Plane implements Comparable<Object>, Cloneable {
    
    private static final int PRIVATE = 2;
    private static final int PASSENGER = 1;
    private static final int LIFT = 0;
    
    protected String model;
    protected int capacity;
    protected int liftingCapacity;
    protected int flyghtRange;
    protected int fuelConsumption;
    private static Plane[] planes = {new LiftPlane(), new PassangerPlane(), new PrivatePlane()};
    
    @Override
    public int compareTo(Object o) {
            Plane tmp = (Plane)o;
            return this.flyghtRange - tmp.flyghtRange;
           
    }
   
    public int getCapacity(){
            return capacity;
    }
   
    public int getLift(){
            return liftingCapacity;
    }
    
    public boolean isPositiveFuelCondition(int low, int high){
    	if(low <= fuelConsumption && high >= fuelConsumption){
    		return true;
    	}
    	return false;
    }
   
    public String toString(){
            return this.getClass().getSimpleName() + ":" + "(Model - " + model + "; FuelConsumption - " 
            												+ fuelConsumption + "; Capacity - " + capacity 
            													+ "; Lifting - " + liftingCapacity 
            														+ "; Range - " + flyghtRange + ")" + "\n";
    }
   
    private static class LiftPlane extends Plane {
           
    }
   
    private static class PassangerPlane extends Plane {
           
    }
   
    private static class PrivatePlane extends Plane {
           
    }
   
    public static Plane createPlane(String model, int fuel, int capacity, int liftCapacity, int flyghtRange){
            int planeIndex = 0;
            if (liftCapacity > 1000){
                    planeIndex = LIFT;
            }
            else if (capacity > 20){
                    planeIndex = PASSENGER;
            }
            else{
                    planeIndex = PRIVATE;
            }
            Plane tmpPlane = planes[planeIndex];
            try {
                    Plane curPlane = (Plane) tmpPlane.clone();
                    curPlane.model = model;
                    curPlane.fuelConsumption = fuel;
                    curPlane.capacity = capacity;
                    curPlane.liftingCapacity = liftCapacity;
                    curPlane.flyghtRange = flyghtRange;
                   
                    return curPlane;
            } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
            }
           
            return null;
    }
    public Plane() {};
   
}
