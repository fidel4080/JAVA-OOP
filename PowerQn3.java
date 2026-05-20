//Get power without using java inbuilt method
import javax.swing.JOptionPane;

public class PowerQn3 {
    
    int num1, num2;

    //construtor
    PowerQn3(int n1, int n2) {
        num1 = n1;
        num2 = n2;
    }

    //method to get power
    double getPower(){
        double result = 1;

        //if a number is raised to power 0
        if(num2 == 0){
            result = 1;
        }
        
        //positive powers
        else if(num2 >= 1){

            for(int i = 1; i <= num2; i++){
                result *= num1;
            }
        }

        //negative powers
        else if(num2 < 0){

            double total = 1;

            for(int i = -1; i >= num2; i--){
                total *= num1;
            }

            result = 1 / total;
        }

        return result;
    }

    public static void main(String[] args) {

        //inputs
        String N1 = JOptionPane.showInputDialog("Enter the base number:\n");
        String N2 = JOptionPane.showInputDialog("Enter the exponent:\n");
        int number1 = Integer.parseInt(N1);
        int number2 = Integer.parseInt(N2);

        //class object
        PowerQn3 numbers = new PowerQn3(number1, number2);

        //output
        JOptionPane.showMessageDialog(
            null,
            number1 + " Raised to power "+ number2 + " is "+ numbers.getPower()
            );
    }
}
