package es.pagoru.vehiclecontroller.persons;

import es.pagoru.vehiclecontroller.VehicleType;

import java.util.Date;

/**
 * Created by pablo on 3/2/17.
 */
public class Person {

    private String nif;
    private String name;
    private Date birthday;
    private VehicleType vehicle_specialty;
    private boolean assigned;

    public Person() {
        setAssigned(false);
    }

    public Person(String nif,
                  String name,
                  Date birthday,
                  VehicleType vehicle_specialty,
                  boolean assigned) {
        this.nif = nif;
        this.name = name;
        this.birthday = birthday;
        this.vehicle_specialty = vehicle_specialty;
        this.assigned = assigned;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setVehicle_specialty(VehicleType vehicle_specialty) {
        this.vehicle_specialty = vehicle_specialty;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public VehicleType getVehicle_specialty() {
        return vehicle_specialty;
    }

    public boolean isAssigned() {
        return assigned;
    }
}
