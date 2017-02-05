package es.pagoru.vehiclecontroller;

import es.pagoru.vehiclecontroller.vehicles.LandVehicle;
import es.pagoru.vehiclecontroller.vehicles.MaritimeVehicle;
import es.pagoru.vehiclecontroller.vehicles.Vehicle;
import es.pagoru.vehiclecontroller.vehicles.builders.LandVehicleBuilder;
import es.pagoru.vehiclecontroller.vehicles.builders.MaritimeVehicleBuilder;
import es.pagoru.vehiclecontroller.vehicles.builders.VehicleBuilder;

import java.util.Scanner;

/**
 * Created by pablo on 3/2/17.
 */
public class Controller {

    private static VehicleController vehicleController = VehicleController.INSTANCE;
    
    private Scanner scanner;

    private boolean main_loop;

    public Controller() {
        this.scanner = new Scanner(System.in);
        this.main_loop = true;

        mainLoop();
    }

    private void printPageBreak(){
        for (int s = 0; s < 20; s++) {
            System.out.println("");
        }
    }
    
    private void wait(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        } catch (Exception e){
            
        }
    }
    
    private void mainLoop() {
        while(main_loop) {

            printPageBreak();
            
            System.out.println("Escull una opció de les seguents:");
            System.out.println("T - Afegir vehicle terrestre.");
            System.out.println("M - Afegir vehicle maritirm.");
            System.out.println("A - Afegir vehicle aeri.");
            System.out.println("C - Capturar dades del personal.");
            System.out.println("P - Assignar personal disponible als vehicles.");
            System.out.println("R - Mostrar les dades dels vehicles.");
            System.out.println("F - Finalitzar.");

            try{
                processOptions(scanner.next());
            } catch (Exception e){
                e.printStackTrace();
                System.err.println("Hi ha hagut algun error :(");
            }
        }
    }

    private boolean processOptions(String option) {
        
        switch (option) {
            case "T":
            case "t":                
                return option_T();
            case "M":
            case "m":
                return option_M();
            case "A":
            case "a":
                return option_A();
            case "C":
            case "c":
                return option_C();
            case "P":
            case "p":
                return option_P();
            case "R":
            case "r":
                return option_R();
            case "F":
            case "f":
                return option_F();
            default:
                option_default();
                return false;
        }
    }

    private Vehicle getVehicle(VehicleType vehicleType){
        VehicleBuilder vehicleBuilder = new VehicleBuilder();

        printPageBreak();

        vehicleBuilder.vehicle_type(vehicleType);

        try{
            System.out.println("Escriu l'identificador del vehicle:");
            vehicleBuilder.identifier(scanner.next());
        } catch (Exception e){
            System.err.println(e.getMessage());
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu el consum minim del vehicle:");
            vehicleBuilder.min_consumption(Double.parseDouble(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un decimal valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu la carrega actual del vehicle:");
            vehicleBuilder.current_charge(Double.parseDouble(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un decimal valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu la carrega maxima del vehicle:");
            vehicleBuilder.max_capacity(Double.parseDouble(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un decimal valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu la el consum per km del vehicle:");
            vehicleBuilder.km_consumption(Double.parseDouble(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un decimal valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu la velocitat mitja del vehicle:");
            vehicleBuilder.average_speed(Double.parseDouble(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un decimal valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu l'identificador del conductor del vehicle:");
            vehicleBuilder.driver_identifier(scanner.next());
        } catch (Exception e){
            System.err.println(e.getMessage());
            wait(3);
            return null;
        }

        return vehicleBuilder.buildVehicle();
    }
    
    private boolean addVehicle(Vehicle vehicle){
        if(vehicle == null){
            return false;
        }
        printPageBreak();
        System.out.println("S'ha afegit un vehicle " + vehicle.getVehicle_type().getText() + " correctament.");
        wait(3);
        vehicleController.addVehicle(vehicle);
        return false;
    }

    /***OPTION_R*************************************************************************************************/
    private boolean option_R(){

        return false;
    }
    /***OPTION_P*************************************************************************************************/
    private boolean option_P(){

        return false;
    }
    /***OPTION_C*************************************************************************************************/
    private boolean option_C(){

        return false;
    }
    /***OPTION_A*************************************************************************************************/
    private boolean option_A(){

        return false;
    }
    /***OPTION_M*************************************************************************************************/
    private boolean option_M(){
        return addVehicle(getMaritimeVehicle());
    }

    private MaritimeVehicle getMaritimeVehicle(){
        Vehicle vehicle = getVehicle(VehicleType.T);
        if(vehicle == null){
            return null;
        }

        MaritimeVehicleBuilder maritimeVehicleBuilder  = new MaritimeVehicleBuilder(vehicle);


        return maritimeVehicleBuilder.buildMaritimeVehicle();
    }


    /***OPTION_T*************************************************************************************************/
    private boolean option_T(){
        return addVehicle(getLandVehicle());
    }

    private LandVehicle getLandVehicle(){
        Vehicle vehicle = getVehicle(VehicleType.T);
        if(vehicle == null){
            return null;
        }
        
        LandVehicleBuilder landVehicleBuilder  = new LandVehicleBuilder(vehicle);

        try{
            System.out.println("Escriu els caballs del vehicle:");
            landVehicleBuilder.horse_power(Integer.parseInt(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un enter valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu el numero total de reparacions que ha tingut el vehicle:");
            landVehicleBuilder.failures(Integer.parseInt(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un enter valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu el preu total de les reparacions que ha tingut el vehicle:");
            landVehicleBuilder.price_failures(Integer.parseInt(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un enter valid.");
            wait(3);
            return null;
        }

        return landVehicleBuilder.buildLandVehicle();
    }
    
    /***OPTION_F*************************************************************************************************/
    private boolean option_F() {
        System.out.println("Bye bye, hasta otro ratito.");
        this.main_loop = false;
        
        return true;
    }

    /***OPTION_D*************************************************************************************************/
    private boolean option_default(){
        printPageBreak();
        System.out.println("Opció incorrecta.");
        wait(3);
        
        return false;
    }

}
