import java.time.LocalTime;
import javax.swing.*;

public class BillingSystemFn {
    public static void main(String[] args) {

        //variable declaration
        double NormalCharge;
        double VAT = 0.16;
        double TotalBillAmt;
        double NetworkCharge = 5.00;
        double OtherNetworkCharge = 0;
        double VATCharge = 0.00;
        
        //Catch start and stop time
        LocalTime now = LocalTime.now();
        LocalTime start = LocalTime.of(6, 0);
        LocalTime end  = LocalTime.of(18,0);

        //User input for call duration
        String min = JOptionPane.showInputDialog("Enter the minutes of the call duration:\n");
        int callDuration = Integer.parseInt(min);

        //User input for network used to make the call 
        String Network = JOptionPane.showInputDialog("Making this call to your own network? \nEnter yes or no");

        if(Network.equalsIgnoreCase("no")){
            OtherNetworkCharge += NetworkCharge;

        }

        //To check if it is 6am to 6pm
        if(now.isAfter(start) && now.isBefore(end)){
            NormalCharge = callDuration * 4.00;
            
        }

        //To check if it is 6pm to 6am
        else{
            NormalCharge = callDuration * 3.00;

        }

        if(callDuration >= 2){
            VATCharge = VAT * NormalCharge;

        }

        TotalBillAmt = NormalCharge + VATCharge + OtherNetworkCharge;

        JOptionPane.showMessageDialog(null,"Your total bill amount is sh. " +TotalBillAmt);

    }
}
