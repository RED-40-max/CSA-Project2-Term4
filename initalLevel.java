/* Program: inital level 
    + level one of the RPS game 

contains: 
    + class variables 
    + if the player is winning at any given moment

 */

public class initalLevel {

    //static so i can track throught the 
    public static int HighestLevelUnlcoked = 0; //so i can track throught the game 
    public static boolean PlayerWins; //so i can track the wins / losses 
    public static boolean IsTie = false; //to track if there was a tie
    public static String[] PlayChoices = {"Rock","Paper", "Scissors", "Fork", "Spoon", "Fire", "Water", "Gun"}; 
    

public void mainMenu() //all other methods within intital level are tiered here, + leverage for other called methods 
{ 
    //basic intro for the level number selection 
    // loops thorught three rounds and checks for unlock and whatever 


}

//method that generates a random number based on the max that it gives 
public int RandNum(int max)
{ //min is always 0 (rock), and max is dependent on the level
    int randomNumber = (int) (Math.random()* ((max -1)- 0 + 1) + 0); 
    return randomNumber; 
}

public void PlayLevel() 
{

    int currentPoints = 0; 


}

public void playRound(int input, int randNum) //input is player input
{   int RanNum = RandNum(3); // generates a random number and stores it, this is the computer's move 

//the sucess / fail descition matrix 

if (input == randNum) {                // tie
    // this is a tie, so don't do anything else
    IsTie = true;
} else if ((input == 1) && (randNum == 2)) 
{  // Rock vs Paper => player wins
    PlayerWins = true;
    
} else if ((input == 2) && (randNum == 1)) 
{  // Paper vs Rock => computer wins
    PlayerWins = false;
} 
else if ((input == 2) && (randNum == 3))
 {  // Paper vs Scissors => player wins
    PlayerWins = true;
} 
else if ((input == 3) && (randNum == 2)) 
{  // Scissors vs Paper => computer wins
    PlayerWins = false;
} 
else if ((input == 3) && (randNum == 1)) 
{  // Scissors vs Rock => player wins
    PlayerWins = true;
} 
else if ((input == 1) && (randNum == 3)) 
{  // Rock vs Scissors => computer wins
    PlayerWins = false;
} 
 


}


}
