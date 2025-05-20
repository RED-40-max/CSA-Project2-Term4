/* program: secret level 
    + extends from level 3
    + beat level 1, level 2, and level 3, in order, wihtout losses to unlock NERF gun 

 */ 

public class SecretLevel extends Level3 {

    public SecretLevel() {
        this.ClassLevel = 4;
    }

    //an overrided method for the print menu 
    public void PrintMenu() {
        System.out.println("");
        System.out.println("*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚");
    System.out.println("!!! Secret Level unlocked: includes Gun !!!");
        System.out.println("'NERF Gun beats everyone and never loses.'");
        System.out.println("*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚");
        System.out.println("");
         System.out.println("");

         System.out.println("""
             .ೃ࿔*:･Options⋆.ೃ࿔*:･
                0 * Rock 
                1 * Paper
                2 * Scissors
                3 * Fork
                4 * Spoon
                5 * Water
                6 * Fire 
                7 - NERF gun
             °•* enter play here °•*⁀➷ 
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
        System.out.println("*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚");
        System.out.println("\n=== SECRET TRIAL: Beat Levels 1,2,3 in one go! ===");
        System.out.println("");

        //making new objects so i can play the three diffrent rounds
        initalLevel lvl1 = new initalLevel(); 
        Level2 lvl2 = new Level2(); 
        Level3 lvl3 = new Level3(); 


        initalLevel[] levels = {lvl1,lvl2, lvl3 }; // an array of level objects i can call from 

        for (int LevelNum = 0; LevelNum < 3; LevelNum ++)
        {
            System.out.println("");
            System.out.println("---Level " + (LevelNum + 1) + "/3 ----");
            System.out.println("");
            int wins = 0; 
            for(int rounds= 0; rounds < 3; ) //to loop / play three rounds, if it is a tie, that dosn't count as a round so we leave the incrmeetn blank untill we can fully confomir
            { 
                initalLevel current = levels[LevelNum]; //makes it so that each round, there will be a diffrent object insinuated / used
                
                current.PrintMenu(); //prints the menu of that level 

                int randNum = current.RandNum(); //generates a random number based on the leve

                if (CheatMode) { //if it is cheat mode then it will say so and show the choice
                    System.out.println("");
                    System.out.println("[Cheat] Computer will play: " + PlayChoices[randNum]);
                    System.out.println("");
                }
    
                int input = current.reader.nextInt(); //gathers user input

                int result = current.playRound(input, randNum); //finds the result of the game based on what thing it is 
    
                if (result == 2) { //if there is a tie then you replay
                    System.out.println("");
                    System.out.println("🎀🎀 Tie—replay this round .🎀🎀");
                    System.out.println("");
    
                } 
                else if (result == 1) { //if there is a round winning
                    System.out.println("");
                    System.out.println("🎯🎯 You win this round! 🎯🎯 ");
                    System.out.println("");
                    rounds++; //incremenest rouds becuse it switches to the next one, 
                    wins++; //adds to the wins
                } 
                else if (result == 0) { //if there is a loss, then there is nothing you can do. 
                    System.out.println("");
                    System.out.println("⛔⛔You lose this round.⛔⛔");
                    System.out.println("");
                    rounds++; //incremenst to the thing
                } 
                else {
                    System.out.println("");
                    System.out.println("Invalid choice—try again."); 
                    System.out.println("");
                } //makes you try again 
    
                System.out.println("");
                System.out.println("Score Overall:" + wins);
                System.out.println("");
            }

    
            if (wins < 2) { // if there are less than two wins, you loose that level 
                System.out.println("");
                System.out.println("--- Failed Level"+ (LevelNum + 1) +". Secret Trial failed. ---");
                System.out.println("");
                return; 
            } else { //if there are more then two wins, then you win that level 
                System.out.println("");
                System.out.println("+++ Level "+ (LevelNum + 1) +" Cleared! +++");
                System.out.println("");
            }
        }
    
        // all three levels cleared!
        System.out.println("");
        System.out.println("*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚");
        System.out.println("✧｡٩(ˊᗜˋ )و✧*｡ \n★★★ Congratulations! You have conquered the Secret Trial! ★★★");
        System.out.println("");
        SecretLevelUnlocked = true; //makes it so you can acess gun 
        System.out.println("*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚");

        System.out.println(" 🔫 NERF Gun unlocked! \n Now play with every option available:\n");
        System.out.println("");
    
        // hand control back to the normal PlayLevel (with Gun enabled)
        super.PlayLevel();
    }
}
