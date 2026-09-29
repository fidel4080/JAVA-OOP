import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LearnerDetailsGUI extends JFrame {
    private JTextField nameField, idField, courseField;
    private JTextArea displayArea;

    public LearnerDetailsGUI() {
        // Set up frame
        setTitle("Learner Details Form");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create components
        JLabel nameLabel = new JLabel("Learner Name:");
        nameField = new JTextField(20);

        JLabel idLabel = new JLabel("Learner ID:");
        idField = new JTextField(20);

        JLabel courseLabel = new JLabel("Course:");
        courseField = new JTextField(20);

        JButton submitButton = new JButton("Display Details");

        displayArea = new JTextArea(8, 25);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add action listener to button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String id = idField.getText();
                String course = courseField.getText();

                // Display info in text area
                displayArea.setText("--- Learner Information ---\n");
                displayArea.append("Name: " + name + "\n");
                displayArea.append("ID: " + id + "\n");
                displayArea.append("Course: " + course + "\n");
            }
        });

        // Add components to frame
        add(nameLabel);
        add(nameField);
        add(idLabel);
        add(idField);
        add(courseLabel);
        add(courseField);
        add(submitButton);
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LearnerDetailsGUI().setVisible(true);
            }
        });
    }
}