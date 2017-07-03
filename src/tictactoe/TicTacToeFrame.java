
package tictactoe;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicTacToeFrame extends JFrame
{
    private char turn = 'X';
    
    private Cell[][] cells = new Cell[3][3]; //Grid for the game
    
    JLabel labelStatus = new JLabel("X's turn to play"); //status of the game
    private JPanel panel = new JPanel(new GridLayout(3,3,0,0)); //will print the cells
    
    /*
        Sets up the board whole game
    */
    public TicTacToeFrame()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            { 
                panel.add(cells[i][j] = new Cell());
            }
        }
        
        panel.setBorder(new LineBorder(Color.cyan, 1));
        labelStatus.setBorder(new LineBorder(Color.black, 2));
        labelStatus.setFont (labelStatus.getFont ().deriveFont (20.0f));
        add(panel, BorderLayout.CENTER);
        add(labelStatus, BorderLayout.NORTH);
        
    }
    /*
        Check to see if the board is full
    */
    public boolean isFull()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            { 
                if(cells[i][j].getToken() == ' '){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isWon(char token)
    {
        //check rows
        for(int i = 0; i < 3; i++)
        {
            if(cells[i][0].getToken() == token && 
                    cells[i][1].getToken() == token &&
                    cells[i][2].getToken() == token)
            {
                System.out.println("row");
                return true;
            }
        }
        
        //check columns
        for(int i = 0; i < 3; i++)
        {
            if(cells[0][i].getToken() == token && 
                    cells[1][i].getToken() == token &&
                    cells[2][i].getToken() == token)
            {
                System.out.print("2");
                return true;
            }
        }
        
        if(cells[0][0].getToken() == token 
                && cells[1][1].getToken() == token 
                && cells[2][2].getToken() == token)
          {
              System.out.println("asd");
              return true;
          }
        
        if(cells[0][2].getToken() == token 
                && cells[1][1].getToken() == token 
                && cells[2][0].getToken() == token)
          {
              return true;
          }
        return false;
    }
    
public class Cell extends JPanel{
    private char token = ' ';
    
    public Cell()
    {
        setBorder(new LineBorder(Color.BLACK, 1));
        addMouseListener(new MouseListener());
    }
    
    public char getToken()
    {
        return token;
    }
    
    public void setToken(char c)
    {
        token = c;
        repaint();
    }
    
    protected void paintComponent(Graphics g)
    {
        BufferedImage Ximg = null, Oimg = null;
        
        try{
          Ximg = ImageIO.read(this.getClass().getResource("X.png"));
          Oimg = ImageIO.read(this.getClass().getResource("O.png"));
        
        }catch(Exception exc){
            exc.printStackTrace();
        }
            
        super.paintComponent(g);
        
        if(token == 'X')
        {
            g.drawImage(Ximg, WIDTH+ 1, WIDTH + 1, rootPane);
        }
        
        else if(token == 'O')
        {
            g.drawImage(Oimg, WIDTH, WIDTH, rootPane);
        }
    }
    
    private class MouseListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            
            if((token == ' ') && (turn != ' '))
            {
                setToken(turn);
            }
            
            if(isWon(turn))
            {
                labelStatus.setText(turn + " Won the Game");
            }
            
            else if (isFull())
            {
                labelStatus.setText("It's a Tie");
            }
            
            else
            {
                if(token== 'X' && getToken()== 'X' ){
                    turn = 'O';
                    labelStatus.setText(turn + "'s turn");
                }
                else if(token == 'O' && getToken() == 'O' ){
                    turn = 'X';
                    labelStatus.setText(turn + "'s turn");
                }
            }   
        }
    }
   } 
}
