import javax.swing.*;
public class ReversedQn4 {
    
    int number;

    ReversedQn4(int n){
        number = n;
    }

    int reverseNumber(){

        int reversed = 0;

        while(number >= 10){
            int remainder = number % 10;
            reversed = (reversed * 10) + remainder;

            number  = number / 10;
        }

        reversed = (reversed * 10) + number;

        return reversed;
    }

    public static void main(String[] args) {
        
        String N = JOptionPane.showInputDialog("Enter a number");
        int num = Integer.parseInt(N);

        ReversedQn4 userNumber = new ReversedQn4(num);
        int reversedNumber = userNumber.reverseNumber();

        JOptionPane.showMessageDialog(
            null,
            "The reversed number is: " +reversedNumber
        );
    }

}
