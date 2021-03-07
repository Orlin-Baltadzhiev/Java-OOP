package Garage;

public class Car extends Vehicle {
  private static final double AIR_CONDITIONER_CONSUMPTION = 0.9;


    public Car(double fuel, double fuelConsumption, int capacity) {
        super(fuel, fuelConsumption + AIR_CONDITIONER_CONSUMPTION, capacity);
    }
    @Override
    public String toString(){
        return "Car" + super.toString();
    }

    @Override
    public String drive(double distance){
        return "Car" + super.drive(distance);
    }


}
