
/*
 *  Main Screen of the GUI. Will have basic functionality
<<<<<<< HEAD
 *   
=======
 *  s
>>>>>>> parent of 63d3f96... GUI Main Screen Basic SpringLayout
 * @author Kevin, Jacob and Michael
 */

import ics414.ProcessUrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Container;

public class GUIMainScreen implements ActionListener{
	
	private JLabel title, getURLLabel, getRefreshRate, refreshLabel;
	private JPanel mainScreen;
	private JTextField getURLInput;
	private JButton getDataFromURL;
	private JComboBox<String> refreshRateBox;
	private SpringLayout layout;
	private String[] refreshRate;
    private JLabel outputLabel;
    private JLabel outputInt;
    private ProcessUrl processData;

	
	public GUIMainScreen() throws Exception {
		//ProcessUrl process = new ProcessUrl(null);
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
		refreshRate = new String[101];
		for(int i = 1; i < 101 ;i++) {
			refreshRate[i-1] = String.valueOf(i);
		}
		refreshRateBox = new JComboBox<String>(refreshRate);
		refreshRateBox.setSelectedIndex(0);
		mainScreen.add(refreshRateBox);
		
		//Label for Minutes
		refreshLabel = new JLabel("minutes");
		mainScreen.add(refreshLabel);
		
		//JButton for Sending Request for Google Calendar
		getDataFromURL = new JButton("Get Data");
		getDataFromURL.addActionListener(this);
		mainScreen.add(getDataFromURL);


        //Output label
        outputLabel = new JLabel("Output: ");
        mainScreen.add(outputLabel);

        //Output needs to be between -100 and 100
        outputInt = new JLabel("Output here");
        outputInt.setVisible(false);
        mainScreen.add(outputInt);

		
		
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

        //Output label
        layout.putConstraint(SpringLayout.WEST, outputLabel, 100, SpringLayout.WEST, mainScreen);
        layout.putConstraint(SpringLayout.NORTH, outputLabel, 180, SpringLayout.NORTH, mainScreen);

        //Output that shows after button press
        layout.putConstraint(SpringLayout.WEST, outputInt, 150, SpringLayout.WEST, mainScreen);
        layout.putConstraint(SpringLayout.NORTH, outputInt, 180, SpringLayout.NORTH, mainScreen);
		
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
			try {
				processData = new ProcessUrl(getURLInput.getText());

		        URL url = new URL("http://openweathermap.org/img/w/"+ processData.getWeatherIcon()+".png");
		        BufferedImage img = ImageIO.read(url);
		        ImageIcon weatherIcon = new ImageIcon(img);

		        String output = "Weather ID: " + processData.getWeatherId();

			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
			
			
            outputInt.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
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
