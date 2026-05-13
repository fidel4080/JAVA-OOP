import java.awt.Color;
import javax.swing.*;

class Colours {

    public static void main(String[] args){

    JFrame frame = new JFrame("Colors");
    frame.setSize(500,300);
    frame.setLayout(null);

    JButton RedBtn = new JButton("RED");
    RedBtn.setBounds(40, 190, 90, 40);
    frame.add(RedBtn);


    JButton GreenBtn = new JButton("GREEN");
    GreenBtn.setBounds(280, 190, 90, 40);
    frame.add(GreenBtn);

    JPanel colourPanel = new JPanel();
    colourPanel.setBounds(60, 30, 300, 150);
    colourPanel.setBackground(Color.WHITE);
    frame.add(colourPanel);

    RedBtn.addActionListener(e -> {
        colourPanel.setBackground(Color.RED);
    });

    GreenBtn.addActionListener(e -> {
        colourPanel.setBackground(Color.GREEN);
    });
    

    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
