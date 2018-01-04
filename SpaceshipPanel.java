
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
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;



public class SpaceshipPanel extends JPanel
{
    private int count, mouseX, mouseY, point1, point2, spaceshipX, spaceshipY, color;
    private JButton reset;
    private JLabel label;
    private Point clickPoint = null;    // Boolean flag for mouse clicked

    
    public SpaceshipPanel()
    {
        setPreferredSize(new Dimension(500,400));
        setBackground (Color.blue);
    
        //------------------------------------------------------------
        // Create and add a Mouse Listener and Motion Listener
        //------------------------------------------------------------
        
        
        addMouseListener (new SpaceshipListener());
        addMouseMotionListener(new MListener());

        
        //--------------------------------------------------------------------
        // Creates a Button to reset number of shots to 0, and buttonListener
        //--------------------------------------------------------------------
        reset = new JButton ("Reset");
        reset.addActionListener (new ButtonListener());
        
        //------------------------------------------------------------
        // Creates a label that outputs the number of shots
        //------------------------------------------------------------
        
        label = new JLabel ("Shots: " + count);
        
        label.setForeground(Color.pink);
        
        add (reset);
        add (label);

    }


    //*****************************************************************
    //  Represents the listener for button events.
    //*****************************************************************
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            count = 0;
            label.setText("Shots: " + count);
        }
    }
    
    
    //*****************************************************************
    //  Represents the listener for mouse events.
    //*****************************************************************
    public class SpaceshipListener implements MouseListener
    {
        
        //--------------------------------------------------------------
        //  Redraws
        //  the panel whenever the mouse button is pressed.
        //--------------------------------------------------------------
        public void mousePressed (MouseEvent event)
        {
            clickPoint = event.getPoint();
            repaint();
        }
        
        public void mouseClicked (MouseEvent event)
        {
            //------------------------------------------------------------
            // Creates end points for laser beam
            //------------------------------------------------------------
            
            Random generator = new Random();
            
            point1 = generator.nextInt(450) + 20;
            point2 = generator.nextInt(350) + 20;
            
            count++;
            label.setText("Shots: " + count);

        }
        
        
        public void mouseEntered (MouseEvent event)
        {
            spaceshipX = event.getX();
            spaceshipY = event.getY();
            repaint();
        
        }


        //--------------------------------------------------------------
        //  Empty definitions for unused event methods.
        //--------------------------------------------------------------
        public void mouseReleased (MouseEvent event) {}
        public void mouseExited (MouseEvent event) {}

    }
    
    //*****************************************************************
    //  Represents the motion listener for mouse events.
    //*****************************************************************
    
    public class MListener implements MouseMotionListener
    {
        
        public void mouseMoved(MouseEvent event)
        {
            spaceshipX = event.getX();
            spaceshipY = event.getY();
            clickPoint = null;
            repaint();
        }
        
        //--------------------------------------------------------------
        //  Empty definitions for unused event methods.
        //--------------------------------------------------------------
        
        public void mouseDragged (MouseEvent event){}

    }
    
    public void paintComponent (Graphics page)
    {
        super.paintComponent(page);
        
        //--------------------------------------------------------------
        //  Draws Spaceship
        //--------------------------------------------------------------
        
        page.setColor (Color.yellow);
        page.fillArc (spaceshipX, spaceshipY, 40, 30, 0, 180);
        spaceshipX = spaceshipX - 10;
        spaceshipY = spaceshipY + 10;
        page.setColor (Color.pink);
        page.fillOval(spaceshipX,spaceshipY, 60,25);
        
        //--------------------------------------------------------------
        //  When mouse clicked draws a line with random colors
        //--------------------------------------------------------------
        
        if (clickPoint != null)
        {
            Random generator = new Random();
            
            color = generator.nextInt(8)+1;
            
            switch (color)
            {
                case 1 : page.setColor (Color.white);
                    break;
                case 2 : page.setColor (Color.cyan);
                    break;
                case 3 : page.setColor (Color.magenta);
                    break;
                case 4 : page.setColor (Color.orange);
                    break;
                case 5 : page.setColor (Color.pink);
                    break;
                case 6 : page.setColor (Color.red);
                    break;
                case 7 : page.setColor (Color.yellow);
                    break;
                case 8 : page.setColor (Color.green);
                    break;
                    
            }
            
            page.drawLine(spaceshipX +20, spaceshipY, point1, point2);
        }
    }

}



