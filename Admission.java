// SIMPLE SYSTEM FOR ADMITTING STUDENTS IN A SCHOOL

import javax.swing.*;
import java.awt.*;

class StudentDetails {

    String fullName;
    String admNumber;
    String phoneNumber;
    int age;
    String course;
    String gender;
    String accommodation;
    String address;

    StudentDetails(String fullName, String admNumber, String phoneNumber, int age, String course, String gender,
            String accommodation, String address) {

        this.fullName = fullName;
        this.admNumber = admNumber;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.course = course;
        this.gender = gender;
        this.accommodation = accommodation;
        this.address = address;

    }

    void displayDetails() {

        JOptionPane.showMessageDialog(null,
                "STUDENT REGISTERED SUCCESSFULLY!" +
                        "\n" +
                        "\nStudent Name: " + fullName +
                        "\nAdmission Number: " + admNumber +
                        "\nPhone Number: " + phoneNumber +
                        "\nAge: " + age +
                        "\nCourse: " + course +
                        "\nGender: " + gender +
                        "\nAccommodation: " + accommodation +
                        "\nAddress: " + address);
    }

}

public class Admission {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Admission System");
        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Student Name: ");
        JTextField nameField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);

        JLabel admLabel = new JLabel("Admission Number: ");
        JTextField admField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(admLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(admField, gbc);

        JLabel phoneLabel = new JLabel("Phone Number: ");
        JTextField phoneField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(phoneField, gbc);

        JLabel ageLabel = new JLabel("Age: ");
        JTextField ageField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(ageField, gbc);

        JLabel courseLabel = new JLabel("Course: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(courseLabel, gbc);

        String[] courses = {

                "Computer Science",
                "Information Technology",
                "Software Engineering",
                "Cyber Security",
                "Business Administration",
                "Medicine and Surgery",
                "Actuarial Science"
        };

        JComboBox<String> coursesBox = new JComboBox<>(courses);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(coursesBox, gbc);

        JLabel genderLabel = new JLabel("Gender: ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(genderLabel, gbc);

        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(genderPanel, gbc);

        JLabel accommodationLabel = new JLabel("On-campus Accommodation: ");
        JCheckBox yesBox = new JCheckBox("yes");
        JCheckBox noBox = new JCheckBox("no");

        ButtonGroup accommGroup = new ButtonGroup();
        accommGroup.add(yesBox);
        accommGroup.add(noBox);

        JPanel accommPanel = new JPanel();
        accommPanel.add(yesBox);
        accommPanel.add(noBox);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(accommodationLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(accommPanel, gbc);

        JLabel addressLabel = new JLabel("Address: ");
        JTextArea addressArea = new JTextArea(4, 20);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(addressLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(addressArea, gbc);

        JButton submitButton = new JButton("SUBMIT");
        JButton clearButton = new JButton("CLEAR");

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(submitButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(clearButton, gbc);

        // SUBMIT button functionality
        submitButton.addActionListener(e -> {

            String fullName = nameField.getText();
            String admNumber = admField.getText();
            String phoneNumber = phoneField.getText();

            int age = Integer.parseInt(ageField.getText());

            String Course = (String) coursesBox.getSelectedItem();

            String gender;

            if (maleButton.isSelected()) {
                gender = "male";
            } else if (femaleButton.isSelected()) {
                gender = "female";
            } else {
                gender = "not Selected";
            }

            String accommodation;

            if (yesBox.isSelected()) {
                accommodation = "yes";
            } else if (noBox.isSelected()) {
                accommodation = "no";
            } else {
                accommodation = "not Selected";
            }

            String address = addressArea.getText();

            StudentDetails student = new StudentDetails(
                    fullName,
                    admNumber,
                    phoneNumber,
                    age,
                    Course,
                    gender,
                    accommodation,
                    address);

            student.displayDetails();

        });

        // CLEAR BUTTON FUNCTIONALITY

        clearButton.addActionListener(e -> {

            nameField.setText("");
            admField.setText("");
            phoneField.setText("");
            ageField.setText("");

            coursesBox.setSelectedIndex(0);
            genderGroup.clearSelection();
            accommGroup.clearSelection();

            addressArea.setText("");

        });

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 600, 300);
        frame.setVisible(true);
    }
}