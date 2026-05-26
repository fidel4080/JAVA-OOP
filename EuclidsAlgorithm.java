
import javax.swing.JOptionPane;

public class EuclidsAlgorithm{
    int num1, num2;


    //method
    void LcmAndGcd(){

        num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the first integer:"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the second integer:"));

        int GCD;
        int LCM;

        int maxNum = Math.max(num2, num1);
        int minNum = Math.min(num2, num1);


        int numerator = maxNum;
        int denominator = minNum;

        int remainder = numerator % denominator;

        while(remainder != 0){
            numerator = denominator;
            denominator = remainder;

            remainder = numerator % denominator;

        }

        GCD = denominator;
        LCM = (maxNum * minNum) / GCD;

        JOptionPane.showMessageDialog(
            null,
            "The GCD of " +num1+" and " +num2+ " is " + GCD);

        JOptionPane.showMessageDialog(
            null,
            "The LCM of " +num1+" and " +num2+ " is " + LCM);

    }

    public static void main(String[] args) {
        
        EuclidsAlgorithm numbers = new EuclidsAlgorithm();
        numbers.LcmAndGcd();
    }
}