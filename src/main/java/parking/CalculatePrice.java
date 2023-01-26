package main.java.parking;

import java.util.Date;

public class CalculatePrice {

    public static double calculatePrice(Ticket ticket) {
        double price = 0;
        Date entryTime = ticket.getEntryTime();
        Date exitTime = ticket.getExitTime();
        long duration = exitTime.getTime() - entryTime.getTime();
        long hours = duration / (60 * 60 * 1000);

        if (ticket.getVehicleType().equals("car")) {
            price = 1.0;
            if (hours > 3) {
                price += (hours - 3) * 0.5;
            }
        } else if (ticket.getVehicleType().equals("motorcycle")) {
            price = 1.0;
        }
        return price;
    }
}
