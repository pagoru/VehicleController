package es.pagoru.vehiclecontroller.vehicles;

import es.pagoru.vehiclecontroller.VehicleType;

/**
 * Created by pablo on 3/2/17.
 */
public class Vehicle {

    private VehicleType vehicle_type;
    private String identifier;
    
    private double min_consumption;
    private double current_charge;
    private double max_capacity;
    
    private double km_consumption;
    private double average_speed;
    private String driver_identifier;

    public Vehicle(double min_consumption,
                   double current_charge,
                   double max_capacity,
                   double km_consumption,
                   VehicleType vehicle_type,
                   String identifier,
                   double average_speed,
                   String driver_identifier) {
        this.min_consumption = min_consumption;
        this.current_charge = current_charge;
        this.max_capacity = max_capacity;
        this.km_consumption = km_consumption;
        this.vehicle_type = vehicle_type;
        this.identifier = identifier;
        this.average_speed = average_speed;
        this.driver_identifier = driver_identifier;
    }

    public double getMin_consumption() {
        return min_consumption;
    }

    public double getCurrent_charge() {
        return current_charge;
    }

    public double getMax_capacity() {
        return max_capacity;
    }

    public double getKm_consumption() {
        return km_consumption;
    }

    public VehicleType getVehicle_type() {
        return vehicle_type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public double getAverage_speed() {
        return average_speed;
    }

    public String getDriver_identifier() {
        return driver_identifier;
    }

}