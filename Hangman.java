import java.util.Scanner;
import java.util.Random; //importing all the stuff
public class Hangman {
	Scanner reader=new Scanner(System.in); //inizalizing everything
	Random random=new Random();
	StringBuilder Display=new StringBuilder(); //to able to change a specified chatacter in a string through a INDEX
	//Usually you cant do that without some complex substring-ing so Java has this built thing
	//that i spent too much time figuring out how it works :sob:

	public void WelcomeScreen() {
		System.out.println("✧⋄⋆⋅⋆⋄ Welcome to Hangman ⋄⋆⋅⋆⋄✧"); 
		System.out.println("Would you like to start a game? (1 - Yes, 2 - No)"); //Askign just incase user made typo
		int start=reader.nextInt(); //getting user input
		reader.nextLine(); //prevents error with skipping inputs with many nextInts and nextLines
		if (start==1) { //if user enters 1, start the game with the method
			StartGame();
		}
		else{
		    return; //go backs to main
		}
	}

	int LettersMissed; //constructor variables
	String Word;
	int WordLength;
	//massive list with all words that could be guessed
	String[] AllWords= {"Icecream","Burger","Programming","Geometry","Markers","Hangman","Donuts","Sticker","Arcade","iPhone","Computer","Lightbulb","Minecraft","Doors","Railroad","Conjuring","Fight"};
    
	public Hangman(int LettersMissed, String Word, int WordLength) { //constructor
		this.LettersMissed=LettersMissed;
		this.Word=Word;
		this.WordLength=WordLength;
	}

	public void StartGame() { //main method with EVERYTHING
		Display=new StringBuilder(); //uses Stringbuilder for a modified string for the display (_ _ _'s)
		int randomWord=random.nextInt(18); //getting random number from 0-17 from the list of words to get a random word
		Word=AllWords[randomWord];
		WordLength=Word.length(); //getting length of word to print out the _'s
		for (int x=0; x<WordLength; x++) { //prints out underscores
			Display.append("_ ");
		}

		String DisplayPRINT = Display.toString(); //converting display to string to be printed out
		
		//System.out.println(Word); //debugging
		System.out.println();
		System.out.println(DisplayPRINT); //prints the underscores for the first time
		System.out.println("The dashes above show the amount of letters there are in the choosen word! (◕ᴗ◕✿)");
		System.out.println("* . °•★ GAME STARTED ☆•° . * ");
		//* . °•★|•°∵ ∵°•|☆•° . *  
		while (LettersMissed!=6) { //runs until the player wins or player misses 6 times
		    
			System.out.println("Enter a letter to start guessing!");
			String Guess=reader.nextLine(); //gets user input on their guess

			if (Guess.length()==0) { //if they dont input anything, exit becasue you gotta INPUT SOMETHING!!!!!!!! (Also prevent error)
				System.out.println("You didn't type anything. Please enter a letter next time.");
				return;
			}
			char guessChar=Character.toLowerCase(Guess.charAt(0)); //gets the lower case of the guess
			boolean check=false; //set the check to false 
			for (int y=0; y<WordLength; y++) { //loops the same amount of times as the length of the word
				char wordChar=Character.toLowerCase(Word.charAt(y)); //gets the lower case of the word
				if (guessChar==wordChar) { //compares both lowercase which also compares upper and lower case for me. If they are same, continue
					
					int DisplayIndex=2*y; //so it skips through the spaces in _ _ _ to -> _(SPACE)_(SPACE)_
					                        //like the index will go 1,3,5 etc.
					Display.setCharAt(DisplayIndex, Word.charAt(y)); //Swaps the _ with the guessed letter
					System.out.println(Display);
					check=true; //changes check to true becasue it the letter was the same as the guess
				}
			}
			if (check){ //if check is TRUE
			    System.out.println("That.. IS a character in the word! The letter has been inputted below.");
			}
			else { //if not
				System.out.println("That.. is NOT a character in the word!");
				LettersMissed+=1; //add one to the total letters missed: if hits 6, loop ends and player LOSES
				System.out.println("You have "+(6-LettersMissed)+" times left to try!"); 
			}
			if (Display.indexOf("_") == -1) { //if no more "_", tell player they won
                System.out.println(" ݁₊ ⊹ . ݁˖ Congrats! You guessed the word: " + Word);
                break; //END LOOP, GO BACK TO MAIN
            }

		}
		if (LettersMissed==6){ //if letters missed hits 6, tell player they lost and go back to Main
		    System.out.println(" ݁₊ ⊹ . ݁˖ GAME OVER!! The word was: "+Word);
		    System.out.println(" ݁₊ ⊹ . ݁˖ Returning to the main screen. Loading now...");
		}
	}
	
}
