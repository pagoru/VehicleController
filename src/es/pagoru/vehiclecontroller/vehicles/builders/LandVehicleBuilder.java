package es.pagoru.vehiclecontroller.vehicles.builders;

import es.pagoru.vehiclecontroller.vehicles.AerialVehicle;
import es.pagoru.vehiclecontroller.vehicles.LandVehicle;

/**
 * Created by pablo on 3/2/17.
 */
public class LandVehicleBuilder extends VehicleBuilder {

    private int horse_power;
    private int failures;
    private int price_failures;

    public LandVehicleBuilder() { }

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
