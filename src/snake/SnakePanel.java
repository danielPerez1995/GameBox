package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class SnakePanel extends JPanel{
     private SnakeBody snake;
     private SnakeObjective cherry;
     private Color snakeColor = Color.CYAN;
     private Color cherryColor = Color.RED;
     private int objSize = 10; 
     
    public SnakePanel(SnakeBody sn, SnakeObjective cher){
        snake = sn;
        cherry = cher;
    }
    
    public void setSnakeBod(SnakeBody snk){
        snake = snk;
    }
    
    public void setCherry(SnakeObjective cher){
        cherry =cher;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(0));
        g.fillRect(0, 0, 805, 700); 
        for(Point point : snake.getSnakeBody()){
            g.setColor(snakeColor);
            g.fillRect(point.x * objSize, point.y * objSize, objSize, objSize);
        }
        g.setColor(cherryColor);
        g.fillRect(cherry.getCherryX() * objSize, cherry.getCherryY() * objSize, objSize, objSize);

    }
}
