import javax.swing.*;

class QuadraticFunction {
    double a, b, c;
    
    
    QuadraticFunction(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c; 
    }

    double getDiscriminant(){
        return (b * b) - (4 * a * c);
    }

    String solveQuadraticFunction(){
        double D = getDiscriminant();

        //two values of x
        if(D > 0){
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);

            return "First value of x = " + x1 + "\nSecond value of x = " + x2;
           
        }

        //One value of x
        else if(D == 0){
            double x  = -b / (2 * a);

            return "The two values of x are " + x + " each";
        }

        //complex roots logic
        else{
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-D) / (2 * a);

            return "The complex roots are:\n "
            +"first value of x = " + realPart + "+" + imaginaryPart +"i" +
            "\nsecond value of x = " + realPart + "-" + imaginaryPart +"i";
        }
    }
}

public class QuadraticSolver{
    public static void main(String[] args){
        String result;
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b: "));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c: "));

        QuadraticFunction QuadFunction = new QuadraticFunction(a, b, c);

        result = QuadFunction.solveQuadraticFunction();

        JOptionPane.showMessageDialog(null, result);
    }
}
