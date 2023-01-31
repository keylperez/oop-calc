package main.java.parking;

public enum VehicleType {
    CAR("CAR"),
    MOTORCYCLE("MOTORCYCLE");

    // public String toString() {
    // switch (this) {
    // case CAR:
    // return "CAR";
    // case MOTORCYCLE:
    // return "MOTORCYCLE";
    // }
    // return "ERROR";
    // }

    public final String label;

    private VehicleType(String label) {
        this.label = label;
    }
}