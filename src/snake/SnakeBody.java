package snake;
import java.util.ArrayList;
import java.awt.Point;



public class SnakeBody {
    private ArrayList<Point> snakeBody  =  new ArrayList<Point>();
    private Point head;
    private int tailLength;
   
    
    public SnakeBody(){
        
        tailLength = 1;
        snakeBody.clear();
        head = new Point(0,0);
        for(int i = 0; i < tailLength; i++){
            snakeBody.add(new Point(head.x, head.y));
        }
    }
    
    public void resetSnakeBody(){
        tailLength = 1;
        snakeBody.clear();
        head = new Point(0,0);
        for(int i = 0; i < tailLength; i++){
            snakeBody.add(new Point(head.x, head.y));
        }
    }
    
    public ArrayList <Point> getSnakeBody(){
        return snakeBody;
    }
    public void addParts(){
        snakeBody.add(new Point(head.x, head.y));
    }
    
    public void increaseTail(){
        tailLength++;
    }
    
    public Point getHead(){
        return head;
    }
     public int getHeadX(){
        return head.x;
    }
     
    public int getHeadY(){
        return head.y;
    }
    
    public int getTailLength(){
        return tailLength;
    }
    

    public void up(){
        head = (new Point(head.x,head.y -1));
    }
    
    public void down(){
        head = (new Point(head.x,head.y +1));
    }
    
    public void left(){
        head = (new Point(head.x - 1,head.y));
    }
    
    public void right(){
        head = (new Point(head.x + 1,head.y));
    }
    public void remove(){
        snakeBody.remove(0);
    }
    
}
