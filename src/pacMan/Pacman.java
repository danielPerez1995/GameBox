/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacMan;
 import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import static pacMan.Pacman.height;
/**
 *
 * @author Tron
 */
public class Pacman extends Canvas implements Runnable{

    public static final int width = 420;
    public static final int height = width/12 *9;
    public static final int scale = 2;
    public static final String title = "Pacman";
    private boolean running = false;
    private Thread thread;
    private final BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
  public synchronized void start(){
         if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
   public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try{
            thread.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.exit(1);
    }
    
    public void run(){
        long lastTime = System.nanoTime();
        double ticks = 60;
        double ns = 1000000000/ticks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        while(running){
            long now = System.nanoTime();
            delta+=(now - lastTime) /ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            long current = System.currentTimeMillis();
            if((current - timer) > 1000){
                timer += 1000;
                System.out.println(updates + " " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    public void tick(){
        
        
    }
    
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
                    
        }
        Graphics g =bs.getDrawGraphics();
        g.drawImage(img, 0 , 0 , getWidth(), getHeight(), this);
        g.dispose();
        bs.show();
        
    }
    
    public Pacman(){
        setPreferredSize(new Dimension (width * scale, height * scale));
        setMaximumSize(new Dimension (width * scale, height * scale));
        setMinimumSize(new Dimension (width * scale, height * scale));
        
        
    }
    
}
