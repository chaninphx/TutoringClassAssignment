
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
* Description: Companion.java
*      -Avater is animated 
* (Assignment number: Recitation 4 Part 2: Animations)
* Completion time: 28h 
* @author Vivian So, Chandler Cotton
* @version 1.0
*
* Description: Companion.java
*      -Renders the avatar into the JPanel in Universe.java
* (Assignment number: Recitation 4 Part 1:GUI)
* Completion time: 13h 48m
* @author Vivian So
* @version 1.0
*/
public class Companion extends JPanel
{   
    int status= 0;

    JPanel pan = new JPanel();;
    JLabel name = new JLabel("Vivian");

    //loading images
    BufferedImage happy =loadImage("happy");
    BufferedImage thinking = loadImage("thinking");
    BufferedImage worry = loadImage("worry");
    BufferedImage sorry = loadImage("sorry");

    //default start width and height
    final int defWid = happy.getWidth(null);
    final int defHeight = happy.getWidth(null);

    //variable that changes values for animation
    int picWidth = happy.getWidth(null);
    int picHeight = happy.getHeight(null);


    int delay = 100;

	Thread animation = new AnimationListener();

	//only repaints 30 times before resetting
    int animCount = 0;
	final int expandMax = 30;


    public Companion(){
		this.add(pan);
        pan.add(name);
        name.setText("<html><h1>Vivian So</h1></html>");
        animation.start();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Dimension size = getSize(); //width -255, height -62

        if(status==1){

            g2.drawImage(happy,
                0, 0, size.width, size.height,
                0, 0, picWidth, picHeight, null);
                pan.setVisible(false);
        }
        else if(status==2){
           // thinking = loadImage("thinking");
            g2.drawImage(thinking,
                0, 0, size.width, size.height,
                0, 0, picWidth, picHeight,
                null);
             pan.setVisible(false);
        }
        else if(status==3){
            //worry = loadImage("worry");
            g2.drawImage(worry,
                0, 0, size.width, size.height,
                0, 0, picWidth, picHeight,
                null);
             pan.setVisible(false);
        }
        else if(status==4){
            //sorry = loadImage("sorry");
            g2.drawImage(sorry,
                0, 0, size.width, size.height,
                0, 0, picWidth, picHeight,
                null);

            pan.setVisible(false);
        }
        else if(status==0){
          pan.setVisible(true);

        }
    }

    public void changeState(int state){
        status = state;
        animCount = expandMax + 1;  //get it to reset to beginning
        repaint(); //paintComponent
    }

    public Dimension getPreferredSize(){
        return new Dimension(200, 200);
    }
    private BufferedImage loadImage(String name) {

       String imgFileName = "../resources/"+name+".png";
       File file = new File(imgFileName);
       BufferedImage img = null;
            try {
                img =  ImageIO.read(file);

            } catch (Exception e) {
               e.printStackTrace();
               System.out.println("Image not found");
            }
        return img;

    }


    private class AnimationListener extends Thread
    {
		public void run()
		{
    		while(true)
            {    
            	try
                {
                    Thread.sleep(delay);
                }
                catch(Exception e){}

                if(animCount < expandMax)
    			{
    				picWidth = picWidth + 5;
    				picHeight = picHeight + 5;
    				animCount++;
    			}

    			else
    			{
    				picWidth = happy.getWidth(null);
                    picHeight = happy.getHeight(null);
                    animCount = 0;
    			}
    			repaint();
            }
		}
	}



}
