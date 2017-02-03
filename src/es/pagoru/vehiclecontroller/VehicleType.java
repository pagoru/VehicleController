package es.pagoru.vehiclecontroller;

/**
 * Created by pablo on 3/2/17.
 */
public enum VehicleType {

    LAND('T'),
    AERIAL('A'),
    MARITIME('M');

    private char c;

    VehicleType(char c) {
        this.c = c;
    }

    public char getCharacter() {
        return c;
    }
}
