package es.pagoru.vehiclecontroller.vehicles.builders;

import es.pagoru.vehiclecontroller.vehicles.AerialVehicle;
import es.pagoru.vehiclecontroller.vehicles.MaritimeVehicle;

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

    public MaritimeVehicle buildAerialVehicle() {
        return new MaritimeVehicle(
                buildVehicle(),
                length,
                hose,
                flotation_year,
                building_date
        );
    }
}
