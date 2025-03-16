import java.util.Scanner;

public class Board {

    Utils utils = new Utils();
    private char[][] grid;

    public Board(int size) {
        this.grid = new char[size][size];
        initializeGrid(this.grid, size);
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
        The Method is for initializing the grid with '~' char.
     */

    public void initializeGrid(char[][] grid, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '~';
            }
        }
    }

    /**
        The Method is for printing the grid.
     */

    public void printGrid(char[][] grid, int size) {
        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.print((char) (i + 65) + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            if (i >= 10){
                System.out.print(i + " ");
            }
            else {
                System.out.print(" " + i + " ");
            }
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}