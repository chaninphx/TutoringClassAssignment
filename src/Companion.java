package project_git.src;


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

/**
* Description: Companion.java
*      -Renders the avatar into the JPanel in Universe.java
* (Assignment number: Recitation 4 Part 1:GUI)
* Completion time: 13h 48m
* @author Vivian So
* @version 1.0
*/
public class Companion extends JPanel
{   int status= 0;

    JPanel pan = new JPanel();;
    JLabel name = new JLabel("Vivian");
  
    BufferedImage happy =loadImage("happy");
    BufferedImage thinking = loadImage("thinking");
    BufferedImage worry = loadImage("worry");
    BufferedImage sorry = loadImage("sorry");
    
    public Companion(){
        this.add(pan);
        pan.add(name);
        name.setText("<html><h1>Vivian So</h1></html>");
       // name.setBounds(0, 20, 200, 50);
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Dimension size = getSize(); //width -255, height -62
    
        if(status==1){
            //happy= loadImage("happy");
            g2.drawImage(happy,
                0, 0, size.width, size.height,
                0, 0, happy.getWidth(null), happy.getHeight(null),
                null);
             pan.setVisible(false);
        }
        else if(status==2){
           // thinking = loadImage("thinking");
            g2.drawImage(thinking,
                0, 0, size.width, size.height,
                0, 0, thinking.getWidth(null), thinking.getHeight(null),
                null);
             pan.setVisible(false);
        }
        else if(status==3){
            //worry = loadImage("worry");
            g2.drawImage(worry,
                0, 0, size.width, size.height,
                0, 0, worry.getWidth(null), worry.getHeight(null),
                null);
             pan.setVisible(false);
        }
        else if(status==4){
            //sorry = loadImage("sorry");
            g2.drawImage(sorry,
                0, 0, size.width, size.height,
                0, 0, sorry.getWidth(), sorry.getHeight(),null);
            pan.setVisible(false);
        }
        else if(status==0){   
          pan.setVisible(true);
          
        }
    }

    public void changeState(int state){
        status = state;
        repaint(); //paintComponent
    }
    
    public Dimension getPreferredSize(){
        return new Dimension(200, 200);
    }
    private BufferedImage loadImage(String name) {
        
        String imgFileName = "../resources/"+name+".png";
        //URL url = Universe.class.getResource(imgFileName);
        URL url = getClass().getResource(imgFileName);
        BufferedImage img = null;
            try {
                img =  ImageIO.read(url);
            } catch (Exception e) {
               e.printStackTrace();
               System.out.println("Image not found");
            }
        return img;
    }


}