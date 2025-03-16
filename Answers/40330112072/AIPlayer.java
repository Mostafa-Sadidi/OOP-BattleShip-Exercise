import java.util.Random;
public class AIPlayer extends Player {
    public AIPlayer(String name, int size) {
        super(name, size);
    }
    public String makeMove(int size) {
        Random rand = new Random();
        return "" + (char)('A' + rand.nextInt(size)) + rand.nextInt(size);
    }
}
