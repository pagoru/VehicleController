package es.pagoru.vehiclecontroller.vehicles;

import es.pagoru.vehiclecontroller.VehicleType;

/**
 * Created by pablo on 3/2/17.
 */
public class AerialVehicle extends Vehicle {

    private VehicleType vehicle_type;
    private String identifier;
    private double min_consumption;
    private double current_charge;
    private double max_capacity;
    private double km_consumption;
    private double average_speed;
    private String driver_identifier;

    private int motors;
    private int running_time;

    @Override
    public double getConsumption(){
        /*
        Consum  =  Consum  Minim  +  (Carrega  Actual  /  Capacitat  Maxima)  *  Consum  Per  Km)
        +  (Num  Motors  *  Temps Funcionament)
         */
        return getMin_consumption()
                + ((getCurrent_charge() / getMax_capacity())
                * getKm_consumption())
                + (getMotors() * getRunning_time());
    }

    public int getMotors() {
        return motors;
    }
    public int getRunning_time() {
        return running_time;
    }

    public void setMotors(int motors) {
        this.motors = motors;
    }
    public void setRunning_time(int running_time) {
        this.running_time = running_time;
    }


    @Override
    public void setVehicle_type(VehicleType vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void setMin_consumption(double min_consumption) {
        this.min_consumption = min_consumption;
    }

    @Override
    public void setCurrent_charge(double current_charge) {
        this.current_charge = current_charge;
    }

    @Override
    public void setMax_capacity(double max_capacity) {
        this.max_capacity = max_capacity;
    }

    @Override
    public void setKm_consumption(double km_consumption) {
        this.km_consumption = km_consumption;
    }

    @Override
    public void setAverage_speed(double average_speed) {
        this.average_speed = average_speed;
    }

    @Override
    public void setDriver_identifier(String driver_identifier) {
        this.driver_identifier = driver_identifier;
    }

    @Override
    public double getMin_consumption() {
        return min_consumption;
    }

    @Override
    public double getCurrent_charge() {
        return current_charge;
    }

    @Override
    public double getMax_capacity() {
        return max_capacity;
    }

    @Override
    public double getKm_consumption() {
        return km_consumption;
    }

    @Override
    public VehicleType getVehicle_type() {
        return vehicle_type;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public double getAverage_speed() {
        return average_speed;
    }

    @Override
    public String getDriver_identifier() {
        return driver_identifier;
    }
}
