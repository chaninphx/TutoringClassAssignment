
//package src;



import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
/*
* Description: Tutor.java
* -load html files for each of the options the user picks in the
* Universe.java file
* (Assignment number: Recitation 4 Part 1:GUI)
*Completion Time: 18 hours
* @author Chandler Cotton
* @version 1.0
*/
public class Tutor extends JPanel
{
	FileReader fr;
	JScrollPane scrollPane;
	JPanel msgPanel;
	JLabel nameLabel;
	int panelNum;
	public Tutor() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setSize(120, 120);
		fr = null;
		panelNum = 0;      //panel will start at  state 0 (msgPanel) when program opens
		msgPanel = new JPanel();
		nameLabel = new JLabel("<Chandler>");
		msgPanel.add(nameLabel);
		this.add(msgPanel);     //adds message pane to panel
		this.setVisible(true);
                
                
	}

	public void changeState(int number) {
		if (number == 0) {
		nameLabel.setText("Chandler"); // sets name to chandler if state is 0
                    if (panelNum == 0) {
                        //do nothing if state is already on 0
                    }
                    else {  //going from scrollPane to msgPanel
                            this.add(msgPanel);
                            //System.out.println("closed");
                            this.remove(scrollPane);  //switching panels
                            this.revalidate();
                            this.repaint();
                            try {
                                    fr.close();
                            } catch (Exception e) {
                            e.printStackTrace();
                            }
                            panelNum = number;  //updating the status of the state
                        }
                }
		else
		{
			if (panelNum == number) {
			//do nothing if it is already on the scrollPane
			}
			else if (panelNum == 0) {
				try {
                                    this.remove(msgPanel);
                                    String file = "P" + number + ".html";  //retrieving file name based on the number passed in the parameter

                                    URL url = getClass().getResource("../resources/"+file);
                                    fr = new FileReader(new File(url.toURI()));

                                    JEditorPane htmlViewer = new JEditorPane();  //gets editorpane for html file
                                    htmlViewer.setContentType("text/html");  //sets htmlViewer to read html
                                    htmlViewer.read(fr, "test");
                                    scrollPane = new JScrollPane(htmlViewer);  //editorPane inserted to scroll pane
                                    this.add(scrollPane);
                                    scrollPane.revalidate();
                                    this.revalidate();   //updates panel
                                    this.repaint();
                                    panelNum = number;
                                    fr.close();
				} catch (Exception e) {
					this.errorMessageLabel(); //gets error message if html is
					e.printStackTrace();

                            }
			}

			else
			{
			try {
				this.remove(scrollPane);   //does same this except changes from one scrollPane to another instance
				String file = "P" + number + ".html";
				//System.out.println("gui/resources/" + file);
				fr = null;

				URL url = getClass().getResource("../resources/"+file);
                                fr = new FileReader(new File(url.toURI()));
                            	JEditorPane htmlViewer = new JEditorPane();

				htmlViewer.setContentType("text/html");
				htmlViewer.read(fr, "test");
				scrollPane = null;
				scrollPane = new JScrollPane(htmlViewer);
				this.add(scrollPane);
				scrollPane.revalidate();
				panelNum = number;
				fr.close();
				this.revalidate();
				this.repaint();
				panelNum = number;
			} catch (Exception e) {
				this.errorMessageLabel();
				e.printStackTrace();
				}
			}
		}
}
	public void errorMessageLabel() { //changes nameLabel to error message
		nameLabel.setText("HTML file is not found/working");
		if (panelNum == 0) {
			nameLabel.setText("HTML file is not found/working");
			this.revalidate();
			this.repaint();
		}
		else
		{
			this.remove(scrollPane);
			this.add(msgPanel);
			this.revalidate();
			this.repaint();
			panelNum = 0;
		}
            }

        public Dimension getPreferredSize() { //gets dimension size to help format scrollpane
			return new Dimension(200, 200);
	}
}