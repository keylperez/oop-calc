package main.java.parking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLot {

    private static final int MAX_SPACES = 50;
    private static List<Ticket> parkingSpaces = new ArrayList<>(MAX_SPACES);

    public static boolean isFull() {
        return parkingSpaces.size() == MAX_SPACES;
    }

    public static boolean isEmpty() {
        return parkingSpaces.isEmpty();
    }

    public static int availableSpaces() {
        return MAX_SPACES - parkingSpaces.size();
    }

    public static Ticket issueTicket(VehicleType type, String plate) {
        if (!isFull()) {
            Ticket ticket = new Ticket(type, plate);
            parkingSpaces.add(ticket);
            return ticket;
        } else {
            System.out.println("Parking is full, cannot issue ticket.");
            return null;
        }
    }

    public static double releaseTicket(String ticketId) {
        for (Ticket ticket : parkingSpaces) {
            if (ticket.getTicketId().equals(ticketId)) {
                ticket.setExitTime(new Date());
                parkingSpaces.remove(ticket);
                return CalculatePrice.calculatePrice(ticket);
            }
        }
        System.out.println("Invalid ticket ID, cannot release ticket.");
        return 0;
    }
}
