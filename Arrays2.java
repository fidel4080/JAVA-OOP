// Accept input for 10 random numbers and print them in ascending order
import java.util.Arrays;
import javax.swing.*;

public class Arrays2 {
    public static void main(String[] args){
        int i;
        int[] nums = new int[10];
        for(i = 0; i < nums.length; i++){
            String R = JOptionPane.showInputDialog("Enter number for input "+(i+1)+":");
            nums[i] = Integer.parseInt(R);
            
        }

        Arrays.sort(nums);

        System.out.println("Numbers in ascending order: ");

        for(int j = 0; j < nums.length; j++){
            System.out.println(nums[j]);
        }
    }
}
