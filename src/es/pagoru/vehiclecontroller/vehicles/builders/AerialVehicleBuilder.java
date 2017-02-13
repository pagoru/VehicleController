package es.pagoru.vehiclecontroller.vehicles.builders;

import es.pagoru.vehiclecontroller.vehicles.AerialVehicle;
import es.pagoru.vehiclecontroller.vehicles.Vehicle;

/**
 * Created by pablo on 3/2/17.
 */
public class AerialVehicleBuilder extends VehicleBuilder {

    private int motors;
    private int running_time;

    public AerialVehicleBuilder(Vehicle vehicle){
        vehicle_type(vehicle.getVehicle_type());
        identifier(vehicle.getIdentifier());

        min_consumption(vehicle.getMin_consumption());
        current_charge(vehicle.getCurrent_charge());
        max_capacity(vehicle.getMax_capacity());

        km_consumption(vehicle.getKm_consumption());
        average_speed(vehicle.getAverage_speed());
        driver_identifier(vehicle.getDriver_identifier());
    }

    public AerialVehicleBuilder motors(int motors) {
        this.motors = motors;
        return this;
    }

    public AerialVehicleBuilder running_time(int running_time) {
        this.running_time = running_time;
        return this;
    }

    public AerialVehicle buildAerialVehicle() {
        return new AerialVehicle(
                buildVehicle(),
                motors,
                running_time
        );
    }
}
