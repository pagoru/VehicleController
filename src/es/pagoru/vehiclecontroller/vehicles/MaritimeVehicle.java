package es.pagoru.vehiclecontroller.vehicles;

import es.pagoru.vehiclecontroller.VehicleType;

import java.util.Date;

/**
 * Created by pablo on 3/2/17.
 */
public class MaritimeVehicle extends Vehicle {

    private int length;
    private int hose;
    private int flotation_year;
    private Date building_date;

    public void setLength(int length) {
        this.length = length;
    }
    public void setHose(int hose) {
        this.hose = hose;
    }
    public void setFlotation_year(int flotation_year) {
        this.flotation_year = flotation_year;
    }
    public void setBuilding_date(Date building_date) {
        this.building_date = building_date;
    }

    @Override
    public double getConsumption(){
        /*
        Consum =Consum  Minim  +  (Carrega  Actual  /    Capacitat  Maxima)*Consum  Per  Km)
        + (  Eslora  +  Manega  + AnyFlotacio) - (Dia Data Drassanes + Mes Data Drassanes + Any Data Drassanes);
         */
        return getMin_consumption()
                + ((getCurrent_charge() / getMax_capacity())
                * getKm_consumption())
                + (getLength() + getHose() + getFlotation_year())
                - (getBuilding_date().getDay() + getBuilding_date().getMonth() + getBuilding_date().getYear());
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
