package es.pagoru.vehiclecontroller;

import java.util.Scanner;

/**
 * Created by pablo on 3/2/17.
 */
public class Controller {

    private Scanner scanner;

    private boolean main_loop;

    public Controller() {
        this.scanner = new Scanner(System.in);
        this.main_loop = true;

        mainLoop();
    }

    private void mainLoop() {
        while(main_loop) {
            System.out.println("Escull una opció de les seguents:");
            System.out.println("T - Afegir vehicle terrestre.");
            System.out.println("M - Afegir vehicle maritirm.");
            System.out.println("A - Afegir vehicle aeri.");
            System.out.println("C - Capturar dades del personal.");
            System.out.println("P - Assignar personal disponible als vehicles.");
            System.out.println("R - Mostrar les dades dels vehicles.");
            System.out.println("F - Finalitzar.");

            processOptions(scanner.next());
        }
    }

    private void processOptions(String option) {
        switch (option) {
            case "T":
            case "t":
                return;
            case "M":
            case "m":
                return;
            case "A":
            case "a":
                return;
            case "C":
            case "c":
                return;
            case "P":
            case "p":
                return;
            case "R":
            case "r":
                return;
            case "F":
            case "f":
                close();
                return;
            default:
        }
    }

    private void close() {
        System.out.println("Bye bye, hasta otro ratito.");
        this.main_loop = false;
    }

    private void addLandVehicle() {

    }

}
