package es.pagoru.vehiclecontroller.vehicles;

import es.pagoru.vehiclecontroller.VehicleType;

/**
 * Created by pablo on 3/2/17.
 */
public abstract class Vehicle {

    public abstract void setVehicle_type(VehicleType vehicle_type);
    public abstract void setIdentifier(String identifier);
    public abstract void setMin_consumption(double min_consumption);
    public abstract void setCurrent_charge(double current_charge);
    public abstract void setMax_capacity(double max_capacity);
    public abstract void setKm_consumption(double km_consumption);
    public abstract void setAverage_speed(double average_speed);
    public abstract void setDriver_identifier(String driver_identifier);

    public abstract double getConsumption();

    public abstract double getMin_consumption();
    public abstract double getCurrent_charge();
    public abstract double getMax_capacity();
    public abstract double getKm_consumption();
    public abstract VehicleType getVehicle_type();
    public abstract String getIdentifier();
    public abstract double getAverage_speed();
    public abstract String getDriver_identifier();
}