import java.time.Duration;
import java.time.LocalTime;
import javax.swing.*;


class BillingSystem{

    //variable declaration
    double NormalCharge;
    double VAT = 0.16;
    double NetworkCharge = 5.00;
    double OtherNetworkCharge = 0.00;
    double VATCharge = 0.00;

    //constructor
    int callDuration;
    String NetworkChoice;

    BillingSystem(int callDuration, String NetworkChoice){
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

public class BillingSys{
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

        
        //Start button
        startBtn.addActionListener(e -> {
            startTime = LocalTime.now();
            startBtn.setEnabled(false);
            JOptionPane.showMessageDialog(frame, "Call started at: " +startTime);
        });

        //Stop Button
        stopBtn.addActionListener(e -> {
            stopTime = LocalTime.now();

                if(startTime == null){
                    JOptionPane.showMessageDialog(frame, "Please start the call first");
                    return;
                }

                String NetworkChoice = (String) networkDropdown.getSelectedItem();
                System.out.println(NetworkChoice);

                long seconds = Duration.between(startTime, stopTime).getSeconds();
                int callDuration = (int)(seconds / 60);

                BillingSystem customer = new BillingSystem(callDuration, NetworkChoice);
                double totalBill = customer.ChargeCustomer();


                JOptionPane.showMessageDialog(frame, 
                    "Call ended at: " +stopTime+
                    "\nCall duration:" +callDuration+ " minutes \nYour bill amount is Ksh. " +totalBill);

                System.exit(0);
        });


        frame.add(startBtn);
        frame.add(stopBtn);
        frame.add(label);
        frame.add(networkDropdown);


        // frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 300, 400, 200);
        
    }

}