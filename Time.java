import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.*;

public class Time {

    void displayTime(){

        JFrame frame = new JFrame("Clock");
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null); // JFrame to appear at the center 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel timeLabel = new JLabel("Click the button to show current Time");
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER); //center alignment
        

        JButton getTimeBtn = new JButton("Show Time");
        getTimeBtn.setFont(new Font("Arial", Font.PLAIN, 18));

        frame.add(getTimeBtn, BorderLayout.SOUTH);
        frame.add(timeLabel, BorderLayout.CENTER);

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        
        //update time every 1000ms or 1second
        Timer timer = new Timer(1000,e -> {
            LocalTime currentTime = LocalTime.now();

            timeLabel.setText(currentTime.format(myFormat));
        });

        //start timer when button is clicked
        getTimeBtn.addActionListener(e -> {
            timeLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
            timeLabel.setText("Loading...");
            timer.start();
            getTimeBtn.setVisible(false);
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
        Time now = new Time();
        now.displayTime();
    }
}
    


