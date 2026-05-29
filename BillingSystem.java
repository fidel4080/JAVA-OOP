import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

class PhoneBilling {

    // Variable declaration
    double normalCharge;
    double VAT = 0.16;
    double networkCharge = 5.00;
    double otherNetworkCharge = 0.00;
    double vatCharge = 0.00;

    // Constructor
    double callDuration;
    String networkChoice;

    PhoneBilling(double c, String n) {
        callDuration = c;
        networkChoice = n;
    }

    // Method
    double ChargeCustomer() {
        // Timeframes
        LocalTime now = LocalTime.now();
        LocalTime start = LocalTime.of(6, 0);
        LocalTime end = LocalTime.of(18, 0);

        if ("No".equals(networkChoice)) {
            otherNetworkCharge += networkCharge;
        }

        if (now.isAfter(start) && now.isBefore(end)) {
            normalCharge = callDuration * 4.00;
        } 

        else {
            normalCharge = callDuration * 3.00;
        }

        if (callDuration >= 2) {
            vatCharge = VAT * normalCharge;
        }

        return normalCharge + vatCharge + otherNetworkCharge;
    }
}

public class BillingSystem {
    static LocalTime startTime;
    static LocalTime stopTime;

    public static void main(String[] arg) {

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        JFrame frame = new JFrame("Call Billing System");
        JButton startBtn = new JButton("Start Call");
        JButton stopBtn = new JButton("Stop Call");
        JLabel label = new JLabel("Making this call to other network?:");
        JComboBox<String> networkDropdown = new JComboBox<>();
        networkDropdown.addItem("Yes");
        networkDropdown.addItem("No");

        label.setBounds(20, 20, 260, 30);
        networkDropdown.setBounds(270, 20, 80, 30);
        startBtn.setBounds(60, 80, 120, 40);
        stopBtn.setBounds(210, 80, 120, 40);

        // Start button
        startBtn.addActionListener(e -> {
            startTime = LocalTime.now();
            startBtn.setEnabled(false);
            JOptionPane.showMessageDialog(frame, "Call started at: " + startTime.format(timeFormatter));
        });

        // Stop button
        stopBtn.addActionListener(e -> {
            stopTime = LocalTime.now();

            if (startTime == null) {
                JOptionPane.showMessageDialog(frame, "Please start the call first");
                return;
            }

            String networkChoice = (String) networkDropdown.getSelectedItem();

            long seconds = Duration.between(startTime, stopTime).getSeconds();
            double callDuration = seconds / 60.00;

            PhoneBilling phone = new PhoneBilling(callDuration, networkChoice);
            double totalBill = phone.ChargeCustomer();

            JOptionPane.showMessageDialog(frame,
                    "Call ended at: " + stopTime.format(timeFormatter) +
                    "\nCall duration: " + String.format("%.2f", callDuration) + " minutes" +
                    "\nYour bill amount is Ksh. " + String.format("%.2f", totalBill));

            System.exit(0);
        });

        frame.add(startBtn);
        frame.add(stopBtn);
        frame.add(label);
        frame.add(networkDropdown);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 300, 420, 180);
    }
}