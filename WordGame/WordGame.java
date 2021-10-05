import javax.swing.JOptionPane;

public class WordGame{
    public static void main(String[] args){

        //Initialization
        String name, age, cityName, collegeName, profession, animalType, petName;

        //User Input Dialog(s)
        name = JOptionPane.showInputDialog(null, "Enter your name.");
        age = JOptionPane.showInputDialog(null, "Enter your age.");
        cityName = JOptionPane.showInputDialog(null, "Enter a city.");
        collegeName = JOptionPane.showInputDialog(null, "Enter a college.");
        profession = JOptionPane.showInputDialog(null, "Enter a profession.");
        animalType = JOptionPane.showInputDialog(null, "Enter a animal type.");
        petName = JOptionPane.showInputDialog(null, "Enter a pet's name.");

        //Message Dialog (Display)
        JOptionPane.showMessageDialog(null, 
        "There once was a person named " + name + " who lived in " + cityName + ".\n" 
        + "At the age of " + age + ", " + name + " went to college at " + collegeName + ".\n"
        + name + " graduated and went to work as a " + profession + ".\n"
        + "Then, " + name + " adopted a(n) " + animalType + " named " + petName + ".\n"
        + "They both lived happily ever after.");
    }
}