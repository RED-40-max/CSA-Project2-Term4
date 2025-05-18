public class SecretLevel extends Level3 {

    public SecretLevel() {
        this.ClassLevel = 4;
    }

    //an overrided method for the print menu 
    public void PrintMenu() {
    System.out.println("!!! Secret Level unlocked: includes Gun !!!");
        System.out.println("'Gun beats everyone and never loses.'");
    System.out.println("");
        System.out.println("""
            -----Options-----
            0 - Rock
            1 - Paper
            2 - Scissors
            3 - Fork
            4 - Spoon
            5 - Water
            6 - Fire
            7 - Gun
            enter play here:
            """);
    }

   //make ti so that computer cannot also acces the gun
   

    //override
    public int playRound(int input, int randNum) {
        // Player picks gun: auto-win
        if (input == 7) {
            return 1;
        }
        // Otherwise normal logic
        return super.playRound(input, randNum);
    }


    public void PlayLevel()
    {
        System.out.println("\n=== SECRET TRIAL: Beat Levels 1,2,3 in one go! ===");

        //making new objects so i can play the three diffrent rounds
        initalLevel lvl1 = new initalLevel(); 
        Level2 lvl2 = new Level2(); 
        Level3 lvl3 = new Level3(); 


        initalLevel[] levels = {lvl1,lvl2, lvl3 }; // an array of level objects i can call from 

        for (int LevelNum = 0; LevelNum < 3; LevelNum ++)
        {
            System.out.println("---Level " + (LevelNum + 1) + "/3 ----");
            int wins = 0; 
            for(int rounds= 0; rounds < 3; ) //to loop / play three rounds, if it is a tie, that dosn't count as a round so we leave the incrmeetn blank untill we can fully confomir
            { 
                initalLevel current = levels[rounds]; //makes it so that each round, there will be a diffrent object insinuated / used
                
                current.PrintMenu(); //prints the menu of that level 

                int randNum = current.RandNum(); //generates a random number based on the leve

                if (CheatMode) { //if it is cheat mode then it will say so and show the choice
                    System.out.println("[Cheat] Computer will play: " + PlayChoices[randNum]);
                }
    
                int input = current.reader.nextInt(); //gathers user input

                int result = current.playRound(input, randNum); //finds the result of the game based on what thing it is 
    
                if (result == 2) { //if there is a tie then you replay
                    System.out.println("Tie—replay this round.");
    
                } 
                else if (result == 1) { //if there is a round winning
                    System.out.println("You win this round!");
                    rounds++; //incremenest rouds becuse it switches to the next one, 
                    wins++; //adds to the wins
                } 
                else if (result == 0) { //if there is a loss, then there is nothing you can do. 
                    System.out.println("You lose this round.");
                    rounds++; //incremenst to the thing
                } 
                else {
                    System.out.println("Invalid choice—try again."); 
                } //makes you try again 
    

                System.out.printf("Score Overall:" + wins);
            }
    
            if (wins < 2) { // if there are less than two wins, you loose that level 
                System.out.printf("--- Failed Level"+ LevelNum +". Secret Trial failed. ---");
                return; 
            } else { //if there are more then two wins, then you win that level 
                System.out.printf("+++ Level "+ LevelNum +" Cleared!");
            }
        }
    
        // all three levels cleared!
        System.out.println("\n★★★ Congratulations! You have conquered the Secret Trial! ★★★");
        SecretLevelUnlocked = true; //makes it so you can acess gun 
        System.out.println("Gun unlocked! Now play with every option available:\n");
    
        // hand control back to the normal PlayLevel (with Gun enabled)
        super.PlayLevel();
    }
}
