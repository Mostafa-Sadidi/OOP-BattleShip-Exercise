import java.util.Scanner;

public class Utils {

    /**
        The Method is taking the grid's size from user.
     */

    public int getGridSize (){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the size of the board (below 26): ");
        return input.nextInt();
    }

    /**
        The Method is for checking conditions that the ship can be placed in the direction.
     */

    public boolean canPlaceShip(char[][] grid, int row, int col, int shipSize, boolean horizontal, int gridSize) {
        if (horizontal) {
            if (row + (shipSize - 1) >= gridSize) {
                return false;
            }
            for (int i = 0; i < shipSize; i++) {
                if (grid[row + i][col] == 'S') {
                    return false;
                }
            }
        }
        else {
            if (col + (shipSize - 1) >= gridSize) {
                return false;
            }
            for (int i = 0; i < shipSize; i++) {
                if (grid[row][col + i] == 'S') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
        The Method is for checking the validation of the user's input.
     */

    public boolean isValidInput(String input, int size) {
        if (input.length() > 3 || input.length() < 2) {
            return false;
        }
        else if (size < 10 && input.length() != 2) {
            return false;
        }

        if ((input.charAt(0) < 'A' || (input.charAt(0) > (char)('A' + size - 1) && input.charAt(0) < 'a')) ||
                (input.charAt(0) > (char)('a' + size - 1))) {
            return false;
        }
        String strTemp = input.substring(1);
        for (int i = 0; i < strTemp.length(); i++) {
            if  (strTemp.charAt(i) < '0' || strTemp.charAt(i) > '9') {
                return false;
            }
        }
        int num = Integer.parseInt(strTemp);
        if ((num < 0 || num > (size - 1))) {
            return false;
        }
        return true;
    }

    /**
        The Method is for checking that all the ships has been sunk or not.
     */

    public boolean allShipsSunk(char[][] grid, int size) {
        int temp = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 'X') {
                    temp++;
                }
            }
        }
        if (temp == 14) {
            return true;
        }
        else {
            return false;
        }
    }
}
