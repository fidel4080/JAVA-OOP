package inheritance;
import javax.swing.JOptionPane;

public class MainProg {
    public static void main(String[] args) {
        
        //list of available shapes
        System.out.println("Choose one shape from the list below to calculate its volume:");
        System.out.println("1. Sphere");
        System.out.println("2. Cone");
        System.out.println("3. Cylinder");

        String ch = JOptionPane.showInputDialog("Enter your choice");
        int choice = Integer.parseInt(ch);

        //if choice is Sphere
        if(choice == 1){
            String R = JOptionPane.showInputDialog("Enter the sphere radius");
            int r = Integer.parseInt(R);

            Sphere sp = new Sphere(r);
            System.out.println("The volume of the sphere is: "+sp.volume());
        }

        //if choice is Cone
        else if(choice == 2){
            String R = JOptionPane.showInputDialog("Enter the cone radius");
            int r = Integer.parseInt(R);
            String H = JOptionPane.showInputDialog("Enter the cone height");
            int h = Integer.parseInt(H);

            Cone cn = new Cone(r, h);
            System.out.println("The volume of the cone is: "+cn.volume());
        }

        //if choice is cylinder
        else if(choice == 3){
            String R = JOptionPane.showInputDialog("Enter the cylinder radius");
            int r = Integer.parseInt(R);
            String H = JOptionPane.showInputDialog("Enter the cylinder height");
            int h = Integer.parseInt(H);

            Cylinder cyl = new Cylinder(r, h);
            System.out.println("The volume of the cylinder is: "+cyl.volume());
        }

        //invalid input
        else{
            System.out.println("ERROR IN INPUT");
        }
        
    }
}
