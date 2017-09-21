
package src;

/**
 * Description: Universe.java. In this program, I had to implement a JFrame and add 4 JPanels into
 * that frame. In addition, I had to add a JSlider at the south side of the frame. 
 *
 * (Assignment number: Recitation 4 Part 1:GUI)
 * Completion time: 20 hours
 *
 * @author Paul Tang 
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Universe extends JFrame {

    GridLayout cCotton = new GridLayout(0, 2);
    JSlider sliding;
    Companion xPanel = new Companion();
    Tutor yPanel = new Tutor();
    Assessor zPanel = new Assessor();
    JPanel pPanel = new JPanel();

    public Universe(String Paul) {
        super(Paul);
        setResizable(true);

        final JPanel proj = new JPanel();
        proj.setLayout(cCotton);
        JPanel controls = new JPanel();

//START SLIDER
        sliding = new JSlider(JSlider.HORIZONTAL, 0, 4, 0);
        sliding.setMajorTickSpacing(1);
        sliding.setPaintTicks(true);
        controls.add(sliding);
        event ab = new event();
        sliding.addChangeListener(ab);

//I set up the components to the preferred size
        proj.setPreferredSize(new Dimension(600, 600));

        xPanel.add(new JLabel("Vivian"));
        proj.add(xPanel);
        yPanel.add(new JLabel("Chandler"));
        proj.add(yPanel);
        zPanel.add(new JLabel("Ramy"));
        proj.add(zPanel);
        pPanel.add(new JLabel("Paul"));
        proj.add(pPanel);
        this.add(proj, BorderLayout.NORTH);
        this.add(new JSeparator(),BorderLayout.CENTER);
        this.add(controls,BorderLayout.CENTER);


    }

    public class event implements ChangeListener {

        public void stateChanged(ChangeEvent e) {
//when we slide the slider, we want the label to change to where the slider is at
            JSlider slide = (JSlider) e.getSource();
            int statusOne = slide.getValue(); //when it hits the tick, you will find the value
            xPanel.changeState(statusOne);
            yPanel.changeState(statusOne);
            zPanel.changeState(statusOne);
        }
    }

    public static void main(String[] args) {
        Universe projTwo = new Universe("Universe");
        projTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projTwo.pack();//resizes the window to fit contents
        projTwo.setVisible(true); //the window will appear
    }

}
