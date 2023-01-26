package main.java.parking;

import java.util.Date;

public class Ticket {
    private String vehicleType;
    private String plateNumber;
    private Date entryTime;
    private Date exitTime;
    private double price;
    private String ticketId;

    public Ticket(String vehicleType, String plateNumber) {
        this.vehicleType = vehicleType;
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

    public String getVehicleType() {
        return vehicleType;
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
}
