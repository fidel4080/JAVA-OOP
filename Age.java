import javax.swing.*;

class Person{

    int age;

    Person(int age){
        this.age = age;
    }

    public void AgeLogic(){

        if(age >= 18){
            JOptionPane.showMessageDialog(null, "ADULT");
        }
        else{
            JOptionPane.showMessageDialog(null, "CHILD");
        }
    }
}

public class Age {
    public static void main(String[] args) {
        String UserInput = JOptionPane.showInputDialog("Enter your Age: ");
        int age = Integer.parseInt(UserInput);

        Person person1 = new Person(age);
        person1.AgeLogic();

    }
}
