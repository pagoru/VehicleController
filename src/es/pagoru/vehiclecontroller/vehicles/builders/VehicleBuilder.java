package es.pagoru.vehiclecontroller.vehicles.builders;

import es.pagoru.vehiclecontroller.VehicleType;
import es.pagoru.vehiclecontroller.vehicles.Vehicle;

/**
 * Created by pablo on 3/2/17.
 */
public class VehicleBuilder {

    private VehicleType vehicle_type;
    private String identifier;
    
    private double min_consumption;
    private double current_charge;
    private double max_capacity;
    
    private double km_consumption;
    private double average_speed;
    
    private String driver_identifier;

    public VehicleBuilder () { }

    public VehicleBuilder min_consumption(double min_consumption) {
        this.min_consumption = min_consumption;
        return this;
    }

    public VehicleBuilder current_charge(double current_charge) {
        this.current_charge = current_charge;
        return this;
    }

    public VehicleBuilder max_capacity(double max_capacity) {
        this.max_capacity = max_capacity;
        return this;
    }

    public VehicleBuilder km_consumption(double km_consumption) {
        this.km_consumption = km_consumption;
        return this;
    }

    public VehicleBuilder vehicle_type(VehicleType vehicle_type) {
        this.vehicle_type = vehicle_type;
        return this;
    }

    public VehicleBuilder identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public VehicleBuilder average_speed(double average_speed) {
        this.average_speed = average_speed;
        return this;
    }

    public VehicleBuilder driver_identifier(String driver_identifier) {
        this.driver_identifier = driver_identifier;
        return this;
    }

    public Vehicle buildVehicle() {
        return new Vehicle(
                min_consumption,
                current_charge,
                max_capacity,
                km_consumption,
                vehicle_type,
                identifier,
                average_speed,
                driver_identifier
        );
    }
}
