package es.pagoru.vehiclecontroller.vehicles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablo on 3/2/17.
 */
public enum VehicleController {

    INSTANCE;

    private List<Vehicle> vehicle_list = new ArrayList<>();
    
    public void addVehicle(Vehicle vehicle){
        if(vehicle != null)
        vehicle_list.add(vehicle);
    }
    
    public List<Vehicle> getVehicle_list(){
        return vehicle_list;
    }

}
