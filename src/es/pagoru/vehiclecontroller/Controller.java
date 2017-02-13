package es.pagoru.vehiclecontroller;

import es.pagoru.vehiclecontroller.persons.PersonController;
import es.pagoru.vehiclecontroller.vehicles.*;
import es.pagoru.vehiclecontroller.vehicles.builders.*;
import es.pagoru.vehiclecontroller.vehicles.builders.AerialVehicleBuilder;

import java.sql.Date;
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

        PersonController.INSTANCE.load();
        
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

        try{
            System.out.println("Escriu l'eslora del vehicle:");
            maritimeVehicleBuilder.length(Integer.parseInt(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un enter valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu la manega del vehicle:");
            maritimeVehicleBuilder.hose(Integer.parseInt(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un enter valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu l'any de floatció del vehicle:");
            maritimeVehicleBuilder.flotation_year(Integer.parseInt(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un enter valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu la data de construcció del vehicle:");
            maritimeVehicleBuilder.building_date(Date.valueOf(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit una data valida yyyy-mm-dd.");
            wait(3);
            return null;
        }

        return maritimeVehicleBuilder.buildMaritimeVehicle();
    }

    /***OPTION_A*************************************************************************************************/
    private boolean option_A(){
        return addVehicle(getAerialVehicle());
    }

    private AerialVehicle getAerialVehicle(){
        Vehicle vehicle = getVehicle(VehicleType.T);
        if(vehicle == null){
            return null;
        }

        AerialVehicleBuilder aerialVehicleBuilder  = new AerialVehicleBuilder(vehicle);

        try{
            System.out.println("Escriu el nombre de motors que te el vehicle:");
            aerialVehicleBuilder.motors(Integer.parseInt(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un enter valid.");
            wait(3);
            return null;
        }

        try{
            System.out.println("Escriu el nombre de hores que porta funcionant el vehicle:");
            aerialVehicleBuilder.motors(Integer.parseInt(scanner.next()));
        } catch (Exception e){
            System.err.println("No s'ha introduit un enter valid.");
            wait(3);
            return null;
        }

        return aerialVehicleBuilder.buildAerialVehicle();
    }

    /***OPTION_C*************************************************************************************************/
    private boolean option_C(){
        PersonController.INSTANCE.getPerson_list().forEach(p -> {
            System.out.println("|-----------------------------------|");
            System.out.println("Nif -> " + p.getNif());
            System.out.println("Nom -> " + p.getName());
            System.out.println("Cumpleanys -> " + p.getBirthday());
            System.out.println("Especialitat -> " + p.getVehicle_specialty().getText());
            System.out.println("Esta asignat -> " + (p.isAssigned() ? "Si" : "No"));
        });
        System.out.println("|-----------------------------------|");
        wait(5);
        return false;
    }
    
    /***OPTION_P*************************************************************************************************/
    private boolean option_P(){

        return false;
    }
    
    /***OPTION_R*************************************************************************************************/
    private boolean option_R(){
        printPageBreak();
        if(VehicleController.INSTANCE.getVehicle_list().size() == 0)
            return false;
            
        VehicleController.INSTANCE.getVehicle_list().forEach(vehicle -> {
            System.out.println("|-----------------------------------|");
            System.out.println("Identificador -> " + vehicle.getIdentifier());
            System.out.println("Consum minim -> " + vehicle.getMin_consumption());
            System.out.println("Consum actual -> " + vehicle.getCurrent_charge());
            System.out.println("Maxima capacitat -> " + vehicle.getMax_capacity());
            System.out.println("Consum per km -> " + vehicle.getKm_consumption());
            System.out.println("Velocitat mitja -> " + vehicle.getAverage_speed());
            System.out.println("Identificador del conductor -> " + vehicle.getDriver_identifier());
            
            System.out.println("Tipus de vehicle -> " + vehicle.getVehicle_type().getText());
            System.out.println("          |-|-|-|-|-|");
            
            switch (vehicle.getVehicle_type()){
                case A:
                    AerialVehicle aerialVehicle = (AerialVehicle) vehicle;

                    System.out.println("Motors -> " + aerialVehicle.getMotors());
                    System.out.println("Temps en marcha -> " + aerialVehicle.getRunning_time());
                    break;
                case M:
                    MaritimeVehicle maritimeVehicle = (MaritimeVehicle) vehicle;

                    System.out.println("Eslora -> " + maritimeVehicle.getLength());
                    System.out.println("Manega -> " + maritimeVehicle.getHose());
                    System.out.println("Any de flotacio -> " + maritimeVehicle.getFlotation_year());
                    System.out.println("Data de fabricació -> " + maritimeVehicle.getBuilding_date());
                    break;
                case T:
                    LandVehicle landVehicle = (LandVehicle) vehicle;

                    System.out.println("Caballs -> " + landVehicle.getHorse_power());
                    System.out.println("Quantitat d'averies -> " + landVehicle.getFailures());
                    System.out.println("Preu de les reparacions -> " + landVehicle.getPrice_failures());
                    break;
            }
        });
        System.out.println("|-----------------------------------|");
        wait(5);
        
        return false;
    }

    /***OPTION_F*************************************************************************************************/
    private boolean option_F() {
        System.out.println("Bye bye, hasta otro ratito.");
        this.main_loop = false;
        
        return true;
    }

    /***OPTION_Default********************************************************************************************/
    private boolean option_default(){
        printPageBreak();
        System.out.println("Opció incorrecta.");
        wait(3);
        
        return false;
    }

}
