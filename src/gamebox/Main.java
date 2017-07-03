/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamebox;
import tictactoe.TicTacToeMenuFrame;
import javax.swing.JFrame;
import java.awt.Color;

/**
 *
 * @author Tron
 */
public class Main {
    
    public static void main(String[] args){
        JFrame mainMenu = new ArcadeMenu();
        mainMenu.getContentPane().setBackground(new Color(150, 50, 150));
        mainMenu.setTitle("Main Menu");
        mainMenu.setSize(400, 400);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setResizable(false);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);
        
      
    }
}
