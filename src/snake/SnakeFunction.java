package snake;

import java.awt.Point;



/**
 *
 * @author Daniel Perez
 */
public class SnakeFunction{
     private boolean over;
     private int ticks = 0, score = 0;
     private int [] directions = {0, 1, 2, 3};
     private int direction;
     private SnakeBody snakeBody;
     private SnakeObjective cherry;
     
     public SnakeFunction(SnakeBody snkB, SnakeObjective cher){
       cherry = cher;
       over = false;
       ticks = 0;
       score = 0;
       direction = directions[1];
       snakeBody = snkB;
      
     }
     
     public void addTicks(){
        ticks++;
     }
     
     public int getCurrentDirection(){
        return direction;
     }
     
     public int getDirection(int i){
         return directions[i];
     }
     
     public boolean getOver(){
         return over;
     }
     
     public int getTicks(){
         return ticks;
     }
     
     public void setCurrectDirection(int dir){
         direction = dir;
     }
     
     public void resetGame(SnakeBody snk, SnakeObjective cher){
        snakeBody = snk;
        cherry = cher;
        ticks = 0;
        over = false;
        score = 0; 
        direction = directions[1];
    }
      public void GameRunning(){
        int headY = snakeBody.getHeadY();
        int headX = snakeBody.getHeadX();
       
        if(direction == directions[0] ){
            if(headY - 1 >= 0 && noTail(headX, headY - 1))
                snakeBody.up();
            else
                 over = true;
        }
        
        if(direction == directions[1] ){
            if(headY + 1 < 66 && noTail(headX , headY + 1))
                snakeBody.down();
            else
                 over = true;
        }
        
        if(direction == directions[2] ){
           if(headX - 1 >= 0 && noTail(headX - 1, headY))
                snakeBody.left();
            else
                 over = true;
        }
        if(direction == directions[3]){
             if(headX + 1 < 79 && noTail(headX + 1, headY))
                snakeBody.right();
            else
                 over = true;
        }
         if(snakeBody.getSnakeBody().size() > snakeBody.getTailLength()){
            snakeBody.remove();
        }
         
        if(cherry.hitCherry(snakeBody.getHead()) == true){
            score+=10;
            System.out.println(score);
        }
         
    }
     
     public boolean noTail(int x, int y){
        boolean isTrue = true;
        for(Point point : snakeBody.getSnakeBody()){
            if(point.equals(new Point(x,y))){
                isTrue = false;
            }
        }
        return isTrue;
    }
     
    
   
}
