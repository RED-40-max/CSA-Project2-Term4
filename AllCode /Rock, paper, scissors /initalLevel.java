/* Program: inital level 
    + level one of the RPS game 

contains: 
    + class variables 
    + if the player is winning at any given moment

 */
import java.util.Scanner;

public class initalLevel {

    //static so i can track throught the 
    public static int HighestLevelUnlocked = 0; //so i can track throught the game 
    public int ClassLevel = 1; 
    public static String[] PlayChoices = {"Rock","Paper", "Scissors", "Fork", "Spoon", "Fire", "Water", "Gun"}; 
    public Scanner reader = new Scanner(System.in);


//method that generates a random number based on the max that it gives 
public int RandNum(int max)
{ //min is always 0 (rock), and max is dependent on the level
    int randomNumber = (int) (Math.random()* ((max -0)- 0 + 0) + 0); 
    return randomNumber; 
}


//this is a global method / all methods should be able to acess this method 
public void PlayLevel() 
{

    int currentPoints = 0; 
    for(int x= 0; x < 3; ) //to loop / play three rounds, if it is a tie, that dosn't count as a round 
    {  
        //prompt user to have an input 
        PrintMenu(); 
        int PlayerChoice = reader.nextInt(); //reads user input
        
        //rand num = 2 since there are only 3 choices
        int ComputerChoice = RandNum(2); 
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

        } //if it is an invalid oepration, print it and tell them to do it again 
        System.out.println(" you have " + currentPoints + " points"); 

    }

    if (currentPoints <= 2)// if you have won the level 
    {
        System.out.println("You have won this level");
        if(HighestLevelUnlocked <= ClassLevel) 
        {
            System.out.println(" you have unlocked a new level!"); 
            HighestLevelUnlocked ++ ; //updates it 
        }

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
{   int RanNum = RandNum(3); // generates a random number and stores it, this is the computer's move 

//the sucess / fail descition matrix 

if (input == randNum) {                // tie
    // this is a tie, so you indcate it by the number two 
    return 2;
} 
else if ((input == 1) && (randNum == 2)) 
{  // Rock vs Paper => player wins
    return 1;
    
} 
else if ((input == 2) && (randNum == 1)) 
{  // Paper vs Rock => computer wins
    return 0;
} 
else if ((input == 2) && (randNum == 3))
 {  // Paper vs Scissors => player wins
    return 1;
} 
else if ((input == 3) && (randNum == 2)) 
{  // Scissors vs Paper => computer wins
    return 0;
} 
else if ((input == 3) && (randNum == 1)) 
{  // Scissors vs Rock => player wins
    return 1;
} 
else if ((input == 1) && (randNum == 3)) 
{  // Rock vs Scissors => computer wins
    return 0;
} 
 return 3; // a invalid operation 

}


}
