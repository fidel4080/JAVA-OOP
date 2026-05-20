import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TableQn1 {
    
    int number;

    TableQn1(int n){
        number = n;
    }

    String multiplyNumber(){

        String table = "";

        for(int i = 1; i <= 12; i++){
            table += number +" X " +i+ " = "+ (number * i) +"\n";
        }

        return table;
    }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("multiplication table");
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        topPanel.setLayout(new GridLayout(1, 3, 10, 10));

        JTextField inputField = new JTextField();
        JButton submitBtn = new JButton("Submit");

        topPanel.add(new JLabel("Enter Number: "));
        topPanel.add(inputField);
        topPanel.add(submitBtn);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(20,20,20,20));
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        submitBtn.addActionListener(e -> {
            try {
                String N = inputField.getText();
                int num = Integer.parseInt(N);

                TableQn1 userNumber = new TableQn1(num);

                textArea.setText(userNumber.multiplyNumber());
                
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ENTER VALID NUMBERS ONLY!");
            }

        });

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
