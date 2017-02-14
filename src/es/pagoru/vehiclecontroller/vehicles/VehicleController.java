package es.pagoru.vehiclecontroller.vehicles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablo on 3/2/17.
 */
public enum VehicleController {

    INSTANCE;

    private List<Vehicle> vehicle_list = new ArrayList<>();

    public List<Vehicle> getVehicle_list(){
        return vehicle_list;
    }
    
    public void addVehicle(Vehicle vehicle){
        if(vehicle != null)
        vehicle_list.add(vehicle);
    }

    public boolean isIdentifierInUse(String identifier){
        return vehicle_list.stream().filter(v -> v.getIdentifier()
                .equalsIgnoreCase(identifier)).count() != 0;
    }

    public Vehicle getVehicle(String identifier){
        return getVehicle_list().stream().filter(v
                -> v.getIdentifier().equalsIgnoreCase(identifier)).findFirst().orElse(null);
    }

    public void assignPersonToVehicle(String identifier, String person_identifier){
        getVehicle_list().stream().filter(v -> v.getIdentifier().equalsIgnoreCase(identifier))
                .forEach(v -> v.setDriver_identifier(person_identifier));
    }

}
