package es.pagoru.vehiclecontroller.vehicles.builders;

import es.pagoru.vehiclecontroller.vehicles.MaritimeVehicle;
import es.pagoru.vehiclecontroller.vehicles.Vehicle;

import java.util.Date;

/**
 * Created by pablo on 3/2/17.
 */
public class MaritimeVehicleBuilder extends VehicleBuilder {

    private int length;
    private int hose;
    private int flotation_year;
    private Date building_date;

    public MaritimeVehicleBuilder() { }

    public MaritimeVehicleBuilder(Vehicle vehicle){
        vehicle_type(vehicle.getVehicle_type());
        identifier(vehicle.getIdentifier());

        min_consumption(vehicle.getMin_consumption());
        current_charge(vehicle.getCurrent_charge());
        max_capacity(vehicle.getMax_capacity());

        km_consumption(vehicle.getKm_consumption());
        average_speed(vehicle.getAverage_speed());
        driver_identifier(vehicle.getDriver_identifier());
    }

    public MaritimeVehicleBuilder length(int length) {
        this.length = length;
        return this;
    }

    public MaritimeVehicleBuilder hose(int hose) {
        this.hose = hose;
        return this;
    }

    public MaritimeVehicleBuilder flotation_year(int flotation_year) {
        this.flotation_year = flotation_year;
        return this;
    }

    public MaritimeVehicleBuilder building_date(Date building_date) {
        this.building_date = building_date;
        return this;
    }

    public MaritimeVehicle buildMaritimeVehicle() {
        return new MaritimeVehicle(
                buildVehicle(),
                length,
                hose,
                flotation_year,
                building_date
        );
    }
}
