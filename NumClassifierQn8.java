
import javax.swing.JOptionPane;

public class NumClassifierQn8 {
    int number;

    void classifyNumbers(){

        int positiveCounter = 0;
        int negativeCounter = 0;
        int zerosCounter = 0;
        String choice;

        do { 
            
            number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number:"));

            //positive counter
            if(number > 0){
                positiveCounter++;
            }

            //negative counter
            else if(number < 0){
                negativeCounter++;
            }

            //zero counter
            else if(number == 0){
                zerosCounter++;
            }

            choice = JOptionPane.showInputDialog("Do you want to enter another number?\n(y/n)");

        } while (choice.equalsIgnoreCase("y"));

        JOptionPane.showMessageDialog(
            null,
            "Positive numbers are "+positiveCounter+" in number\n"+
            "Negative numbers are "+negativeCounter+" in number\n"+
            "Zeros are "+zerosCounter+" in number"
        );
    }

    public static void main(String[] args) {

        NumClassifierQn8 number = new NumClassifierQn8();
        number.classifyNumbers();
    }
}
