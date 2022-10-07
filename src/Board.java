public class Board {

    char[][] gameBoard =    {{'|',' ', '|', ' ', '|', ' ','|'},            // 2D Array   ' ' = empty char for use
                             {'|','_', '+', '_', '+', '_','|'},                // Column 1 and row 1 = [0][0]   the first position
                             {'|',' ', '|', ' ', '|', ' ','|'},                // Column 2 and row 2 = [1][1]   the next cross down
                             {'|','_', '+', '_', '+', '_','|'},                // Column 1 and row 2 = [1][0]   second row
                             {'|',' ', '|', ' ', '|', ' ','|'}};               // Column 2 and row 1 = [0][1]   second column
                                                                                // 7 columns and 5 row

    public static void generateBoard(char[][] gameBoard) {  // Print out board with a modern for loop.
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();  // new line
        }
    }
}

