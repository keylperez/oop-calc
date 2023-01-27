package main.java.parking;

public class Vehicle {

    private final VehicleType type;
    private final String plateNumber;

    public Vehicle(VehicleType type, String plateNumber) {
        this.type = type;
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public VehicleType getType() {
        return type;
    }

}
