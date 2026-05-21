
import javax.swing.JOptionPane;

public class PrimeNumberQn6{
    int number;

    PrimeNumberQn6(int n){
        number = n;
    }

    Boolean checkPrime(){
        boolean isPrime = true;

        for(int i = 2; i <= (Math.sqrt(number)); i++){
            if(number % i == 0){
                isPrime = false;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
        
        String N = JOptionPane.showInputDialog("Enter a number:");
        int num = Integer.parseInt(N);

        PrimeNumberQn6 userNumber = new PrimeNumberQn6(num);

        if(userNumber.checkPrime()){
            JOptionPane.showMessageDialog(
                null,
                num + " is a Prime number"
            );
        }

        else{
            JOptionPane.showMessageDialog(
                null,
                num + " is not a Prime number"
            );
        }
    }
}