package es.pagoru.vehiclecontroller.vehicles;

/**
 * Created by pablo on 3/2/17.
 */
public class LandVehicle extends Vehicle {

    private int horse_power;
    private int failures;
    private int price_failures;

    public LandVehicle(Vehicle vehicle,
                         int horse_power,
                         int failures,
                         int price_failures) {

        super(vehicle.getMin_consumption(),
                vehicle.getCurrent_charge(),
                vehicle.getMax_capacity(),
                vehicle.getKm_consumption(),
                vehicle.getVehicle_type(),
                vehicle.getIdentifier(),
                vehicle.getAverage_speed(),
                vehicle.getDriver_identifier());

        this.horse_power = horse_power;
        this.failures = failures;
        this.price_failures = price_failures;
    }

    public int getHorse_power() {
        return horse_power;
    }

    public int getFailures() {
        return failures;
    }

    public int getPrice_failures() {
        return price_failures;
    }
}
