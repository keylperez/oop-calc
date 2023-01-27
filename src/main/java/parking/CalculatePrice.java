package main.java.parking;

public class CalculatePrice {

    public static double calculatePrice(Ticket ticket) {
        double price = 0;
        // Date entryTime = ticket.getEntryTime();
        // Date exitTime = ticket.getExitTime();
        // long duration = exitTime.getTime() - entryTime.getTime();
        // long hours = duration / (60 * 60 * 1000);

        if (ticket.getVehicleType() == VehicleType.CAR) {
            price = 1.0;
            if (ticket.calcDuration() > 3) {
                price += (ticket.calcDuration() - 3) * 0.5;
            }
        } else if (ticket.getVehicleType() == VehicleType.MOTORCYCLE) {
            price = 1.0;
        }
        return price;
    }
}