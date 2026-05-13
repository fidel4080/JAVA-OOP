import javax.swing.*;
class Subjects {
    public static void main(String[] args) {
        
        String faculty = JOptionPane.showInputDialog("Enter either; \nScience or Arts:");
        String subject = "";
        if(faculty.equals("Science") || faculty.equals("science")){
            subject = JOptionPane.showInputDialog("Enter a subject either; \nPhysics or Chemistry");
        }
        else if(faculty.equals("Arts") || faculty.equals("arts")){
            subject = JOptionPane.showInputDialog("Enter a subject either; \nHistory or CRE:");
        }

        JOptionPane.showMessageDialog(null, "You selected " +subject+ " under faculty of " +faculty);
    }
}
