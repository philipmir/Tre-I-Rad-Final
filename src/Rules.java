
import java.util.*;

public class Rules {
    static ArrayList<Integer> playerXPos = new ArrayList<Integer>(); // Static ArrayList that can use Int?
    static ArrayList<Integer> PlayerOPos = new ArrayList<Integer>();

    public static void playerSymbol(char[][] gameBoard, int squarePosition, String user) {


        char symbol = ' ';     // Empty char for use in gameBoard that is char based.

        if (user.equals("PlayerX")) {
            symbol = 'X';
            playerXPos.add(squarePosition);  // symbol get placed is the switch -> gameBoard depending on what number user press.
        } else if (user.equals("PlayerO")) {
            symbol = 'O';
            PlayerOPos.add(squarePosition);
        }

        switch (squarePosition) {    // 2D Array positions via a switch.
            case 1:
                gameBoard[0][1] = symbol;    // Symbol = X or O depending on what player picking a spot.
                break;
            case 2:                          // [0][0] = first column fist row.
                gameBoard[0][3] = symbol;    // [0][1] = second column first row. jumping over char  '|' in gameBoard
                break;
            case 3:
                gameBoard[0][5] = symbol;
                break;
            case 4:
                gameBoard[2][1] = symbol;
                break;
            case 5:
                gameBoard[2][3] = symbol;
                break;
            case 6:
                gameBoard[2][5] = symbol;
                break;
            case 7:
                gameBoard[4][1] = symbol;
                break;
            case 8:
                gameBoard[4][3] = symbol;
                break;
            case 9:
                gameBoard[4][5] = symbol;
                break;
            default:
                break;
        }
    }

    public static String finalResult() {

        List crossA = Arrays.asList(1, 5, 9);   // Numbers that create a win
        List crossB = Arrays.asList(7, 5, 3);

        List leftColumn = Arrays.asList(1, 4, 7);
        List midColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List<List> win = new ArrayList<List>();   // List in list for loop checking winner.
        win.add(crossA);
        win.add(crossB);
        win.add(leftColumn);
        win.add(midColumn);
        win.add(rightColumn);
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);



        for (List l : win) {  // Looping through winning list for the occupied three in a row.
            if (playerXPos.containsAll(l)) {   // If PlayerX have any winning row/colum/cross full they win.
                PlayerOPos.clear();
                playerXPos.clear(); // Clear positions array for next game.
                return "Player X Won!";
            } else if (PlayerOPos.containsAll(l)) {
                PlayerOPos.clear();
                playerXPos.clear();
                return "Player O Won!";
            } else if (playerXPos.size() + PlayerOPos.size() == 9) {   // If both players have 9 occupied spaces and the board is full, it's a tie
                PlayerOPos.clear();
                playerXPos.clear();
                return "You both lost!";
            }
        }
        return "";
    }
}
