/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacMan;

import javax.swing.JFrame;

/**
 *
 * @author Tron
 */
public class PacmanFrame  extends javax.swing.JFrame  {
    
    public PacmanFrame(){
      Pacman game = new Pacman();
        add(game);
        pack();
        setResizable(false);
        setVisible(true);
        game.start();
    }
}
