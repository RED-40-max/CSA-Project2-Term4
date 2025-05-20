/* program: level 3
    + extends from level 2 
    adds fire and water in addition to the other stuff

 */ 


 public class Level3 extends Level2
 {
 
     public Level3() //a constructor so that the current level of this class is updated
     {
         this.ClassLevel = 3; //changes it to the second level of this class 
     }
 
     public void PrintMenu() 
     {
        System.out.println(" "); 
        System.out.println("*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚");
         System.out.println("!!! level now contains 'Water' and 'Fire' !!!"); 
         System.out.println("'Water beats: scissors, paper, fire \n and water is beaten by: rock, fork, spoon  "); 
         System.out.println("Fire beats: rock, fork, spoon  \n and Fire is beaten by: water, paper, scissors"); 
         System.out.println("*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚");
         System.out.println(" "); 
         System.out.println(" "); 
 
         System.out.println("""
             .ೃ࿔*:･Options⋆.ೃ࿔*:･
                0 * Rock 
                1 * Paper
                2 * Scissors
                3 * Fork
                4 * Spoon
                5 * Water
                6 * Fire 
             °•* enter play here °•*⁀➷ 
             """);
 
     }
     public int RandNum()
    { //min is always 0 (rock), and max is dependent on the level
        int max  = 6;
        int randomNumber = (int) (Math.random()* ((max -0)- 0 + 0) + 0); 
        return randomNumber; 
    }

    public int playRound(int input, int randNum)
    {
        int secondPass = super.playRound(input, randNum);

        if(secondPass != 3) //if the second pass is a ligit, then return it. 
        {
            return secondPass; 
        }
        else { //if combonation of operations not found in inital 2 passes, find it in this one
            if ((input == 5) && (randNum == 0)) 
            { //water vs. rock => computer wins
                return 0; 

            } else if((input == 0) && (randNum == 5)) 
            { //rock vs. water => Computer wins 
                return 1;
            } else if ((input == 5) && (randNum == 1)) 
            { //water vs. paper => player wins 
                return 1; 
            } else if ((input == 1) && (randNum == 5)) 
            { //paper vs. water => computer wins 
                return 0; 
            } else if ((input == 5) && (randNum == 2)) 
            { //water vs. scissors => player wins 
                return 1;
            } else if ((input == 2) && (randNum == 5)) 
            { //scissors vs. water => computer wins 
                return 0; 
            } else if ((input == 5) && (randNum == 3)) 
            { //water vs. fork => player wins 
                return 0;
            } else if ((input == 3) && (randNum == 5)) 
            { //fork vs. water => Computer wins 
                return 1; 
            } else if ((input == 5) && (randNum == 4)) 
            { //water vs. spoon => computer wins 
                return 0; 
            } else if ((input == 4) && (randNum == 5)) 
            { // spoon vs. water => player wins 
                return 1; 
            } else if ((input == 5) && (randNum == 6)) 
            { //water vs. fire => player wins
                return 1;  

            } else if ((input == 6) && (randNum == 5)) 
            { //fire vs. water => computer wins 
                return 0; 

            } else if (((input == 6) && (randNum == 0)) )
            { //fire vs. rock => player wins 
                return 1;

            } else if ((input == 0) && (randNum == 6)) 
            { //rock vs. fire => computer wins 
                return 0; 
            } else if ((input == 6) && (randNum == 1)) 
            { //fire vs. paper => computer wins 
                return 0; 

            } else if ((input == 1) && (randNum == 6)) 
            { // paper vs. fire => player wins 
                return 1; 
            }  else if ((input == 6) && (randNum == 2)) 
            { //fire vs. scissors => computer wins 
                return 0;

            } else if ((input == 2) && (randNum == 6)) 
            { //scissors vs. fire => player wins 
                return 1;

            } else if ((input == 6) && (randNum == 3)) 
            { //fire vs. fork => player wins 
                return 1;

            } else if ((input == 3) && (randNum == 6)) 
            { //fork vs. fire => computer wins 
                return 0;

            } else if ((input == 6) && (randNum == 4)) 
            { //fire vs. spoon => player wins 
                return 1;

            } else if ((input == 4) && (randNum == 6)) 
            { //spoon vs. fire => computer wins 
                return 0;
            } else {
                return 3; //otherwise it is an invalid thing
            }

        } 

 
    }

}
 