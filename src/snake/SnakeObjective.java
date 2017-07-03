package snake;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Daniel Perez
 */
public class SnakeObjective {
     private int maxPosition = 60;
     private Point cherry;
     private Random rnd;
     private SnakeBody snakeBody;
  
     
     public SnakeObjective(SnakeBody snkB){
        snakeBody = snkB;
        rnd = new Random();
        cherry = new Point(rnd.nextInt(maxPosition), rnd.nextInt(maxPosition));
     }
     
     public void resetSnakeObjective(SnakeBody snkB){
         snakeBody = snkB;
        rnd = new Random();
        cherry = new Point(rnd.nextInt(maxPosition), rnd.nextInt(maxPosition));
     }
     
     public int getCherryX(){
         return cherry.x;
     }
     
     public int getCherryY(){
         return cherry.y;
     }
     
     public void setCherryLocation(){
         cherry.setLocation( rnd.nextInt(maxPosition), rnd.nextInt(maxPosition));
     }
     
     public boolean hitCherry(Point head){
        boolean isTrue = false;
        if(cherry != null){
            if(head.equals(cherry)){
                isTrue = true;
                snakeBody.increaseTail();
                setCherryLocation();
            }
        }
        return isTrue;
    }
}
