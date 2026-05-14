import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ShopPOS {
    
    static int sugar = 150;
    static int teaLeaves = 50;
    static int rice = 100;
    static int unga = 140;
    static int total;
    static int balance;
    static int moneyReceived;
    int ungaQty, sugarQty, teaQty, riceQty;

    public ShopPOS(int s, int t, int r, int u, int m){
        sugarQty = s;
        teaQty = t;
        riceQty = r;
        ungaQty = u;
        moneyReceived = m;
    }

    int ungaTotal(){
        return (unga * ungaQty);
    }

    int sugarTotal(){
        return (sugar * sugarQty);
    }

    int teaTotal(){
        return (teaLeaves * teaQty);
    }

    int riceTotal(){
        return (rice * riceQty);
    }

    int calculateTotal(){
        int ungaTotalP = ungaTotal();
        int sugarTotalP = sugarTotal();
        int teaTotalP = teaTotal();
        int riceTotalP = riceTotal();

        total = ungaTotalP + sugarTotalP + teaTotalP + riceTotalP;
        return total;
    }

    int customerBalance (){
        total = calculateTotal();
        balance  = moneyReceived - total;
        return balance;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shop POS");
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel TopPanel = new JPanel();
        TopPanel.setBorder( new EmptyBorder(10, 20, 20, 20));
        TopPanel.setLayout(new GridLayout(5, 4, 10, 10));

        TopPanel.add(new JLabel("PRODUCTS"));
        TopPanel.add(new JLabel("PRICE"));
        TopPanel.add(new JLabel("QUANTITTY"));
        TopPanel.add(new JLabel("TOTAL"));

        TopPanel.add(new JLabel("Sugar"));
        TopPanel.add(new JLabel("sh.150/kg"));
        JTextField sugarQtyField = new JTextField();
        sugarQtyField.setText("0");
        JTextField sugarTotalField = new JTextField();
        sugarTotalField.setEditable(false);
        TopPanel.add(sugarQtyField);
        TopPanel.add(sugarTotalField);

        TopPanel.add(new JLabel("Tea Leaves"));
        TopPanel.add(new JLabel("sh.50/pkt"));
        JTextField teaQtyField = new JTextField();
        teaQtyField.setText("0");
        JTextField teaTotalField = new JTextField();
        teaTotalField.setEditable(false);
        TopPanel.add(teaQtyField);
        TopPanel.add(teaTotalField);

        TopPanel.add(new JLabel("Rice"));
        TopPanel.add(new JLabel("sh.100/kg"));
        JTextField riceQtyField = new JTextField();
        riceQtyField.setText("0");
        JTextField riceTotalField = new JTextField();
        riceTotalField.setEditable(false);
        TopPanel.add(riceQtyField);
        TopPanel.add(riceTotalField);

        TopPanel.add(new JLabel("Unga"));
        TopPanel.add(new JLabel("sh.140/kg"));
        JTextField ungaQtyField = new JTextField();
        ungaQtyField.setText("0");
        JTextField ungaTotalField = new JTextField();
        ungaTotalField.setEditable(false);
        TopPanel.add(ungaQtyField);
        TopPanel.add(ungaTotalField);

        JPanel BottomPanel = new JPanel();
        BottomPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );
        BottomPanel.setLayout(new GridLayout(4, 2, 10, 10));

        BottomPanel.add(new JLabel("Total Price"));
        JTextField totalPriceField = new JTextField();
        totalPriceField.setEditable(false);
        BottomPanel.add(totalPriceField);

        BottomPanel.add(new JLabel("Cash Received"));
        JTextField cashReceivedField = new JTextField();
        cashReceivedField.setText("0");
        BottomPanel.add(cashReceivedField);

        BottomPanel.add(new JLabel("Change"));
        JTextField customerBalanceField = new JTextField();
        customerBalanceField.setEditable(false);
        BottomPanel.add(customerBalanceField);

        JButton calculateTotalBtn = new JButton("Calculate Total");
        BottomPanel.add(calculateTotalBtn);

        JButton calculateBalanceBtn = new JButton("Calculate Balance");
        BottomPanel.add(calculateBalanceBtn);

        
        frame.add(TopPanel, BorderLayout.CENTER);
        frame.add(BottomPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        

        calculateTotalBtn.addActionListener(e -> {

            try{

            String S = sugarQtyField.getText().trim();
            int sugarQty = Integer.parseInt(S);
            String T = teaQtyField.getText().trim();
            int teaQty = Integer.parseInt(T);
            String U = ungaQtyField.getText().trim();
            int ungaQty = Integer.parseInt(U);
            String R = riceQtyField.getText().trim();
            int riceQty = Integer.parseInt(R);
            String C = cashReceivedField.getText().trim();
            int cashReceived = Integer.parseInt(C);


            ShopPOS commodities = new ShopPOS(sugarQty, teaQty, riceQty, ungaQty, cashReceived);

            int sugarTotal = commodities.sugarTotal();
            int teaTotal = commodities.teaTotal();
            int riceTotal = commodities.riceTotal();
            int ungaTotal = commodities.ungaTotal();
            int totalPrice = commodities.calculateTotal();

            sugarTotalField.setText("sh." +sugarTotal);
            teaTotalField.setText("sh." + teaTotal);
            riceTotalField.setText("sh." + riceTotal);
            ungaTotalField.setText("sh." +ungaTotal);
            totalPriceField.setText("sh." +totalPrice);

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Please Enter valid Numbers in all fields");
            }

        });

        calculateBalanceBtn.addActionListener(e -> {

                String S = sugarQtyField.getText();
                int sugarQty = Integer.parseInt(S);
                String T = teaQtyField.getText();
                int teaQty = Integer.parseInt(T);
                String U = ungaQtyField.getText();
                int ungaQty = Integer.parseInt(U);
                String R = riceQtyField.getText();
                int riceQty = Integer.parseInt(R);
                String C = cashReceivedField.getText();
                int cashReceived = Integer.parseInt(C);

                ShopPOS commodities = new ShopPOS(sugarQty, teaQty, riceQty, ungaQty, cashReceived);

                int customerBalance = commodities.customerBalance();
                customerBalanceField.setText("sh." +customerBalance);

        });
    }
}
