public class Player {
    private String name;
    private int currentPosition;
    Player(String name){
        this.name=name;
        this.currentPosition=1;
    }
    public void setCurrentPosition(int position){
        currentPosition=position;
    }
    public  int getCurrentPosition(){
        return currentPosition;
    }
    public String getName(){
        return name;
    }

}
