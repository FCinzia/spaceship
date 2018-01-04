
/**
 
 * @author Cinzia Ferri
 * @version 1.0
 * @since 2016-10-26
 
 * Creates a Spaceship
 
 Algorythm:
 1) Create Window and body of spaceship
 2) Creade mouselistener and MouseMotionListener to make Spaceship follow cursor and shoot laser
 3) Call repaint
 4) Count number times laser has been shot
 5) Create a button and ButtonListener to reset count to zero
 
 */

import javax.swing.*;
import java.awt.*;

public class Spaceship
{
    //-----------------------------------------------------------------
    //  Creates panel and frame
    //-----------------------------------------------------------------
    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("Spaceship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpaceshipPanel panel = new SpaceshipPanel();
        frame.getContentPane().add(panel);
        
        frame.pack();
        frame.setVisible(true);
    }
}
