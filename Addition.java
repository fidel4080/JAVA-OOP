import javax.swing.*;

class Addition {

    static int num1, num2;

    public Addition(int x, int y){
        num1 = x;
        num2 = y;
    }

    int addNumbers(){
        return num1 + num2;
    }

    public static void main(String[] args) {
        //frame
        JFrame frame = new JFrame("ADD two Numbers");
        frame.setBounds(500,  300, 400, 200);
        frame.setSize(500,300);
        frame.setLayout(null);// Disables automatic positioning

        //button
        JButton addBtn = new JButton("Calculate");
        addBtn.setBounds(50, 150, 100, 40);
        frame.add(addBtn);

        //label 1
        JLabel label1 = new JLabel("Enter x:");
        label1.setBounds(30, 40, 120, 40);
        frame.add(label1);

        //label 2
        JLabel label2 = new JLabel("Enter y:");
        label2.setBounds(30, 90, 120, 40);
        frame.add(label2);

        //textfield for input 1
        JTextField text1 = new JTextField();
        text1.setBounds(80, 40, 100, 40);
        frame.add(text1);

        //textfield for input 2
        JTextField text2 = new JTextField();
        text2.setBounds(80, 90, 100, 40);
        frame.add(text2);

        //textfield for output
        JTextField outputField = new JTextField();
        outputField.setBounds(160, 150, 100, 40);
        frame.add(outputField);

        addBtn.addActionListener(e -> {
            String input1 = text1.getText();
            String input2 = text2.getText();
            int x = Integer.parseInt(input1);
            int y = Integer.parseInt(input2);

            Addition numbers = new Addition(x, y);
            int sum = numbers.addNumbers();

            outputField.setText("" +sum);
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
