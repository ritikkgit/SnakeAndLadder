import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Select Game size. Enter the Game Size:");
        int size=sc.nextInt();
        Game game=new Game(size);

        Board board=game.getBoard();
        board.addLadder(10,22);
        board.addLadder(10,22);
        board.addLadder(14,72);
        board.addLadder(18,99);
        board.addLadder(55,90);
        board.addLadder(4,100);
        board.addLadder(8,100);

        board.addSnakes(20,8);
        board.addSnakes(6,1);
        board.addSnakes(88,8);
        board.addSnakes(33,9);
        board.addSnakes(49,22);


        game.addPlayers(new Player("Ritik"));
        game.addPlayers(new Player("Nihit"));
        game.run();
    }
}