import javax.swing.*;

class ComputeArea{
    public static void main(String arg[]){

        String R = JOptionPane.showInputDialog("Enter the radius");
        int radius = Integer.parseInt(R);
        double PI = 3.14;
        double Area = PI * radius * radius;

        JOptionPane.showMessageDialog(null, "The Area is: " +Area );

    }
}