package es.pagoru.vehiclecontroller.vehicles.builders;

import es.pagoru.vehiclecontroller.vehicles.AerialVehicle;
import es.pagoru.vehiclecontroller.vehicles.Vehicle;

/**
 * Created by pablo on 3/2/17.
 */
public class AerialVehicleBuilder extends VehicleBuilder {

    private int motors;
    private int running_time;

    public AerialVehicleBuilder() { }

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
