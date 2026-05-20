
import javax.swing.JOptionPane;

public class FactorialQn2 {
    int number;

    FactorialQn2(int n){
        number = n;
    }

    int getFactorial(){
        int factorial = 1;

        while(number != 0){

            factorial *= number;
            number--;
        }

        return factorial;

    }

    public static void main(String[] args) {
        
        String N = JOptionPane.showInputDialog("Enter an number to get its Factorial: \n");
        int num = Integer.parseInt(N);

        FactorialQn2 userNumber = new FactorialQn2(num);

        JOptionPane.showMessageDialog(
            null,
            "The factorial of " +num+ " is " +userNumber.getFactorial());

    }
}
