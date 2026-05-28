import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;


class BillingSys{

    //variable declaration
    double NormalCharge;
    double VAT = 0.16;
    double NetworkCharge = 5.00;
    double OtherNetworkCharge = 0.00;
    double VATCharge = 0.00;

    //constructor
    double callDuration;
    String NetworkChoice;

    BillingSys(double callDuration, String NetworkChoice){
        this.callDuration = callDuration;
        this.NetworkChoice = NetworkChoice;
    }


    //method
    double ChargeCustomer(){
        //Timeframes
        LocalTime now = LocalTime.now();
        LocalTime start = LocalTime.of(6, 0);
        LocalTime end  = LocalTime.of(18,0);

        if("No".equals(NetworkChoice)){
            OtherNetworkCharge += NetworkCharge;
        }

        if(now.isAfter(start) && now.isBefore(end)){
            NormalCharge = callDuration * 4.00;

        } else{
            NormalCharge = callDuration * 3.00;

        }
        if(callDuration >= 2){
                VATCharge = VAT * NormalCharge;

        }

        return NormalCharge + VATCharge + OtherNetworkCharge;

    }
}

public class BillingSystem{
    static LocalTime startTime;
    static LocalTime stopTime;
    public static void main(String[] arg){

        JFrame frame = new JFrame("Call Billing System");
        JButton startBtn = new JButton("Start Call");
        JButton stopBtn = new JButton("Stop Call");
        JLabel label = new JLabel("Other network?:");
        JComboBox<String> networkDropdown = new JComboBox<>();
        networkDropdown.addItem("Yes");
        networkDropdown.addItem("No");
        

        startBtn.setBounds(50, 60, 120, 40);
        stopBtn.setBounds(200, 60, 120, 40);
        label.setBounds(10, 10, 120, 40);
        networkDropdown.setBounds(100, 15, 80, 30);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        //Start button
        startBtn.addActionListener(e -> {
            startTime = LocalTime.now();
            startBtn.setEnabled(false);
            JOptionPane.showMessageDialog(frame, "Call started at: " + startTime.format(timeFormatter));
        });

        //Stop Button
        stopBtn.addActionListener(e -> {

            stopTime = LocalTime.now();

            if (startTime == null) {
                JOptionPane.showMessageDialog(frame, "Please start the call first");
                return;
            }

            String NetworkChoice = (String) networkDropdown.getSelectedItem();

            long seconds = Duration.between(startTime, stopTime).getSeconds();
            double callDuration = seconds / 60.0;

            BillingSys customer = new BillingSys(callDuration, NetworkChoice);
            double totalBill = customer.ChargeCustomer();

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
        frame.setBounds(500, 300, 400, 200);
        
    }

}