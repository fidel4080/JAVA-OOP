import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
class Conditions {
    
    static String name;
    static int temperature, pressure;

    //constructor
    Conditions (String n, int t, int p){
        name = n;
        temperature = t;
        pressure = p;
    }

    //main logic
    void medication(){
        if(temperature > 38 && pressure > 140){
            JOptionPane.showMessageDialog(null, name+" Should be admitted immediately");
        }

        else if(pressure < 140){
            JOptionPane.showMessageDialog(null, name+" Should be given appropriate medication");
        }

        else if(temperature < 38 && pressure > 140){
            JOptionPane.showMessageDialog(null, name+" Should be sent to the lab for lab tests to be done");
        }

    }

}

public class Hospital{
    public static void main(String [] args){
        JFrame frame = new JFrame ("Maisha Hospital");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder( new EmptyBorder(20,20,20,20));
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));
        frame.add(mainPanel);

        JLabel nameLabel = new JLabel("Patient Name:");
        JLabel tempLabel = new JLabel("Temperature:");
        JLabel pressureLabel = new JLabel("Blood Pressure:");

        JTextField nameField = new JTextField();
        JTextField tempField = new JTextField();
        JTextField pressureField = new JTextField();

        JButton checkButton = new JButton("Check Condition");

        //add all components
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(tempLabel);
        mainPanel.add(tempField);
        mainPanel.add(pressureLabel);
        mainPanel.add(pressureField);
        mainPanel.add(new JLabel());
        mainPanel.add(checkButton);

        frame.add(mainPanel);

        checkButton.addActionListener(e -> {

            //check if name field is empty
            if(nameField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,
                    "Patient Name should be entered!"
                );
                return;
            }
            try {
                
                String name = nameField.getText();
                int temperature = Integer.parseInt(tempField.getText());
                int pressure = Integer.parseInt(pressureField.getText());

                //new object
                Conditions patient = new Conditions(name, temperature, pressure);
                patient.medication();

                //catch error if a number is not entered
            } catch (NumberFormatException ex){
                
                JOptionPane.showMessageDialog(frame,
                    "Enter valid Numbers!"
                );
            }
        });

        frame.setVisible(true);
        
    }
}
