import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private final int size;

    Board(int size){
        this.size=size;
        snakes=new ArrayList<>();
        ladders=new ArrayList<>();
    }
    public List<Snake> getSnakes() {
        return snakes;
    }
    public List<Ladder> getLadders() {
        return ladders;
    }
    public void addLadder(int start,int end){
        ladders.add(new Ladder(start,end));
    }
    public void addSnakes(int start,int end){
        snakes.add(new Snake(start,end));
    }
    public int getSize(){
        return size;
    }

}
