package main.java.parking;

import java.util.Date;

public class Ticket {
    private VehicleType type;
    private String plateNumber;
    private Date entryTime;
    private Date exitTime;
    private double price;
    private String ticketId;
    // private long duration;

    public Ticket(VehicleType type, String plateNumber) {
        this.type = type;
        this.plateNumber = plateNumber;
        this.entryTime = new Date();
        this.ticketId = generateTicketId();
    }

    private String generateTicketId() {
        String ticketId = "";
        for (int i = 0; i < 8; i++) {
            int randomNum = (int) (Math.random() * 10);
            ticketId += randomNum;
        }
        return ticketId;
    }

    public VehicleType getVehicleType() {
        return type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTicketId() {
        return ticketId;
    }

    public long calcDuration() {
        return (exitTime.getTime() - entryTime.getTime()) / (60 * 60 * 1000);
    }
}
