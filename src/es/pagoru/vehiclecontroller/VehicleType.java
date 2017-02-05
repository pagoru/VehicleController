package es.pagoru.vehiclecontroller;

/**
 * Created by pablo on 3/2/17.
 */
public enum VehicleType {

    T("terrestre"), //Land
    A("aeri"), //Aerial
    M("maritim"); //Maritime
    
    private String text;
    
    VehicleType(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
