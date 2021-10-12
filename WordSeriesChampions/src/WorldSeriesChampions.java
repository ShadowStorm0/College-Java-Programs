import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class WorldSeriesChampions {
    public static void main(String[] args) throws Exception {
        
    //Initalizatio
    int restartCheck, defualtCheck, count = 0, occuranceCount = 0, winLoop = 0;
    String teamChoice;

    do{
            //Default file check
            defualtCheck = JOptionPane.showConfirmDialog(null,
                "Do you want to use the default file WorldSeriesWinners.txt?", 
                "Input",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (defualtCheck == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null,
                    "Please use WorldSeriesWinners.txt");
                System.exit(0);
            }else{
                System.out.println("Opening File\n");
            }

            //.txt to ArrayList
            String[] wins = new String[104];
            File file = new File("WorldSeriesWinners.txt");
            Scanner inputFile = new Scanner(file);
            while(inputFile.hasNext() && count < wins.length){
                wins[count] = inputFile.nextLine();
                count++;
            }
            inputFile.close(); //Closes file

            //User Choice
            teamChoice = JOptionPane.showInputDialog(null, 
                "What team do you want stats on?");

            //Years array
            int xYears = 1902;
            ArrayList<Integer> Years = new ArrayList<>(108);
            for (int i = 0; i < 108; i++){
                Years.add(xYears);
                xYears++;
            }
            Years.remove(1);// Remove 1904
            Years.remove(91);// Remove 1994
            System.out.print(Years);

            //Count Occurances that matches User Input and Years
            ArrayList<Integer> getYears = new ArrayList<>();
            for(String i : wins){
                if(i.equals(teamChoice)){
                    winLoop++;
                    occuranceCount++;
                    getYears.add(Years.get(winLoop));
                }
            }
            getYears.toString(); //Convert array to string

            //Display
            JOptionPane.showMessageDialog(null, 
                "The " + teamChoice + " have won the World Series in the years:\n"
                + getYears + "\n"
                + "and the World Series " + occuranceCount + " times.");

            //Restart dialog  
            restartCheck = JOptionPane.showConfirmDialog(null,
                "Do you want to search for another team?\n"
                + "                 (Click Yes or No)\n", 
                "Do you want to search for another team?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        }while(restartCheck == JOptionPane.YES_OPTION);   
    }
}



