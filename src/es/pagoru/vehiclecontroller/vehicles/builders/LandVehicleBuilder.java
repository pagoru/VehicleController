package es.pagoru.vehiclecontroller.vehicles.builders;

import es.pagoru.vehiclecontroller.vehicles.LandVehicle;
import es.pagoru.vehiclecontroller.vehicles.Vehicle;

/**
 * Created by pablo on 3/2/17.
 */
public class LandVehicleBuilder extends VehicleBuilder {

    private int horse_power;
    private int failures;
    private int price_failures;

    public LandVehicleBuilder() { }
    
    public LandVehicleBuilder(Vehicle vehicle){
        vehicle_type(vehicle.getVehicle_type());
        identifier(vehicle.getIdentifier());
        
        min_consumption(vehicle.getMin_consumption());
        current_charge(vehicle.getCurrent_charge());
        max_capacity(vehicle.getMax_capacity());
        
        km_consumption(vehicle.getKm_consumption());
        average_speed(vehicle.getAverage_speed());
        driver_identifier(vehicle.getDriver_identifier());
    }

    public LandVehicleBuilder horse_power(int horse_power) {
        this.horse_power = horse_power;
        return this;
    }

    public LandVehicleBuilder failures(int failures) {
        this.failures = failures;
        return this;
    }

    public LandVehicleBuilder price_failures(int price_failures) {
        this.price_failures = price_failures;
        return this;
    }

    public LandVehicle buildLandVehicle() {
        return new LandVehicle(
                buildVehicle(),
                horse_power,
                failures,
                price_failures
        );
    }
}
