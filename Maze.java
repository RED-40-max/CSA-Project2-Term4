import java.util.Scanner;

public class Maze {

    static char[][] maze;
    static int playerRow;
    static int playerCol;
    static Scanner reader = new Scanner(System.in);

//     public static void main(String[] args) {
//         System.out.println("➴➵➶➴➵➶➴➵➶➶-͙˚ ༘✶✄┈┈┈┈ Welome to the Maze Game-✄┈┈┈┈➶-͙˚ ༘✶➴➵➶➴➵➶➴➵➶");
//         System.out.println("Use W to go up\nUse A to go left\nUse S to go down\nUse D to go right");
// System.out.println(" you are the letter Y and you need to go to the letter D to escape the maze\n");
//         playLevel1();
//         playLevel2();

//         System.out.println(" \nYou escaped both mazes you did it!!!!!");
//         reader.close();
//     }

   /// the first lele 
    public static void playLevel1() {
        maze = new char[][]{//Char 2d array USED FOR HELP --https://www.geeksforgeeks.org/different-ways-to-declare-and-initialize-2-d-array-in-java/
            {'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'Y', ' ', ' ', ' ', 'W', 'W'},
            {'W', 'W', 'W', ' ', 'W', ' ', 'W'},
            {'W', ' ', 'M', ' ', ' ', ' ', 'W'},
            {'W', ' ', 'W', 'W', 'W', ' ', 'W'},
            {'W', 'D', ' ', ' ', ' ', ' ', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };
        playerRow = 1;
        playerCol = 1;

        System.out.println("level 1 ->Small Maze");
        runMaze();//Call run maze
    }

    ////hte seocng lelvel
    public static void playLevel2() {
        maze = new char[][]{//USED https://www.geeksforgeeks.org/different-ways-to-declare-and-initialize-2-d-array-in-java/
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'Y', ' ', ' ', 'W', ' ', 'W', 'D', 'W'},
            {'W', 'W', 'W', ' ', 'W', ' ', 'W', ' ', 'W'},
            {'W', ' ', 'W', ' ', ' ', ' ', 'W', ' ', 'W'},
            {'W', ' ', 'W', 'W', 'W', ' ', ' ', ' ', 'W'},
            {'W', ' ', ' ', ' ', 'W', ' ', ' ', ' ', 'W'},
            {'W', 'W', 'W', ' ', 'W', 'W', 'W', ' ', 'W'},
            {'W', ' ', ' ', ' ', ' ', ' ', 'W', ' ', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };
        playerRow = 1;
        playerCol = 1;

        System.out.println("\n Level 2 -> THE Big Maze");
        runMaze();
    }

    // this is so the game can run
    public static void runMaze() {//method 
        char currentPosition = maze[playerRow][playerCol];//current pos of where you are
        while (currentPosition != 'D') {
            drawMaze();//call the draw maze method
            System.out.print("Move using your keys");
            String input = reader.nextLine().toUpperCase(); //convergts lowercase letter to upper USED https://www.w3schools.com/jsref/jsref_touppercase.asp

            if (input.length() == 0)
                continue; //I knew break pretty well but USED THSI FOR CONTINUE https://www.w3schools.com/java/java_break.asp

            movePlayer(input.charAt(0));//RETURNS A CHRARATER AT A INDEX OF STRING USED https://www.w3schools.com/java/ref_string_charat.asp
            currentPosition = maze[playerRow][playerCol];
            
            if (currentPosition == 'D') {
                drawMaze();//CALL THE DRAW MAZE METHOD
                System.out.println(" You escaped the maze\n");
            }
        }
    }

   // THIS IS TO deaw the maze
    public static void drawMaze() {
        System.out.println();
        //NESTED FOR LOOP 
        for (int X = 0; X < maze.length; X++) {
            for (int Y = 0; Y < maze[X].length; Y++) {
                if (maze[X][Y] == 'W') {
                    // to make it loiok nice put edges as `-`, and insides as `|`
                    if (X == 0 || X == maze.length - 1) {
                        System.out.print("- ");
                    } else {
                        System.out.print("| ");
                    }
                } else {
                    System.out.print(maze[X][Y] + " ");
                }
            }
            System.out.println();
        }
    }

    // this is to move the plaete in the direction
    public static void movePlayer(char direction) {
        int newRow = playerRow;
        int newCol = playerCol;
        // this is to mpce the player one at at time becsue of the break statemtns
        switch (direction) {
            case 'W': newRow--; 
                break;
            case 'A': newCol--;
                break;
            case 'S': newRow++; 
                break;
            case 'D': newCol++;
                break;
            default:
                System.out.println("Invalid okay so use W, A, S, or D.");
                return;
        }

        // Check if boundared are not hit
        if (newRow >= 0 && newRow < maze.length &&
            newCol >= 0 && newCol < maze[0].length &&
            maze[newRow][newCol] != 'W') {

            // Checkl to see if it is M 
            if (maze[newRow][newCol] == 'M') {
                maze[playerRow][playerCol] = ' ';
                playerRow = 1;
                playerCol = 1;
                maze[playerRow][playerCol] = 'Y';
                System.out.println(" OH NOO. You got MURDERED Back to start");
                return;
            }

            // Move the playetr while not hiting Doors
            if (maze[playerRow][playerCol] != 'D') {
                maze[playerRow][playerCol] = ' ';
            }
            playerRow = newRow;
            playerCol = newCol;

            if (maze[playerRow][playerCol] != 'D') {
                maze[playerRow][playerCol] = 'Y';
            }

        } else {
            System.out.println("You just hit a wall do better");
        }
    }
}
