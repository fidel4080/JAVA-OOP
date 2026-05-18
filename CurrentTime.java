import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CurrentTime {
    
    void displayTime(){

        JFrame frame = new JFrame("Current Time");
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JPanel timePanel = new JPanel();
        timePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        timePanel.setLayout(new BorderLayout());

        JLabel textLabel = new JLabel("Click the button below to show current Time");

        JTextField timeField = new JTextField();

        JButton getTimeBtn = new JButton("Show Time");
        getTimeBtn.setFont(new Font("Arial", Font.PLAIN, 18));

        timePanel.add(textLabel, BorderLayout.NORTH);
        timePanel.add(getTimeBtn, BorderLayout.SOUTH);
        timePanel.add(timeField, BorderLayout.CENTER);

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        getTimeBtn.addActionListener(e -> {
            LocalTime current = LocalTime.now();
            textLabel.setVisible(false);
            timeField.setText("The current time is: "+current.format(myFormat));

        });

        frame.add(timePanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CurrentTime().displayTime();
    }
}
