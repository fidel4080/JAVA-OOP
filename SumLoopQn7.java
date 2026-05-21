
import javax.swing.JOptionPane;

public class SumLoopQn7 {

    //variables
    int num1, num2;

    //method
    void performSum(){

        int sum;
        String choice;

        do { 

            String N1 = JOptionPane.showInputDialog("Enter the first number:");
            String N2 = JOptionPane.showInputDialog("Enter the first number:");
            num1 = Integer.parseInt(N1);
            num2 = Integer.parseInt(N2);

            sum = num1 + num2;
            JOptionPane.showMessageDialog(
                null,
                "The sum is: "+ sum
            );

            choice = JOptionPane.showInputDialog("Do you wish to continue?\n(yes/no)");
            
        } while (choice.equalsIgnoreCase("yes"));
    }

    public static void main(String[] args){

        SumLoopQn7 number = new SumLoopQn7();
        number.performSum();
        
    }

}
