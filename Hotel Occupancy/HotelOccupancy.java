import javax.swing.JOptionPane;

public class HotelOccupancy{
    public static void main(String[] args){

    char restartChar;

    do{
        //Initalization
        double occupancyRate = 0.0, totalRooms = 0.0, totalRoomsOccupied = 0.0, vacent = 0.0;
        boolean floorRestart = false, roomRestart = false, occupiedRestart = false;
        int intNumFloors = 0, intRooms = 0, intRoomsOccupied = 0;
        String numFloors, numRooms, numRoomsOccupied, restart;

        //Input number of floors
        do{
            numFloors = JOptionPane.showInputDialog(null, 
                "Enter the number of floors in the hotel\n");
            intNumFloors = Integer.parseInt(numFloors); //Type Conversion (String to Int)
            if(intNumFloors >= 1 && intNumFloors <= 8){ // Input validation (1 to 8)
                break;
            }else{
                JOptionPane.showMessageDialog(null,
                "Error! Please enter a floor from 1 to 8\n");
                floorRestart = true;
            }
        }while(floorRestart);

        //Input number of rooms per x number of floors
            for(int i = 1; i <= intNumFloors; i++){
                if (i == 13) continue; // Skips floor 13
                    do{
                        //Rooms count
                        numRooms = JOptionPane.showInputDialog(null,
                            "Enter the rooms on floor " + i + " of the hotel");
                        intRooms = Integer.parseInt(numRooms); //Type Conversion (String to Int)
                        if(intRooms >= 10 && intRooms <= 30){ // Input validation (10 to 30)
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null,
                            "Error! Please enter a room amount from 10 to 30\n");
                            roomRestart = true;
                        }
                    }while(roomRestart);

                do{
                    //Occupied count
                    numRoomsOccupied = JOptionPane.showInputDialog(null,
                        "Enter the number of rooms on floor " + i + " that are occupied");
                    intRoomsOccupied = Integer.parseInt(numRoomsOccupied); //Type Conversion (String to Int)
                    if(intRoomsOccupied >= 0 && intRoomsOccupied <= intRooms){ // Input validation (0 to intRooms)
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null,
                        "Error! Please enter a number less then or equal to the number of rooms on a floor\n");
                        occupiedRestart = true;
                    }
                }while(occupiedRestart);

                //Running total
                totalRooms += intRooms;
                totalRoomsOccupied += intRoomsOccupied;
            }     

            //Calculation
            occupancyRate = (totalRoomsOccupied / totalRooms) * 100; //Occupancy rate = Number of rooms occupied ÷ Total number of rooms
            vacent = totalRooms - totalRoomsOccupied;

            //Display
            JOptionPane.showMessageDialog(null,
                "There are a total of " + (int)totalRooms + " rooms in the hotel.\n"
                + "There are a total of " + (int)totalRoomsOccupied + " rooms that are occupied.\n"
                + "The number of rooms that are vacent are " + (int)vacent + ".\n"
                + "The occupancy rate is " + occupancyRate + "%"); 

            //Restart dialog 
            restart = JOptionPane.showInputDialog(null, 
                "Do you want to restart? Y/N");
            restartChar = restart.charAt(0); //Type conversion (String to Char)

        }while (restartChar == 'Y' || restartChar == 'y');
    }
}