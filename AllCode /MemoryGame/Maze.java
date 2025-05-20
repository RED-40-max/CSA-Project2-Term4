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
        maze = new char[][]{
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

        System.out.println("level 1 - Small Maze");
        runMaze();
    }

    ////hte seocng lelvel
    public static void playLevel2() {
        maze = new char[][]{
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'Y', ' ', ' ', 'W', ' ', 'W', 'D', 'W'},
            {'W', 'W', 'W', ' ', 'W', ' ', 'W', 'W', 'W'},
            {'W', ' ', 'W', ' ', ' ', ' ', 'W', ' ', 'W'},
            {'W', ' ', 'W', 'W', 'W', ' ', 'W', ' ', 'W'},
            {'W', ' ', ' ', ' ', 'W', ' ', ' ', ' ', 'W'},
            {'W', 'W', 'W', ' ', 'W', 'W', 'W', ' ', 'W'},
            {'W', ' ', ' ', ' ', ' ', ' ', 'W', ' ', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}
        };
        playerRow = 1;
        playerCol = 1;

        System.out.println("\n Level 2 - THE Big Maze");
        runMaze();
    }

    // this is so the game can run
    public static void runMaze() {
        char currentPosition = maze[playerRow][playerCol];
        while (currentPosition != 'D') {
            drawMaze();
            System.out.print("Move ");
            String input = reader.nextLine().toUpperCase();

            if (input.length() == 0) continue;

            movePlayer(input.charAt(0));
            currentPosition = maze[playerRow][playerCol];
            
            if (currentPosition == 'D') {
                drawMaze();
                System.out.println(" You escaped the maze!\n");
            }
        }
    }

   // THIS IS TO deaw the maze
    public static void drawMaze() {
        System.out.println();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'W') {
                    // to make it loiok nice put edges as `-`, and insides as `|`
                    if (i == 0 || i == maze.length - 1) {
                        System.out.print("- ");
                    } else {
                        System.out.print("| ");
                    }
                } else {
                    System.out.print(maze[i][j] + " ");
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

            // Move the playetr
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
