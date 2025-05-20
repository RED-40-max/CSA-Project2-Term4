/* Program: Main menu 
    + arcades main menu that controls the other functions 
 
 */

import java.util.Scanner; 

public class MainMenu 
{
    

    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        
        boolean CanRun = true ; //if this program can run, then let it 

        while(CanRun) // checks if it can run 
        {
            //prints the main menu 
            System.out.println("\n. ݁₊ ⊹ . ݁˖ . ݁ Arcade Menu . ݁₊ ⊹ . ݁˖ . ݁");
            System.out.println("1 -  Hang-Man ");
            System.out.println("2 -   ");
            System.out.println("3 -  ");
            System.out.println("4 -   ");
            System.out.println("5 -   ");
            System.out.println("9 - Random");
            System.out.println("0 - to exit");
            System.out.println(" ヾ(＾ ∇ ＾). enter choice here:"); 
            int UserChoice = reader.nextInt(); //reads in the choice 

           if(UserChoice == 0 ) //if the user wishes to exit
           {
                System.out.println("⊹₊⟡⋆Thank you for coming! ⊹₊⟡⋆ \nexiting now..."); 
                break; //break out from the loop 
           } else if(UserChoice == 9) //otherwise if they pick random, 
           { //then update the variable so that when it gets to the switch statements, it can run a random game 
                UserChoice = (int) (Math.random()* (5 - 1 + 1) + 1);
                //random number from 1-5 inclusive 
           }

           switch(UserChoice)
           {
                case 1: 
                    System.out.println("Hang-Man chosen. Loading now...");
                    //call the method for the game here: 
                    break;
                case 2: 
                    System.out.println("Rock-Paper-Gun chosen. Loading now...");
                    //call the method for the game here: 
                    initalLevel obj = new initalLevel();
                    obj.mainMenu();
                    break;
                case 3: 
                    System.out.println("[GAME NAME] chosen. Loading now...");
                    //call the method for the game here: 
                    break;
                case 4: 
                    System.out.println("[GAME NAME] chosen. Loading now...");
                    //call the method for the game here: 
                    break;
                case 5: 
                    System.out.println("[GAME NAME] chosen. Loading now...");
                    //call the method for the game here: 
                    break;
                default: 
                    System.out.println("error try again");
                    break; 

           }
            
        }
    }
    
}

