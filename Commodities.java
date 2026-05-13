import javax.swing.JOptionPane;

class Products{

    int Tea = 90;
    int Sugar = 100;
    int Unga = 130;
    int Total;
    int TeaQuantity;
    int SugarQuantity;
    int UngaQuantity;
    int customerMoney;


    Products(int SugarQuantity, int UngaQuantity, int TeaQuantity){
        this.TeaQuantity = TeaQuantity;
        this.SugarQuantity = SugarQuantity;
        this.UngaQuantity = UngaQuantity;
    }

    int ComputeTotalAmount(){

        Total = (Tea * TeaQuantity) + (Sugar * SugarQuantity) + (Unga * UngaQuantity);
        JOptionPane.showMessageDialog(null, "The total is ksh." +Total);
        return Total;
    }

    void setCustomerMoney(int money){
        this.customerMoney = money;
    }

    int ComputeBalance(){

        int customerChange = customerMoney - Total;
        if(customerMoney < Total){
            JOptionPane.showMessageDialog(null,customerMoney+" is less than the total, ksh."+Total);
            System.exit(1);
        }
        return customerChange;
    }

}

public class Commodities{
    public static void main(String[] arg){
        String S = JOptionPane.showInputDialog("Enter Sugar quantity: ");
        String U = JOptionPane.showInputDialog("Enter Unga quantity: ");
        String T = JOptionPane.showInputDialog("Enter Tea quantity: ");
        
        int SugarQ = Integer.parseInt(S);
        int UngaQ = Integer.parseInt(U);
        int TeaQ = Integer.parseInt(T);
        

        Products products = new Products(SugarQ, UngaQ, TeaQ);
        int Total = products.ComputeTotalAmount();
        
        String C = JOptionPane.showInputDialog("Your amount: ");
        int TotalCash = Integer.parseInt(C);
        products.setCustomerMoney(TotalCash);

        int Balance = products.ComputeBalance();

        JOptionPane.showMessageDialog(null, "The total is ksh." +Total+"\nYour balance is ksh." +Balance);

    }
}



// import javax.swing.JOptionPane;

// class POS {

//     // Prices
//     final int TEA = 90;
//     final int SUGAR = 100;
//     final int UNGA = 130;

//     int total = 0;

//     String receipt = "------ RECEIPT ------\n";

//     void showMenu() {
//         String menu = """
//                 Select product:
//                 1. Tea (ksh.90)
//                 2. Sugar (ksh.100)
//                 3. Unga (ksh.130)
//                 0. Finish Order
//                 """;

//         while (true) {
//             String input = JOptionPane.showInputDialog(menu);

//             int choice = Integer.parseInt(input);

//             if (choice == 0) break;

//             String qtyInput = JOptionPane.showInputDialog("Enter quantity:");
//             int qty = Integer.parseInt(qtyInput);

//             switch (choice) {
//                 case 1 -> addItem("Tea", TEA, qty);
//                 case 2 -> addItem("Sugar", SUGAR, qty);
//                 case 3 -> addItem("Unga", UNGA, qty);
//                 default -> JOptionPane.showMessageDialog(null, "Invalid choice!");
//             }
//         }
//     }

//     void addItem(String name, int price, int qty) {
//         int itemTotal = price * qty;
//         total += itemTotal;

//         receipt += name + " x" + qty + " = ksh." + itemTotal + "\n";
//     }

//     void checkout() {
//         receipt += "---------------------\n";
//         receipt += "TOTAL: ksh." + total + "\n";

//         String cashInput = JOptionPane.showInputDialog(
//                 "Total is ksh." + total + "\nEnter amount paid:");

//         int cash = Integer.parseInt(cashInput);

//         if (cash < total) {
//             JOptionPane.showMessageDialog(null,
//                     "Insufficient funds! You need ksh." + (total - cash));
//             return;
//         }

//         int change = cash - total;

//         receipt += "PAID: ksh." + cash + "\n";
//         receipt += "CHANGE: ksh." + change + "\n";
//         receipt += "---------------------\n";
//         receipt += "Thank you!\n";

//         JOptionPane.showMessageDialog(null, receipt);
//     }
// }

// public class Commodities {
//     public static void main(String[] args) {

//         POS pos = new POS();

//         pos.showMenu();   // user selects items
//         pos.checkout();   // payment + receipt
//     }
// }