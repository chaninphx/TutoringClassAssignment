package project_git.src;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * Description: Assessor.java
 * Assessor will have 5 outputs depending on the state that the slider is at.
 * For state 0 it will only show the author's name (my name), State 1= will show the ComboBox
 * State 3 will show the checkBox and state 4 will show textfield.
 *
 * (Assignment number: Recitation 4 Part 1:GUI) 
 * Completion time: 18 hrs
 *
 * @author Ramy Dagdoni
 * @version 1.0
 */
public class Assessor extends JPanel implements ActionListener {

    private String authorName = "Ramy";
    //q1
    private JComboBox<String> drop;
    //q2
    private JCheckBox cb1, cb2, cb3;
    //q3
    private JButton btn1, btn2, btn3;
    //q4
    private JTextField field;
    private JPanel inner0, inner, inner2, inner3, inner4;
    private String yourInput = "  ";
    private int state;
    //private int status;

    public Assessor() {
        inner0 = new JPanel();
        inner = new JPanel();
        inner2 = new JPanel();
        inner3 = new JPanel();
        inner4 = new JPanel();

        JFrame authorFrame = new JFrame();
        JLabel authorLabel = new JLabel("Ramy");
        inner0.add(authorLabel);
        authorFrame.setLayout(new GridBagLayout());
        authorLabel.setFont(new Font("Verdana", 1, 20));

        inner.add(new JLabel("Question 1"));
        drop = new JComboBox<>(new String[]{"option 1", "option 2", "option 3"});
        drop.addActionListener(this);
        inner.add(drop);

        inner2.add(new JLabel("Question 2"));
        inner2.setLayout(new GridLayout(3, 1));
        cb1 = new JCheckBox("option 1");
        cb1.addActionListener(this);
        inner2.add(cb1);
        cb2 = new JCheckBox("option 2");
        cb2.addActionListener(this);
        inner2.add(cb2);
        cb3 = new JCheckBox("option 3");
        cb3.addActionListener(this);
        inner2.add(cb3);

        inner3.add(new JLabel("Question 3"));
        inner3.setLayout(new GridLayout(3, 1));
        btn1 = new JButton("option 1");
        btn1.addActionListener(this);
        inner3.add(btn1);
        btn2 = new JButton("option 2");
        btn2.addActionListener(this);
        inner3.add(btn2);
        btn3 = new JButton("option 3");
        btn3.addActionListener(this);
        inner3.add(btn3);

        inner4.add(new JLabel("Question 4"));
        field = new JTextField("write here....", 15);
        field.addActionListener(this);
        inner4.add(field);
        this.add(inner0);
        this.add(inner);
        this.add(inner2);
        this.add(inner3);
        this.add(inner4);

        inner0.setVisible(true);
        inner.setVisible(false);
        inner2.setVisible(false);
        inner3.setVisible(false);
        inner4.setVisible(false);

    }

    public void changeState(int state) {
        if (state == 0) {
            inner0.setVisible(true);
            inner.setVisible(false);
            inner2.setVisible(false);
            inner3.setVisible(false);
            inner4.setVisible(false);
        }
        if (state == 1) {
            inner0.setVisible(false);
            inner.setVisible(true);
            inner2.setVisible(false);
            inner3.setVisible(false);
            inner4.setVisible(false);
        }
        if (state == 2) {
            inner0.setVisible(false);
            inner.setVisible(false);
            inner2.setVisible(true);
            inner3.setVisible(false);
            inner4.setVisible(false);
        }
        if (state == 3) {
            inner0.setVisible(false);
            inner.setVisible(false);
            inner2.setVisible(false);
            inner3.setVisible(true);
            inner4.setVisible(false);
        }
        if (state == 4) {
            inner0.setVisible(false);
            inner.setVisible(false);
            inner2.setVisible(false);
            inner3.setVisible(false);
            inner4.setVisible(true);
        }

    }

    public void myZeroQuestion() {
        authorName = "Ramy";
    }

    public void myFirstQuestion() {
        drop = new JComboBox<>(new String[]{"option 1", "option 2", "option 3"});
        drop.addActionListener(this);
        inner.add(drop);
        this.add(inner);
        //inner.add(inner, BorderLayout.CENTER);
    }

    public void mySecondQuestion() {
        inner2.setLayout(new GridLayout(3, 1));
        cb1 = new JCheckBox("option 1");
        cb1.addActionListener(this);
        inner2.add(cb1);
        cb2 = new JCheckBox("option 2");
        cb2.addActionListener(this);
        inner2.add(cb2);
        cb3 = new JCheckBox("option 3");
        cb3.addActionListener(this);
        inner2.add(cb3);
        this.add(inner2);
    }

    public void myThirdQuestion() {

        inner3.setLayout(new GridLayout(3, 1));
        btn1 = new JButton("option 1");
        btn1.addActionListener(this);
        inner3.add(btn1);
        btn2 = new JButton("option 2");
        btn2.addActionListener(this);
        inner3.add(btn2);
        btn3 = new JButton("option 3");
        btn3.addActionListener(this);
        inner3.add(btn3);
        this.add(inner3);

    }

    public void myFourthQuestion() {
        //inner4 = new JPanel();
        field = new JTextField("write here....", 15);
        field.addActionListener(this);
        inner4.add(field);
        this.add(inner4);
        //add(inner4, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == authorName) {
            String myName = (String) authorName;
            JOptionPane.showMessageDialog(null, "Ramy ");
        }
        //Question 1
        if (e.getSource() == drop) {
            String myChoice = (String) drop.getSelectedItem();
            String myChoice1 = "option 1";
            String myChoice2 = "option 2";
            String myChoice3 = "option 3";

            if (myChoice.equals(myChoice1)) {
                JOptionPane.showMessageDialog(null, "Choice 1 was selected ");
            } else if (myChoice.equals(myChoice2)) {
                JOptionPane.showMessageDialog(null, "Choice 2 was selected ");
            } else if (myChoice.equals(myChoice3)) {
                JOptionPane.showMessageDialog(null, "Choice 3 was selected ");
            }
        }
        //Question 2
        if (e.getSource() == cb1) {

            String myBox1 = "option 1";
            String myBox2 = "option 2";
            String myBox3 = "option 3";
            if (cb1.isSelected()) {
                JOptionPane.showMessageDialog(null, "Option 1 was selected ");
            } else if (cb2.isSelected()) {
                JOptionPane.showMessageDialog(null, "Option 2 was selected ");
            } else if (cb3.isSelected()) {
                JOptionPane.showMessageDialog(null, "Option 3 was selected ");
            }

        }
        //Question 3 give the output of the selection list
        if (e.getSource().equals(btn1)) {
            JOptionPane.showMessageDialog(null, "Option 1 was selected ");
        } else if (e.getSource().equals(btn2)) {
            JOptionPane.showMessageDialog(null, "Option 2 was selected ");
        } else if (e.getSource().equals(btn3)) {
            JOptionPane.showMessageDialog(null, "Option 3 was selected ");
        }
        //Question 4
        if (e.getSource() == field) {
            yourInput = field.getText();
            JOptionPane.showMessageDialog(null, "Hello " + yourInput);
            System.exit(0);
        } else {
            yourInput = field.getText();
            if (yourInput.isEmpty()) {
                yourInput = field.getText();
                JOptionPane.showMessageDialog(null, "You didn't enter a name ");
            }
        }

    }
}
