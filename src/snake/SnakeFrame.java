package snake;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class SnakeFrame extends javax.swing.JFrame implements ActionListener, KeyListener{
    private SnakePanel panel;
    private SnakeFunction snakeGame;
    private SnakeBody snakeParts;
    private SnakeObjective cherry;
    private int level;
    private boolean gameOn;
    private Dimension dim;
    private Timer timer = new Timer (20, this);;
   
    public SnakeFrame(){      
        snakeParts = new SnakeBody();
        cherry = new SnakeObjective(snakeParts);
        snakeGame = new SnakeFunction(snakeParts, cherry);
        panel = new SnakePanel(snakeParts, cherry);
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        gameOn = true;

    }
   
    public void setupFrame(){
        setVisible(true);
        setTitle("Snake");
        setSize(805,700);
        setResizable(false);
        setLocation(dim.width/2 -getWidth()/2, dim.height /2 - getHeight()/2);
        add(panel);
        addKeyListener(this);
        timer.start();
       
    }
    
    public void setLevel(int level){
        this.level = level;
    }
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i= e.getKeyCode();
        
        if(i == KeyEvent.VK_UP && snakeGame.getCurrentDirection() != snakeGame.getDirection(1)){
           snakeGame.setCurrectDirection(0);
          }
        if(i == KeyEvent.VK_DOWN && snakeGame.getCurrentDirection() != snakeGame.getDirection(0)){
            snakeGame.setCurrectDirection(1);
         
        }
        if(i == KeyEvent.VK_LEFT && snakeGame.getCurrentDirection() != snakeGame.getDirection(3)){
            snakeGame.setCurrectDirection(2);
        }
        if(i == KeyEvent.VK_RIGHT && snakeGame.getCurrentDirection() != snakeGame.getDirection(2)){
            snakeGame.setCurrectDirection(3);
        }
        if(i == KeyEvent.VK_SPACE){
            snakeParts.resetSnakeBody();
            cherry.resetSnakeObjective(snakeParts);
            snakeGame.resetGame(snakeParts, cherry);
            panel.setCherry(cherry);
            panel.setSnakeBod(snakeParts);
            snakeGame.GameRunning();
            timer.start();
            
        }
         
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(!isVisible()){
            gameOn =false;
        }
        if(gameOn == true){ 
            panel.repaint();
            //System.out.println(snakeGame.getTicks());
            snakeGame.addTicks();
            //System.out.println(snakeGame.getTicks());
            if(snakeGame.getTicks() % level== 0 && snakeParts.getHead() != null && snakeGame.getOver() != true){
                snakeParts.addParts();
                snakeGame.GameRunning();
            
            }
        }
    }
    
    
}
