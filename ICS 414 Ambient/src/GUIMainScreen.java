/*
 *  Main Screen of the GUI. Will have basic functionality
<<<<<<< HEAD
 *   
=======
 *  s
>>>>>>> parent of 63d3f96... GUI Main Screen Basic SpringLayout
 * @author Kevin, Jacob and Michael
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Container;

public class GUIMainScreen implements ActionListener {
	
	private JLabel title, getURLLabel, getRefreshRate, refreshLabel;
	private JPanel mainScreen;
	private JTextField getURLInput;
	private JButton getDataFromURL;
	private JComboBox<String> refreshRateBox;
	private SpringLayout layout;
	private String[] refreshRate;
	
	
	public GUIMainScreen() {
		createAndShowGUI();
		
	}
	
	public void createAndShowGUI() {
		/*JFrame frame = new JFrame("Event Lights");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(300,500));
		frame.setResizable(false);
		*/
		
		layout = new SpringLayout();
		
		mainScreen = new JPanel();
		mainScreen.setPreferredSize(new Dimension(300,500));
		mainScreen.setVisible(true);
		mainScreen.setLayout(layout);
		
		//JLabel for Title
		title =new JLabel("Main Page");
		mainScreen.add(title);
		
		//JLabel URL
		getURLLabel = new JLabel("Enter URL to Google Calendar:");
		mainScreen.add(getURLLabel);
		
		//JTextField for URL Input
		getURLInput = new JTextField(23);
		mainScreen.add(getURLInput);
		
		//JLabel Refresh Rate
		getRefreshRate = new JLabel("Change Refresh Timer:");
		mainScreen.add(getRefreshRate);
		
		//JComboBox to avoid bad input
		refreshRate = new String[100];
		for(int i = 1; i < 100 ;i++) {
			refreshRate[i] = String.valueOf(i);
		}
		refreshRateBox = new JComboBox<String>(refreshRate);
		mainScreen.add(refreshRateBox);
		
		//Label for Minutes
		refreshLabel = new JLabel("minutes");
		mainScreen.add(refreshLabel);
		
		//JButton for Sending Request for Google Calendar
		getDataFromURL = new JButton("Get Data");
		getDataFromURL.addActionListener(this);
		mainScreen.add(getDataFromURL);
		
		
		//Layout Constraints for Title
		layout.putConstraint(SpringLayout.WEST, title, 5, SpringLayout.WEST, mainScreen);
		layout.putConstraint(SpringLayout.NORTH, title, 15, SpringLayout.NORTH, mainScreen);
		
		//Layout Constraints for URL Label
		layout.putConstraint(SpringLayout.WEST, getURLLabel, 5, SpringLayout.WEST, mainScreen);
		layout.putConstraint(SpringLayout.NORTH, getURLLabel, 45, SpringLayout.NORTH, mainScreen);
		
		//Layout Constraints for Text InputBox
		layout.putConstraint(SpringLayout.WEST, getURLInput, 15, SpringLayout.WEST, mainScreen);
		layout.putConstraint(SpringLayout.NORTH, getURLInput, 65, SpringLayout.NORTH, mainScreen);
		
		//Layout Constraints for JLabel Refresh
		layout.putConstraint(SpringLayout.WEST, getRefreshRate, 5, SpringLayout.WEST, mainScreen);
		layout.putConstraint(SpringLayout.NORTH, getRefreshRate, 105, SpringLayout.NORTH, mainScreen);
		
		//Layout Constraints for JComboBox w/ Refresh
		layout.putConstraint(SpringLayout.WEST, refreshRateBox, 35, SpringLayout.WEST, mainScreen);
		layout.putConstraint(SpringLayout.NORTH, refreshRateBox, 125, SpringLayout.NORTH, mainScreen);
		
		//Layout Constraints for minute label for combobox
		layout.putConstraint(SpringLayout.WEST, refreshLabel, 85, SpringLayout.WEST, mainScreen);
		layout.putConstraint(SpringLayout.NORTH, refreshLabel, 130, SpringLayout.NORTH, mainScreen);
		
		//Layout Constraints for Button
		layout.putConstraint(SpringLayout.WEST, getDataFromURL, 110, SpringLayout.WEST, mainScreen);
		layout.putConstraint(SpringLayout.SOUTH, getDataFromURL, -20, SpringLayout.SOUTH, mainScreen);
		
		mainScreen.setLayout(layout);
		
		/*frame.setLocationRelativeTo(null);
		frame.getmainScreen();
		frame.pack();
		frame.setVisible(true);*/	
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if(source == getDataFromURL){
			System.out.println("URL: " + getURLInput.getText());
			System.out.println("Refresh Rate: " + refreshRateBox.getSelectedItem().toString());
		}
		
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Event Lights");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(new Dimension(300,500));
		window.setResizable(false);
		GUIMainScreen gui = new GUIMainScreen();
		window.setContentPane(gui.mainScreen);
		window.setLocationRelativeTo(null);
		window.pack();
		window.setVisible(true);
		//GUIMainScreen mainScreen = new GUIMainScreen();

	}
}
