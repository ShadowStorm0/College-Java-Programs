import javax.swing.JOptionPane;

public class FreezingAndBoilingPoints {
    public static void main(String[] args) throws Exception {

        //Initalization
        String restart, userTemp, alcoholState = "Liquid", mercuryState = "Liquid", oxygenState = "Gas", waterState = "Liquid";
        Boolean restartCheck = false, inputRestart = false;
        int intUserTemp = 0;
        char restartChar;

        do{
            //Message to User
            JOptionPane.showMessageDialog(null, 
                "Different substances exists in different states of matter depending on the temperature.\n"
                + "The program displays the states of matter for some common substances based\n"
                + "on a temperature entered by the user.\n");

            //User Input
            do{
                userTemp = JOptionPane.showInputDialog(null,
                    "Please enter a temperature.");
                    if (numericCheck(userTemp)){ // Input validation (Check if number)
                        inputRestart = false;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                            "Please enter a number\n");
                        inputRestart = true;
                        continue;
                    }
                intUserTemp = Integer.parseInt(userTemp); // Type Conversion (String to Int)
            }while(inputRestart);

            //States Check (In Order of lowest to Greatest)
            if (intUserTemp <= -362){
                oxygenState = "Solid";
            }if (intUserTemp >= -306){
                oxygenState = "Gas";
            }if (intUserTemp <= -173){
                alcoholState = "Solid";
            }if (intUserTemp <= -38){
                mercuryState = "Solid";
            }if (intUserTemp <= 32){
                waterState = "Solid";
            }if (intUserTemp >= 172){
                alcoholState = "Gas";
            }if (intUserTemp >= 212){
                waterState = "Gas";
            }if (intUserTemp >= 676){
                mercuryState = "Gas";
            }

            //Restart dialog and Display
            do{
                restart = JOptionPane.showInputDialog(null,
                    "----Common States of Matter----\n"
                    + "    " + intUserTemp + " Degrees Farenheit\n"
                    + "---------------------------------------\n"
                    + "---- Ethyl Alcohol    " + alcoholState + "\n"
                    + "---- Mercury            " + mercuryState + "\n"
                    + "---- Oxygen             " + oxygenState + "\n"
                    + "---- Water               " + waterState + "\n"
                    + "---------------------------------------\n"
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
                "Thank You For Running This Program!\n");
        }
    }

    /**
     * @param stringNum String Being Tested
     * @return A bool value of true if string is a number, false if it can be parse in to a double
     */
    public static boolean numericCheck(String stringNum) {
        if (stringNum == null){
            return false;
        }
        try{
            double number = Double.parseDouble(stringNum);
        }catch (NumberFormatException ex) {
            return false;
        }
    return true;
    }
}