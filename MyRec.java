import javax.swing.*;
class MyRec{
    int length, width;

    //constructor
    public MyRec(int l ,int w){
        length = l;
        width = w;
    }

    int ComputeArea(){
        return length * width;
    }

    public static void main(String[] args) {
        String Length = JOptionPane.showInputDialog("Enter Length: ");
        int l = Integer.parseInt(Length);
        String Width = JOptionPane.showInputDialog("Enter Width: ");
        int w = Integer.parseInt(Width);

        MyRec rectangle = new MyRec(l, w);
        int Area = rectangle.ComputeArea();
        JOptionPane.showMessageDialog(null, "The area is " +Area);
    }
}