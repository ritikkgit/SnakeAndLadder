import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private Dice dice;
    private int size;
    Game(int size){
        this.size=size;
        init();
    }
    public Board getBoard(){
        return board;
    }
    void init(){
        board=new Board(size);
        players=new ArrayList<>();
        dice=new Dice();
    }
    void addPlayers(Player player){
        players.add(player);
    }
    void run(){
        boolean flag=true;
        while(true){

            for(int i=0;i<players.size();i++) {
                System.out.println("--------------");
                Player currentPlayer = players.get(i);
                int currentPos=currentPlayer.getCurrentPosition();
                System.out.println("Player Name: " + currentPlayer.getName()+" at: "+currentPos);
                while(true){
                    System.out.println("Press Y to throw dice : ");
                    Scanner sc=new Scanner(System.in);
                    String s=sc.nextLine();
                    if(s.equals("Y")||s.equals("y")){
                        int diceValue=dice.getValue();
                        System.out.println("DICE VALUE:"+diceValue);
                        if(currentPos+diceValue<=board.getSize())
                            currentPos+=diceValue;
                        currentPos=checkSnakes(board.getSnakes(),currentPos);
                        currentPos=checkLadders(board.getLadders(),currentPos);
                        currentPlayer.setCurrentPosition(currentPos);
                        System.out.println("Player Name: " + currentPlayer.getName()+" at: "+currentPos);
                        System.out.println("--------------");
                        break;
                    }else{
                        System.out.println("Invalid Input. Please Enter Y to throw DICE : ");
                    }
                }



                if(currentPos== board.getSize()){
                    System.out.println("Winner "+currentPlayer.getName());
                    System.exit(0);
                }
            }

        }
    }

    private int checkLadders(List<Ladder> ladders, int currentPos) {
        for(Ladder ladder:ladders){
            if(ladder.getEnd()==currentPos){
                System.out.println("Ladder Found"+ladder.getStart()+" "+ladder.getEnd());
                return ladder.getStart();
            }
        }
        return currentPos;
    }

    private int checkSnakes(List<Snake> snakes, int currentPos) {
        for(Snake snake:snakes){
            if(snake.getStart()==currentPos){
                System.out.println("Snake Found"+snake.getStart()+" "+snake.getEnd());
                return snake.getEnd();
            }
        }
        return currentPos;
    }
}
