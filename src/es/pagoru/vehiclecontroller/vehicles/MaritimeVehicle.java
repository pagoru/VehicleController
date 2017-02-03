package es.pagoru.vehiclecontroller.vehicles;

import java.util.Date;

/**
 * Created by pablo on 3/2/17.
 */
public class MaritimeVehicle extends Vehicle {

    private int length;
    private int hose;
    private int flotation_year;
    private Date building_date;

    public MaritimeVehicle(Vehicle vehicle,
                         int length,
                         int hose,
                         int flotation_year,
                         Date building_date) {

        super(vehicle.getMin_consumption(),
                vehicle.getCurrent_charge(),
                vehicle.getMax_capacity(),
                vehicle.getKm_consumption(),
                vehicle.getVehicle_type(),
                vehicle.getIdentifier(),
                vehicle.getAverage_speed(),
                vehicle.getDriver_identifier());
        this.length = length;
        this.hose = hose;
        this.flotation_year = flotation_year;
        this.building_date = building_date;
    }

    public int getLength() {
        return length;
    }

    public int getHose() {
        return hose;
    }

    public int getFlotation_year() {
        return flotation_year;
    }

    public Date getBuilding_date() {
        return building_date;
    }
}
