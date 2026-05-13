import javax.swing.JOptionPane;
class AreaRec {
    static int length;
    static int width;

    static int ComputeArea(){
        return length * width;
    }

    static int ComputePerimeter(){
        return length + width;
    }

    public static void main(String[] args) {
        String L = JOptionPane.showInputDialog("Enter length: ");
        length = Integer.parseInt(L);

        String W = JOptionPane.showInputDialog("Enter width: ");
        width = Integer.parseInt(W);

        JOptionPane.showMessageDialog(
            null,
            "The Area is " +ComputeArea() +
            "\nThe perimeter is "+ComputePerimeter()
        );
    }
}
