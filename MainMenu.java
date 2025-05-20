/* Program: Main menu 
    + arcades main menu that controls the other functions 
 
 */

import java.util.Scanner;

//import AllCode.HangMan; 

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
            System.out.println("1 - Hang-Man");
            System.out.println("2 - Rock-Paper-Gun");
            System.out.println("3 - Text Adventure");
            System.out.println("4 - Maze Game");
            System.out.println("5 - Tic-Tac-Toe");
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
                    Hangman HM = new Hangman(0,"",0);
                    HM.WelcomeScreen();
                    break;
                case 2: 
                    System.out.println("Rock-Paper-Gun chosen. Loading now...");
                    //call the method for the game here: 
                    initalLevel obj = new initalLevel();
                    obj.mainMenu();
                    break;
                case 3: 
                    System.out.println("Text-Adventure chosen. Loading now...");
                    //call the method for the game here: 
                    break;
                case 4: 
                    System.out.println("Maze game chosen. Loading now...");
                    //call the method for the game here: 
                        
                    System.out.println("➴➵➶➴➵➶➴➵➶➶-͙˚ ༘✶✄┈┈┈┈ Welome to the Maze Game-✄┈┈┈┈➶-͙˚ ༘✶➴➵➶➴➵➶➴➵➶");
                    System.out.println("Use W to go up\nUse A to go left\nUse S to go down\nUse D to go right");
                    System.out.println(" you are the letter Y and you need to go to the letter D to escape the maze\n");
                    Maze mazerun = new Maze(); 
                        mazerun.playLevel1();
                        mazerun.playLevel2();
            
                    System.out.println(" \nYou escaped both mazes you did it!!!!!");
                    break;
                case 5: 
                    System.out.println("Tic-Tac-Toe chosen. Loading now...");
                    //call the method for the game here: 
                    Scanner input = new Scanner(System.in);

                        System.out.println("Welcome to Tic Tac Toe!");

                        boolean continuePlay = true;

                        do {
                        TicTacToe game = new TicTacToe();
                        game.play(); 

                        System.out.println("Would you like to play another round? Enter 1 if yes, 0 if no.");

                        int answer = input.nextInt();

                        if (answer == 0) continuePlay = false;

                        } while (continuePlay);
                    break;
                default: 
                    System.out.println("error try again");
                    break; 

           }
            
        }
    }
    
}

