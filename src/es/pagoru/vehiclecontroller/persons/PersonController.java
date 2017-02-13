package es.pagoru.vehiclecontroller.persons;

import es.pagoru.vehiclecontroller.VehicleType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by pablo on 3/2/17.
 */
public enum PersonController {

    INSTANCE;

    private List<Person> person_list = new ArrayList<>();

    public void load(){
        try(Stream<Path> paths = Files.walk(Paths.get("src/data/"))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    person_list.add(getPerson(filePath));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<Person> getPerson_list(){
        return person_list;
    }
    
    private Person getPerson(Path path){
        
        Person person = new Person();

        try {
            String content = new String(Files.readAllBytes(path));

            Arrays.asList(content.split("\n")).forEach(line -> {
                String[] parts = line.split("=");
                
                switch (parts[0]){
                    case "NIF":
                        person.setNif(parts[1]);
                        break;
                    case "NOM":
                        person.setName(parts[1]);
                        break;
                    case "CUMPLEANYS":
                        try{
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            person.setBirthday(formatter.parse(parts[1]));
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        break;
                    case "ESPECIALITAT":
                        person.setVehicle_specialty(VehicleType.valueOf(parts[1]));
                        break;
                }
            });
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return person;
    }
    
}
