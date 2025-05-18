/* Program: inital level 
    + level one of the RPS game 

contains: 
    + class variables 
    + if the player is winning at any given moment

    IIN MAIN OF ARCADE: 
    new InitialGame().mainMenu();

 */
import java.util.Scanner;

public class initalLevel {

    //static so i can track throught the 
    public static int HighestLevelUnlocked ; //so i can track throught the game 
    public int ClassLevel = 1; 
    public static boolean CheatMode = true;
    public static String[] PlayChoices = {"Rock","Paper", "Scissors", "Fork", "Spoon", "Fire", "Water", "Gun"}; 
    public Scanner reader = new Scanner(System.in);
    public static boolean SecretLevelUnlocked = false; 


//method that generates a random number based on the max that it gives 

public int RandNum()
{ //min is always 0 (rock), and max is dependent on the level
    int max  = ClassLevel *2; //becuse i always add 2 onton the existing base of 2, so level 1 --> 2
    //level 2 ==> 4 max choices since 0 is a thing, there will be odd number for choices, but even max 
    int randomNumber = (int) (Math.random()* ((max -0)- 0 + 0) + 0); 
    return randomNumber; 
}


//this is the method that makes the menu run 

public void mainMenu() 
{
    boolean CanRun = true ; 
    while(CanRun) // checks if it can run 
    {
        //prints the main menu 
        System.out.println("\n----- Main Menu -----");
         System.out.println("0 - Exit");
        System.out.println("1 - Level 1: Rock Paper Scissors");
        if (HighestLevelUnlocked >= 2) //if they unlcked the leevel, it will be reflected here. 
        {
                System.out.println("2 - Level 2: + Fork & Spoon");
        }
         if (HighestLevelUnlocked >= 3) //if they unlcked the leevel, it will be reflected here. 
         {
                System.out.println("3 - Level 3: + Fire & Water");
         }
         if (SecretLevelUnlocked) //if they unlcked the leevel, it will be reflected here. 
        {
                System.out.println("4 - Secret Level: Gun");
         }
         if(CheatMode) //if it is on, print it so 
         {
            System.out.println("Cheat Mode: On");
         } else { System.out.println("Cheat Mode: Off");}
         System.out.print("Enter choice: "); //this will alowe thme to make a cohoice in the menu 
            int choice = reader.nextInt();
        
            if (choice == 0) { //if htye want to exit, they leave 
                System.out.println("Thanks for playing!");
                CanRun = false;  
                break; //breaks ou t of the loop  

            } 
            else if (choice == 1) { //if it is the first level
             this.PlayLevel(); //you play this level since this is the intial level, the object 

            } else if (choice == 2) { //other wise you can choose to play it
             if (HighestLevelUnlocked >= 2) { //if it is unlcoekd then play
                    initalLevel obj = new Level2();  //make a subclass object of the second one, with upcasting so that when i call a menu functino or something, it will play for level two 
                        obj.PlayLevel(); //plays it 
                } else { //if not unlcoekc ed then you have ot say that that was whta is twa s
                    System.out.println("Level 2 locked. Win Level 1 to unlock."); //otherwise it says that it is ulcl
                }
            } else if (choice == 3) {
                if (HighestLevelUnlocked >= 3) {
                    initalLevel obj = new Level3(); //make a subclass object of the second one, with upcasting so that when i call a menu functino or something, it will play for level two 
                        obj.PlayLevel(); //plays it 
             } else {
                    System.out.println("Level 3 locked. Win Level 2 to unlock."); //if not unlcoekc ed then you have ot say that that was whta is twa s
                }
            } else if (choice == 4) {//can play secret level if unlockec 
               
             if (HighestLevelUnlocked >= 4) {
                    new SecretLevel().PlayLevel();
                } 
                else {//if not unlcoekc ed then you have ot say that that was whta is twa s
                    System.out.println("Secret Level locked. Win Level 3 to unlock.");
                }
            } else {
                System.out.println("Invalid choice!");
            }

    }

}

//method to unlock the next class
public void unlockNextLevel() {

    int next = this.ClassLevel + 1;//get the classes thing 

    if (HighestLevelUnlocked < next) { //if it is any diffrent / they can unlcok another level, then do so 
        HighestLevelUnlocked = next; // make it the new one + 1
        System.out.println("Level " + next + " unlocked!"); // and saw what level is unlcoekd 
    }
    if (HighestLevelUnlocked > 3) { //if there is a command sent, and 3 is the higest, unlock the secret level
        SecretLevelUnlocked = true; 
        
    }
}

//this is a global method / all classes should be able to acess this method 
public void PlayLevel() 
{ 

    int currentPoints = 0; 
    for(int x= 0; x < 3; ) //to loop / play three rounds, if it is a tie, that dosn't count as a round so we leave the incrmeetn blank untill we can fully confomir
    {  
        //prompt user to have an input 
        PrintMenu(); 
        int ComputerChoice = RandNum(); 
        if (CheatMode)
        {
            System.out.println("[Cheat] Computer will play: " + PlayChoices[ComputerChoice]);
        }
        int PlayerChoice = reader.nextInt(); //reads user input
        
        //rand num = 2 since there are only 3 choices
        int PlayerWinRound = playRound(PlayerChoice, ComputerChoice); 
        System.out.println("-----------------------------Round "+(x+1)+"/3 ---------------------------------"); 
        System.out.print("System Choice: " + PlayChoices[ComputerChoice] + "\n Player Choice: " + PlayChoices[PlayerChoice]); 

        if (PlayerWinRound == 2) // if it is a tie 
        {  
            System.out.print(" It is a tie! do it again"); 
            //
            
        } else if (PlayerWinRound == 1)
        {
            System.out.print (" you have won this round! "); 
            x ++; 
            currentPoints++ ; //make the current points increased 

        } else if (PlayerWinRound == 0 )
        {
            System.out.println("you have lost this round!"); 
            x ++ ; 
        } else {
             //if it is an invalid oepration, print it and tell them to do it again 
        }
        System.out.println(" you have " + currentPoints + " points"); 

    }

    if (currentPoints >= 2)// if you have won the level 
    {
        System.out.println("You have won this level");
        if(HighestLevelUnlocked < ClassLevel) 
        {
            System.out.println(" you have unlocked a new level!"); 
           
        }
        unlockNextLevel(); //updates it 
    } else 
    {
        System.out.println("you have lost this level");

    }


}

public void PrintMenu() //prints the options the user has 
{

    System.out.println("""
        -----Options-----
        0 - Rock 
        1 - Paper 
        2 - Scissors 
        enter play here: 
        """); 
}


public int playRound(int input, int randNum) //input is player input
{  
    //for 1 it is a player win 
    //for 0 it is a computer win 
    //for 3, its like an error / wrong input or somthign 
//the sucess / fail descition matrix 
if (input == randNum) {
    return 2;  // tie
} 
else if (input == 0 && randNum == 1) {
    return 0;  // Rock vs Paper ⇒ player loses
}
else if (input == 1 && randNum == 0) {
    return 1;  // Paper vs Rock ⇒ player wins
}
else if (input == 1 && randNum == 2) {
    return 0;  // Paper vs Scissors ⇒ player loses
}
else if (input == 2 && randNum == 1) {
    return 1;  // Scissors vs Paper ⇒ player wins
}
else if (input == 2 && randNum == 0) {
    return 0;  // Scissors vs Rock ⇒ player loses
}
else if (input == 0 && randNum == 2) {
    return 1;  // Rock vs Scissors ⇒ player wins
}
else {
    return 3;  // invalid operation
}
}


}
