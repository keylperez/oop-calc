package main.java.parking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ParkingSystem extends JFrame {
    private JPanel entryFormPanel;
    private JPanel parkingDetailsPanel;
    private JPanel exitFormPanel;
    private JTextField vehicleTypeField;
    private JTextField plateNumberField;
    private JTextField exitTicketIdField;
    private JButton enterButton;
    private JButton exitButton;
    private JLabel parkingFullLabel;
    private JLabel ticketIdLabel;
    private JLabel vehicleTypeLabel;
    private JLabel plateNumberLabel;
    private JLabel exitTicketIdLabel;
    private JLabel exitTimeLabel;
    private JLabel priceLabel;
    private Ticket[] tickets;
    private int ticketCount;
    private int maxCapacity = 50;
    private CalculatePrice calculatePrice;
    private ParkingLot parkingLot;

    public ParkingSystem() {
        super("Mall Parking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        // Initialize fields and labels
        vehicleTypeField = new JTextField(10);
        plateNumberField = new JTextField(10);
        exitTicketIdField = new JTextField(10);
        enterButton = new JButton("Enter");
        exitButton = new JButton("Exit");
        parkingFullLabel = new JLabel("Parking is full");
        parkingFullLabel.setVisible(false);
        ticketIdLabel = new JLabel("Ticket ID:");
        vehicleTypeLabel = new JLabel("Vehicle Type:");
        plateNumberLabel = new JLabel("Plate Number:");
        exitTicketIdLabel = new JLabel("Ticket ID:");
        exitTimeLabel = new JLabel("Exit Time:");
        priceLabel = new JLabel("Price:");
        tickets = new Ticket[maxCapacity];
        ticketCount = 0;
        calculatePrice = new CalculatePrice();
        parkingLot = new ParkingLot();

        // Create entry form panel
        entryFormPanel = new JPanel();
        entryFormPanel.add(vehicleTypeLabel);
        entryFormPanel.add(vehicleTypeField);
        entryFormPanel.add(plateNumberLabel);
        entryFormPanel.add(plateNumberField);
        entryFormPanel.add(enterButton);

        // Create parking details panel
        parkingDetailsPanel = new JPanel();
        parkingDetailsPanel.add(parkingFullLabel);
        parkingDetailsPanel.add(ticketIdLabel);
        parkingDetailsPanel.add(vehicleTypeLabel);
        parkingDetailsPanel.add(plateNumberLabel);

        // Create exit form panel
        exitFormPanel = new JPanel();
        exitFormPanel.add(exitTicketIdLabel);
        exitFormPanel.add(exitTicketIdField);
        exitFormPanel.add(exitTimeLabel);
        exitFormPanel.add(exitButton);
        exitFormPanel.add(priceLabel);

        // Add panels to frame
        add(entryFormPanel, BorderLayout.NORTH);
        add(parkingDetailsPanel, BorderLayout.CENTER);
        add(exitFormPanel, BorderLayout.SOUTH);

        // Add action listeners to buttons
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vehicleType = vehicleTypeField.getText();
                String plateNumber = plateNumberField.getText();
                if (vehicleType.isEmpty() || plateNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields");
                } else {
                    if (ticketCount < maxCapacity) {
                        Ticket newTicket = new Ticket(vehicleType, plateNumber);
                        tickets[ticketCount] = newTicket;
                        ticketCount++;
                        parkingLot.addVehicle();
                        parkingFullLabel.setVisible(false);
                        ticketIdLabel.setText("Ticket ID: " + newTicket.getTicketId());
                        vehicleTypeLabel.setText("Vehicle Type: " + newTicket.getVehicleType());
                        plateNumberLabel.setText("Plate Number: " + newTicket.getPlateNumber());
                        vehicleTypeField.setText("");
                        plateNumberField.setText("");
                    } else {
                        parkingFullLabel.setVisible(true);
                    }
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ticketId = exitTicketIdField.getText();
                if (ticketId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a Ticket ID");
                } else {
                    boolean found = false;
                    for (int i = 0; i < ticketCount; i++) {
                        if (tickets[i] != null && tickets[i].getTicketId().equals(ticketId)) {
                            found = true;
                            Ticket currentTicket = tickets[i];
                            tickets[i] = null;
                            ticketCount--;
                            parkingLot.removeVehicle();
                            exitTimeLabel.setText("Exit Time: " + currentTicket.getExitTime());
                            priceLabel.setText("Price: $" + calculatePrice.calculate(currentTicket));
                            exitTicketIdField.setText("");
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Invalid Ticket ID");
                    }
                }
            }
        });
    }
}
