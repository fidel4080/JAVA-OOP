import javax.swing.*;

class Temperature{
    double FahrenheitDeg;

    Temperature(double FahrenheitDeg){
        this.FahrenheitDeg = FahrenheitDeg;
    }

    double toCelcius(){
        double celciusDeg = (FahrenheitDeg - 32.00) * (5.00 / 9.00);
        return celciusDeg;
    }
}
public class TempConverter {
    public static void main (String[] arg){

        String Input = JOptionPane.showInputDialog(null,"Enter temperature in Fahrenheit: ");
        double Fahrenheit = Double.parseDouble(Input);

        Temperature temperature = new Temperature(Fahrenheit);
        double Celcius = temperature.toCelcius();

        JOptionPane.showMessageDialog(
            null,
            String.format("%.2f°F converted to °C is %.2f°C", Fahrenheit, Celcius)
        );

    }
}
