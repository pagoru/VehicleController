package es.pagoru.vehiclecontroller.vehicles;

/**
 * Created by pablo on 3/2/17.
 */
public class AerialVehicle extends Vehicle {

    private int motors;
    private int running_time;

    public AerialVehicle(Vehicle vehicle,
                         int motors,
                         int running_time) {

        super(vehicle.getMin_consumption(),
                vehicle.getCurrent_charge(),
                vehicle.getMax_capacity(),
                vehicle.getKm_consumption(),
                vehicle.getVehicle_type(),
                vehicle.getIdentifier(),
                vehicle.getAverage_speed(),
                vehicle.getDriver_identifier());
        this.motors = motors;
        this.running_time = running_time;
    }

    public int getMotors() {
        return motors;
    }

    public int getRunning_time() {
        return running_time;
    }

}
