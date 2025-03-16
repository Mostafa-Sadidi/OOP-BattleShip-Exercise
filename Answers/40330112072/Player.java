public class Player {

    private String name;
    private Board board;
    private Board trackingBoard;

    public Player(String name, int size) {
        this.name = name;
        this.board = new Board(size);
        this.trackingBoard = new Board(size);
    }

    public String getName() {
        return name;
    }

    public Board getboard() {
        return board;
    }

    public Board getTrackingBoard() {
        return trackingBoard;
    }
}
