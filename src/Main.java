
import java.util.*; // Import java utility wildcard (all util).

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game Tic, Tac, TOE!");   // Print a welcome message

        String again = "y";
        // Loop Restart.
        while(again.equals("y")) {    // This loop restarts the game.
            again = "n";

        // Import Classes.
        Board board = new Board();  // Getting class Board and put them in board variable
        Rules rules = new Rules();  // Getting class Rules -> rules


        // Board.
        board.generateBoard(board.gameBoard);  // generate the first empty board before while loop.


        // Loop until end of match.
        while (again.equals("n")) {    // Loops until game is over or variable = n

            // Player X.
            Scanner scan2 = new Scanner(System.in); // second scanner as a temp fix...
            Scanner scan = new Scanner(System.in); // New scanner named scan.
            System.out.println("Player X");
            int playerX = scan.nextInt(); // Scanner input from user
            while(rules.playerXPos.contains(playerX) || rules.PlayerOPos.contains(playerX)) { // Checking of the char/placement is full or not.
                System.out.println("Square already used! Pick another one."); // while gets triggered and ask to pick another slot.
                playerX = scan.nextInt(); // Scanner input again from user if they played a full box.
            }
            // Board.
            rules.playerSymbol(board.gameBoard, playerX, "PlayerX");  //Print board, playerX number gets placed in the "PlayerX" switch/case if elif.

            // Result.
            String reslut = Rules.finalResult(); // Using method finalResult and add that to result variable.
            if(reslut.length() > 0) {
                board.generateBoard(board.gameBoard);
                System.out.println(reslut);



                System.out.println("Again? press y or n");
                again = scan2.nextLine();
                break;   // End the loop/program
            }

            // Board
            board.generateBoard(board.gameBoard);  //Print/generate board from class Board.

            // Player O
            System.out.println("Player O:");
            int playerO = scan.nextInt();  //
            while(rules.playerXPos.contains(playerO) || rules.PlayerOPos.contains(playerO)) {
                System.out.println("Square already used! Pick another one.");
                playerO = scan.nextInt();
            }
            // Board.
            rules.playerSymbol(board.gameBoard, playerO, "PlayerO");
            // Board.
            board.generateBoard(board.gameBoard);

            // Result.
            reslut = Rules.finalResult();
            if(reslut.length() > 0) {
                board.generateBoard(board.gameBoard);
                System.out.println(reslut);



                System.out.println("Again? press y or n");
                again = scan2.nextLine();
                break;

                }
            }
        }
    }
}


