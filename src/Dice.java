import java.util.Random;

public class Dice {
    private final int MAX=6;
    public int getValue(){
        Random random=new Random();
        return random.nextInt(MAX)+1;
    }
}
