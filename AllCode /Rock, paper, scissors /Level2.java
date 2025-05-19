/* Program: level 2 
    + add / unlock some new features, 
    + diffrent menu, and play round sequence 
    + adds fork and spoon to the mix, and barrows from lvl one since it is a subclass
 */

public class Level2 extends initalLevel
{

    public Level2() //a constructor so that the current level of this class is updated
    {
        this.ClassLevel = 2; //changes it to the second level of this class 
    }

    public void PrintMenu() 
    {
        
        //now it prints out spoon and fork 
        System.out.println(" ************************************************************"); 
        System.out.println("!!! level now contains 'fork' and 'spoon' !!!"); 
        System.out.println("'Fork beats: rock, paper \n and Fork is beaten by: rock, spoon "); 
        System.out.println("Spoon beats: fork, rock \n and Spoon is beaten by: paper, scissors"); 
        System.out.println(" ************************************************************"); 

        System.out.println("""
            .ೃ࿔*:･Options⋆.ೃ࿔*:･
                0 * Rock 
                1 * Paper
                2 * Scissors
                3 * Fork
                4 * Spoon
            °•* enter play here °•*⁀➷ 
            """);

    }

   
    //overrides the past method 
    public int playRound(int input, int randNum)
    {
        int FirstPass = super.playRound(input, randNum); 

        if (FirstPass != 3) // a ligitiment outcome
        {
            return FirstPass; //then return the outcome
        }
        else//if it dosn't make the first pass, then try to see if the other one is good
        {
            if ((input == 4) && (randNum == 0)) 
            {  // Spoon vs. Rock => Player wins
                return 1;
            } else if((input == 0) && (randNum == 4)) 
            { //Rock vs. Spoon => computer wins 
                return 0; 
            } else if ((input == 4) && (randNum == 1)) 
            { //Spoon vs. Paper => computer wins
                return 0;
            } else if ((input == 1) && (randNum == 4)) 
            { //Paper vs.Spoon => Player wins 
                return 1; 
            } else if ((input == 4) && (randNum == 2)) 
            { // Spoon vs. Scissors => Computer wins
                return 0; 
            } else if ((input == 2) && (randNum == 4)) 
            { //scizzors vs. spoon => player wins
                return 1; 
            } else if ((input == 4) && (randNum == 3)) 
            { //spoon vs. fork => player wins 
                return 1;
            } else if ((input == 3) && (randNum == 4)) 
            { //fork vs. spoon => computer wins 
                return 0;
            } else if (((input == 3) && (randNum == 0)) )
            { //fork vs. rock => computer wins 
                return 0; 
            } else if ((input == 0) && (randNum == 3)) 
            { //rock vs. fork => player wins 
                return 1; 
            } else if ((input == 3) && (randNum == 1)) 
            { //fork vs. paper => player wins
                return 1; 
            } else if ((input == 1) && (randNum == 3)) 
            { //paper vs. fork => computer wins 
                return 0; 
            } else if ((input == 3) && (randNum == 2)) 
            { //fork vs. scissors => player wins 
                return 1; 
            } else if ((input == 2) && (randNum == 3)) 
            {// scissors vs. fork => computer wins
                return 0; 
            } else {
                return 3; //invalid things 
            }

        } 
    }


}