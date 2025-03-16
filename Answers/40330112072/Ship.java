import java.util.Random;
import java.util.Scanner;

public class Ship {
    Utils utils = new Utils();

    /**
        The Method is for placing the ships randomly.
     */

    public void placeShipsRandom (char[][] grid, int size) {
        for(int i = 2; i <= 5 ; i++){
            Random random = new Random();
            boolean isPlaced = false;
            while(!isPlaced){
                int row = random.nextInt(size);
                int col = random.nextInt(size);
                boolean horizontal = random.nextBoolean();
                if(utils.canPlaceShip(grid, row, col, i, horizontal, size)){
                    for(int j = 0; j < i; j++){
                        if(horizontal){
                            grid[row + j][col] = 'S';
                        }
                        else {
                            grid[row][col + j] = 'S';
                        }
                    }
                    isPlaced = true;
                }
            }
        }
    }

    /**
        The Method is for placing the ships with taking by user.
     */

    public void placeShipByUser (char[][] grid, int size) {
        Board board = new Board(size);
        for(int i = 2; i <= 5 ; i++){
            Scanner strScanner = new Scanner(System.in);
            Scanner inputScanner = new Scanner(System.in);
            boolean isPlaced = false;
            while(!isPlaced){
                String orientation;
                int row , col;
                board.printGrid(grid, size);
                System.out.print("Enter coordinates for ship with size of " + i + " (for example A1): ");
                String input = strScanner.nextLine();
                if (!(utils.isValidInput(input, size))) {
                    System.out.println("Invalid input! Please try again.");
                    continue;
                }
                else {
                    Coordinate coordinate = new Coordinate(input.charAt(0), input.substring(1), size);
                    row = coordinate.getY();
                    col = coordinate.getX();
                }
                do {
                    System.out.print("Enter the orientation of ship with size of " + i + " (horizontal or vertical): ");
                    orientation = inputScanner.nextLine();
                    if (!orientation.equalsIgnoreCase("horizontal") &&
                            !orientation.equalsIgnoreCase("vertical")) {
                        System.out.println("Invalid orientation. Please try again.");
                    }
                } while (!orientation.equalsIgnoreCase("horizontal") &&
                        !orientation.equalsIgnoreCase("vertical"));

                boolean horizontal = orientation.equalsIgnoreCase("horizontal");
                if(utils.canPlaceShip(grid, row, col, i, horizontal, size)){
                    for(int j = 0; j < i; j++){
                        if(horizontal){
                            grid[row + j][col] = 'S';
                        }
                        else {
                            grid[row][col + j] = 'S';
                        }
                    }
                    isPlaced = true;
                }
                else {
                    System.out.println("We can't place " + orientation + " ship with size of " + i + " here!");
                    System.out.println("Please try again!");
                }
            }
        }
        board.printGrid(grid, size);
    }
}
