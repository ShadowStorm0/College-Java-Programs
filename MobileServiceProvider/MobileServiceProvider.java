import javax.swing.JOptionPane;

public class MobileServiceProvider{
    public static void main(String[] args){

        char restartChar;

        do{
            //Initialization
            String userPackage, userHours, Restart;
            char packageChar;
            boolean isNumber = true;

            final double packageA = 9.95, packageB = 13.95, packageC = 19.95;
            double customerBillA = 0.00, customerBillB = 0.00, customerBillC = 0.00;
            double savePackageAB = 0.00, savePackageAC = 0.00, savePackageBC = 0.00; 
            double remainderA = 0.00, remainderB = 0.00;
            int additionalA = 2, additionalB = 1, hoursA = 10, hoursB = 20 , hoursInt = 0, hoursIntA = 0, hoursIntB = 0;

            //User package infomation
            JOptionPane.showMessageDialog(null, 
                "Package A: For 9.95 per month 10 hours of access are provided.\n"
                + "Additional hours are $2.00 per hour.\n"
                + "Package B: For 13.95 per month 20 hours of access are provided.\n"
                + "Additional hours are $1.00 per hour.\n"
                + "Package C: For $19.95 per month unlimited access is provided.\n");
            
            //User Input Dialog (A/B/C)
            userPackage = JOptionPane.showInputDialog(null, 
                "Please enter the package (A/B/C):\n");
            packageChar = userPackage.charAt(0); //Type conversion (String to Char)

            //User Input Dialog (Hours)
            userHours = JOptionPane.showInputDialog(null, 
                "Please enter the number of hours:\n");
            isNumber = userHours.matches("-?\\d+(\\.\\d+)?"); //Check if number
            if(isNumber == false){
                JOptionPane.showMessageDialog(null, 
                    "Error! Please enter only a number\n"
                    + "Exiting Program\n");
                System.exit(0);
            }
            hoursInt = Integer.parseInt(userHours); //Type Conversion (String to Int)
            hoursIntA = hoursInt;
            hoursIntB = hoursInt;
 
            //Calculations (Check if over package hours)
            if(packageChar == 'A' || packageChar == 'a' || packageChar == 'B' || packageChar == 'b' || packageChar == 'C' || packageChar == 'c'){ //Check if A, B or C
                if ((packageChar == 'A' || packageChar == 'a') && (hoursIntA > hoursA)){
                    remainderA = hoursIntA - hoursA; //More then 10 hours
                    customerBillA = packageA + (remainderA * additionalA);
                }else{
                    customerBillA = packageA; //No change
                }
                if ((packageChar == 'B' || packageChar == 'b') && (hoursIntB > hoursB)){ 
                    remainderB = hoursIntB - hoursB; //More then 20 hours
                    customerBillB = packageB + (remainderB * additionalB);
                }else{
                    customerBillB = packageB; //No change
                }
                if (packageChar == 'C' || packageChar == 'c'){
                    customerBillC = packageC; //No change
                }else{
                    customerBillC = packageC; //No change
                }
                
            //Savings calculation
            if(customerBillA > customerBillB){
            savePackageAB = customerBillA - customerBillB;} //Package A (B)
            if(customerBillA > customerBillC){
            savePackageAC = customerBillA - customerBillC;} //Package A (C)
            if(customerBillB > customerBillC){
            savePackageBC = customerBillB - customerBillC;} //Package B (C)

            //Message Dialog (Display)
            if(packageChar == 'A' || packageChar == 'a'){
                JOptionPane.showMessageDialog(null, 
                    "The monthly bill for the customer using package " + packageChar + " is $" + customerBillA + ".\n"
                    + "If the customer switched to package B or C, the savings would be $" + savePackageAB + " and $" + savePackageAC + " respectively.");
                }
            if(packageChar == 'B' || packageChar == 'b'){
                JOptionPane.showMessageDialog(null, 
                    "The monthly bill for the customer using package " + packageChar + " is $" + customerBillB + ".\n"
                    + "If the customer switched to package C, the savings would be $" + savePackageBC + ".\n");
                }
            if(packageChar == 'C' || packageChar == 'c'){
                JOptionPane.showMessageDialog(null, 
                    "The monthly bill for the customer using package " + packageChar + " is $" + customerBillC + ".\n");
                }

            //Check if A, B or C
            }else{
                JOptionPane.showMessageDialog(null, 
                    "Error! Please enter only A, B or C\n"
                    + "Exiting Program\n");
                System.exit(0);
            }  

            //Restart dialog 
            Restart = JOptionPane.showInputDialog(null, 
                "Are there more monthly billLists to calculate? Y/N");
            restartChar = Restart.charAt(0); //Type conversion (String to Char)

        }while (restartChar == 'Y' || restartChar == 'y');
    }
}