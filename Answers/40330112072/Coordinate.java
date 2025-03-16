public class Coordinate {
    private int x;
    private int y;

    public Coordinate(char x, String y, int size) {
        if (x >= 'A' && x <= (char)('A' + size - 1)) {
            this.x = x - 'A';
        }
        else if (x >= 'a' && x <= (char)('a' + size - 1)) {
            this.x = x - 'a';
        }
            this.y = (Integer.parseInt(y));
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


}
