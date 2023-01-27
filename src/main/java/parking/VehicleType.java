package main.java.parking;

public enum VehicleType {
    CAR, MOTORCYCLE;

    public String toString() {
        switch (this) {
            case CAR:
                return "CAR";
            case MOTORCYCLE:
                return "MOTORCYLE";
        }
        return "ERROR";
    }
}