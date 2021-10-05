import javax.swing.JOptionPane;
import java.security.SecureRandom;


public class RockPaperScissors {
    public static void main(String[] args) throws Exception{

        //Initalization
        int userWinCount = 0 , computerWinCount = 0, tiedCount = 0, intUserChoice = 0, min = 1, max = 3;
        boolean userRestart = false, restartCheck = false;
        String restart, userChoice;
        char restartChar;

        do{
                //Computer choice
                int computerChoice = secureRandom(min, max);

                //User Input
                do{
                    userChoice = JOptionPane.showInputDialog(null, 
                        "Enter '1' to choose 'rock,\n"
                        + "enter '2' to choose 'paper',\n"
                        + "or enter '3' to choose 'scissors.");
                    if (userChoice.matches("[0-9]+[\\.]?[0-9]*")){ // Input validation (Check if number using Regex)
                        userRestart = false;
                    }else{
                        JOptionPane.showMessageDialog(null, 
                            "Error! Please enter a number from 1 to 3\n");
                        userRestart = true;
                        continue;
                    }
                    intUserChoice = Integer.parseInt(userChoice); // Type Conversion (String to Int)
                    if (intUserChoice >= 1 && intUserChoice <= 3){ // Input validation (1 to 3)
                        userRestart = false;
                    }else{
                        JOptionPane.showMessageDialog(null, 
                            "Error! Please enter a number from 1 to 3\n");
                        userRestart = true;
                    }
                }while(userRestart);

                //Display computer choice
                if (computerChoice == 1){
                    JOptionPane.showMessageDialog(null, 
                        "The computer chose rock!");
                }else if (computerChoice == 2){
                    JOptionPane.showMessageDialog(null, 
                        "The computer chose paper!");
                }else if (computerChoice == 3){
                    JOptionPane.showMessageDialog(null, 
                        "The computer chose scissors!");
                }else{
                    JOptionPane.showMessageDialog(null,
                        "Debugging\n" 
                        + "Error! Computer chose outside the range of 1 to 3");
                    System.exit(0); // Closes program for debugging
                }

                //Win conditions (1 = rock, 2 = paper, 3 = scissors)
                if (intUserChoice == 1 && computerChoice == 1){
                    JOptionPane.showMessageDialog(null, 
                        "Tie!");
                    tiedCount++;
                }else if (intUserChoice == 2 && computerChoice == 2){
                    JOptionPane.showMessageDialog(null, 
                        "Tie!");
                    tiedCount++;
                }else if (intUserChoice == 3 && computerChoice == 3){
                    JOptionPane.showMessageDialog(null, 
                        "Tie!");
                    tiedCount++;
                }else if (intUserChoice == 2 && computerChoice == 1){
                    JOptionPane.showMessageDialog(null, 
                        "User Wins!");
                    userWinCount++;
                }else if (intUserChoice == 1 && computerChoice == 3){
                    JOptionPane.showMessageDialog(null, 
                        "User Wins!");
                    userWinCount++;
                }else if (intUserChoice == 3 && computerChoice == 2){
                    JOptionPane.showMessageDialog(null, 
                        "User Wins!");
                    userWinCount++;
                }else if (intUserChoice == 2 && computerChoice == 3){
                    JOptionPane.showMessageDialog(null, 
                        "You Lost\n" 
                        + "Computer Wins!");
                    computerWinCount++;
                }else if (intUserChoice == 1 && computerChoice == 2){
                    JOptionPane.showMessageDialog(null, 
                        "You Lost\n" 
                        + "Computer Wins!");
                    computerWinCount++;
                }else if (intUserChoice == 3 && computerChoice == 1){
                    JOptionPane.showMessageDialog(null,
                        "You Lost\n" 
                        + "Computer Wins!");
                    computerWinCount++;    
                }else{
                    JOptionPane.showMessageDialog(null,
                        "Debugging\n" 
                        + "Error! Win Conditions");
                    System.exit(0); // Closes program for debugging
                }

            //Restart dialog and Display
            do{
                restart = JOptionPane.showInputDialog(null,
                    "Your Wins: " + userWinCount + "\n"
                    + "Computer Wins: " + computerWinCount + "\n"
                    + "Tied Games: " + tiedCount + "\n\n"
                    + "Would you like to Play Again?\n"
                    + "(Type Y for Yes or N for No)\n");
                restartChar = restart.charAt(0); // Type conversion (String to Char)
                if (restartChar == 'Y' || restartChar == 'y' || restartChar == 'N' || restartChar == 'n'){ // Input validation (Y or N)
                    restartCheck = false;
                }else{
                    JOptionPane.showMessageDialog(null,
                        "Error! Please enter only Y or N");
                    restartCheck = true;
                }
            }while(restartCheck);
        }while(restartChar == 'Y' || restartChar == 'y');

        // Thanks the user
        if(restartChar == 'N' || restartChar == 'n'){ 
            JOptionPane.showMessageDialog(null, 
                "Thank You For Running This Program!\n"
                + "Created by: ShadowStorm0\n");
        }
    }

    /**
     * @param min #1
     * @param max #3
     * @return NativePRNG random number
     * @throws Exception
     */
    public static int secureRandom(int min, int max) throws Exception{

        final SecureRandom secure = new SecureRandom(); //Create Object
        SecureRandom.getInstanceStrong(); //Select strongest crypto source

        return secure.nextInt(max - min) + min;
    }
}