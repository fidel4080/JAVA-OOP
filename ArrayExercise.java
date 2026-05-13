// import java.util.Arrays;
import javax.swing.JOptionPane;

class Array{
    int[] myArray = new int[10];
    
    

    void compute(){
        int i;

        //Sum
        for(i = 0; i < myArray.length; i++){
            String A = JOptionPane.showInputDialog("Enter Array element " +(i + 1));
            myArray[i] = Integer.parseInt(A);
        }

        int sum = 0;
        for(int num : myArray){
            sum += num;
        }

        //Average
        double avg =(double)sum / myArray.length;
            
        JOptionPane.showMessageDialog(null, "The sum of the array is: " + sum
          + "\nThe average of the array is: " + avg
        );

        //If array contains specific value
        String B = JOptionPane.showInputDialog("Enter a value to check if it is available in the array");
        int searchValue = Integer.parseInt(B);

        for(int num : myArray){
            if(num == searchValue){
                JOptionPane.showMessageDialog(null,"The number "+searchValue+" was found in the array");
            }
        }

        //index of an array element
        int index;
        for(int j = 0 ; j < myArray.length; j++){
            if(myArray[j] == searchValue){
                index = j;
                JOptionPane.showMessageDialog(null,"The number "+searchValue+" is in index [" +index+ "] of the array");
            }
        }

        //reversed

        String reversed = "";
        for(int k = myArray.length - 1; k >= 0; k--){
            reversed += myArray[k] + " ";
            
        }
        System.out.print(reversed);
        


    }
    
}

public class ArrayExercise {
    public static void main(String[] args) {
        Array array = new Array();
        array.compute();
    }
}
