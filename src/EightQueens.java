public class EightQueens
{

    private static final int BOARD_SIZE = 8;
    private static final char QUEEN_SYMBOL = 'Q';
    private static final char EMPTY_SYMBOL = '-';

    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static int solutionCount = 0;

    public static void main(String[] args)
    {
        initializeBoard();
        placeQueens(0);
        System.out.println("Number of solutions: " + solutionCount);
    }

    private static void initializeBoard()
    {
        for (int row = 0; row < BOARD_SIZE; row++)
        {
            for (int col = 0; col < BOARD_SIZE; col++)
            {
                board[row][col] = EMPTY_SYMBOL;
            }
        }
    }

    private static void placeQueens(int row)
    {
        if (row == BOARD_SIZE)
        {
            solutionCount++;
            System.out.println("Solution " + solutionCount + ":");
            printBoard();
            return;
        }
        for (int col = 0; col < BOARD_SIZE; col++)
        {
            if (isValidPosition(row, col))
            {
                board[row][col] = QUEEN_SYMBOL;
                placeQueens(row + 1);
                board[row][col] = EMPTY_SYMBOL;
            }
        }
    }

    private static boolean isValidPosition(int row, int col)
    {
        for (int i = 0; i < row; i++)
        {
            if (board[i][col] == QUEEN_SYMBOL)
            {
                return false;
            }
            int colOffset = row - i;
            if (col - colOffset >= 0 && board[i][col - colOffset] == QUEEN_SYMBOL)
            {
                return false;
            }
            if (col + colOffset < BOARD_SIZE && board[i][col + colOffset] == QUEEN_SYMBOL)
            {
                return false;
            }
        }
        return true;
    }

    private static void printBoard()
    {
        for (int row = 0; row < BOARD_SIZE; row++)
        {
            for (int col = 0; col < BOARD_SIZE; col++)
            {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}