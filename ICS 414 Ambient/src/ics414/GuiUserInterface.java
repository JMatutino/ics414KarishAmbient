/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics414;

/**
 *
 * @author kevintone
 */

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.tree.ExpandVetoException;
import java.awt.TextArea;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class GuiUserInterface extends javax.swing.JFrame implements ActionListener {
	
    // Variables declaration - do not modify  
	//Menu Bar at the top
	private JMenuBar topMenuBar;
    private JMenu topMenu1, topMenu2;
    //Tabs in the Interface
    private JPanel tabContainer, generalTab, forecastTab, setColorsTab, settingTab;
    private JTabbedPane tabbedPane;
    //General Pane
    private JLabel upcomingEventLabel;
    private JLabel generalLabel;
    private JLabel createEventLabel;
    private JLabel editEventLabel;
    private JLabel deleteEventLabel;
    private JButton createEventButton;
    private JButton editEventButton;
    private JButton deleteEventButton;
    private TextArea upcomingEventArea;
    
    //Set Colors Pane
    private JLabel setColorsLabel, colorWeatherLabel, colorCalendarLabel;
    private JButton jButton7, jButton8, jButton9, jButton10, jButton11, jButton12,
    	jButton13, jButton14;
    private JSeparator setColorSeparator1;
    
    // Settings Pane
    private JSeparator settingSeparator1, settingSeparator2;
    private JButton weatherDataButton, uploadCalendarButton, saveSettingsButton;
    private JLabel settingLabel, calendarSettingsLabel, weatherSettingsLabel,
    	otherSettingsLabel, enterUrlLabel, refreshLabel, uploadCalendarLabel,
    	warningLabel1, warningLabel2, weatherORLabel, getWeatherLabel;
    private JTextField weatherURLField;
    private JComboBox<Integer> refreshBox;
    
    private JMenuItem menuItem;
    
    
    private ProcessUrl usrWeatherData;
    // End of variables declaration    
    
    /**
     * Creates new form GuiUserInterface
     */
    public GuiUserInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
    	//Tabs for the main part of the GUI
        tabContainer = new JPanel();
        tabbedPane = new JTabbedPane();
        generalTab = new JPanel();
        forecastTab = new JPanel();
        setColorsTab = new JPanel();
        settingTab = new JPanel();
        
        //Initializing Menu Bar + menu Items
        topMenuBar = new JMenuBar();
        topMenu1 = new JMenu();
        topMenu2 = new JMenu();
        
        //Initializing General Buttons/Labels
        upcomingEventArea = new TextArea();
        upcomingEventLabel = new JLabel();
        generalLabel = new JLabel();
        createEventButton = new JButton();
        editEventButton = new JButton();
        deleteEventButton = new JButton();
        createEventLabel = new JLabel();
        editEventLabel = new JLabel();
        deleteEventLabel = new JLabel();
        
        //Initializing Set Colors Pane
        setColorsLabel = new JLabel();
        colorWeatherLabel = new JLabel();
        colorCalendarLabel = new JLabel();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButton10 = new JButton();
        jButton11 = new JButton();
        jButton12 = new JButton();
        jButton13 = new JButton();
        jButton14 = new JButton();
        setColorSeparator1 = new JSeparator();
        
        //Initializing Settings buttons/Labels
        settingLabel = new JLabel();
        enterUrlLabel = new JLabel();
        refreshLabel = new JLabel();
        weatherURLField = new JTextField();
        weatherDataButton = new JButton();
        //zipcodeLabel = new JLabel();
        uploadCalendarLabel = new JLabel();
        uploadCalendarButton = new JButton();
        warningLabel1 = new JLabel();
        warningLabel2 = new JLabel();
        weatherORLabel = new JLabel();
        //zipcodeField = new JTextField();
        getWeatherLabel = new JLabel();
        settingSeparator1 = new JSeparator();
        settingSeparator2 = new JSeparator();
        calendarSettingsLabel = new JLabel();
        weatherSettingsLabel = new JLabel();
        otherSettingsLabel = new JLabel();
        saveSettingsButton = new JButton();
        Integer[] refreshMinutes = new Integer[10];
        
        for(int i =0; i < 10; i++) {
        	refreshMinutes[i] = i+1;
        }
        refreshBox = new JComboBox<Integer>(refreshMinutes);
        
        
        topMenu1.setText("File");
        topMenuBar.add(topMenu1);

        topMenu2.setText("Edit");
        topMenuBar.add(topMenu2);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //General Tab
        generalLabel.setText("General");
        upcomingEventLabel.setText("Upcoming Events: ");
        createEventLabel.setText("Create");
        editEventLabel.setText("Edit");
        deleteEventLabel.setText("Delete");
        
        createEventButton.setText("Create Event");
        createEventButton.addActionListener(this);
        editEventButton.setText("Edit Event");
        editEventButton.addActionListener(this);
        deleteEventButton.setText("Delete Event");
        deleteEventButton.addActionListener(this);
        
        upcomingEventArea.setEditable(false);
        
        javax.swing.GroupLayout generalTabLayout = new javax.swing.GroupLayout(generalTab);
        generalTab.setLayout(generalTabLayout);
        generalTabLayout.setHorizontalGroup(
            generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalTabLayout.createSequentialGroup()
                .addGroup(generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalTabLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(generalLabel))
                    .addGroup(generalTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(upcomingEventLabel)
                            .addGroup(generalTabLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(upcomingEventArea, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(generalTabLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createEventLabel)
                            .addComponent(editEventLabel)
                            .addComponent(deleteEventLabel))
                        .addGap(18, 18, 18)
                        .addGroup(generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createEventButton)
                            .addComponent(editEventButton)
                            .addComponent(deleteEventButton))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        generalTabLayout.setVerticalGroup(
            generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalTabLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(generalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalTabLayout.createSequentialGroup()
                        .addComponent(upcomingEventLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upcomingEventArea, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(generalTabLayout.createSequentialGroup()
                        .addGap(290, 389, Short.MAX_VALUE)
                        .addGroup(generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createEventLabel)
                            .addComponent(createEventButton))))
                .addGap(18, 18, 18)
                .addGroup(generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editEventLabel)
                    .addComponent(editEventButton))
                .addGap(23, 23, 23)
                .addGroup(generalTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteEventLabel)
                    .addComponent(deleteEventButton))
                .addGap(27, 27, 27))
        );

        tabbedPane.addTab("General", generalTab);

        
        //Forecast Tab
        javax.swing.GroupLayout forecastTabLayout = new javax.swing.GroupLayout(forecastTab);
        forecastTab.setLayout(forecastTabLayout);
        forecastTabLayout.setHorizontalGroup(
            forecastTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );
        forecastTabLayout.setVerticalGroup(
            forecastTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Forecast", forecastTab);
        
        
        //Setting Colors Tab
        setColorsLabel.setText("Set Colors");
        colorWeatherLabel.setText("Weather Events");
        colorCalendarLabel.setText("Calendar Events");
        jButton7.setText("jButton7");
        jButton8.setText("jButton8");
        jButton9.setText("jButton9");
        jButton10.setText("jButton10");
        jButton11.setText("jButton11");
        jButton12.setText("jButton12");
        jButton13.setText("jButton13");
        jButton14.setText("jButton14");

        javax.swing.GroupLayout setColorsTabLayout = new javax.swing.GroupLayout(setColorsTab);
        setColorsTab.setLayout(setColorsTabLayout);
        setColorsTabLayout.setHorizontalGroup(
            setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setColorsTabLayout.createSequentialGroup()
                .addGroup(setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setColorsTabLayout.createSequentialGroup()
                        .addGroup(setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(setColorsTabLayout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(setColorsLabel))
                            .addGroup(setColorsTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(colorWeatherLabel)
                                    .addGroup(setColorsTabLayout.createSequentialGroup()
                                        .addGroup(setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(setColorsTabLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton7)
                                                    .addComponent(jButton8)
                                                    .addComponent(jButton9)))
                                            .addComponent(jButton10))
                                        .addGap(18, 18, 18)
                                        .addGroup(setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton12)
                                            .addComponent(jButton11)
                                            .addComponent(jButton13)))))
                            .addGroup(setColorsTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(setColorsTabLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton14))
                                    .addComponent(colorCalendarLabel))))
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addComponent(setColorSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        setColorsTabLayout.setVerticalGroup(
            setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setColorsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(setColorsLabel)
                .addGap(18, 18, 18)
                .addComponent(colorWeatherLabel)
                .addGroup(setColorsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setColorsTabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10))
                    .addGroup(setColorsTabLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)))
                .addGap(63, 63, 63)
                .addComponent(setColorSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorCalendarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Set Colors", setColorsTab);
        
        //Weather Settings
        weatherSettingsLabel.setText("Weather Settings");
        enterUrlLabel.setText("Enter URL for Weather");
        //weatherURLField.setText("weatherURLField");
        weatherURLField.setEditable(true);
        //zipcodeField.setText("zipcodeField");
        getWeatherLabel.setText("Get Weather Data: ");
        weatherDataButton.setText("Get Weather");
        weatherDataButton.addActionListener(this);
        
        //Calendar Settings
        calendarSettingsLabel.setText("Calendar Settings");
        warningLabel1.setText("*** Hitting Upload will require google");
        warningLabel2.setText("   account to get Calendar info ***");
        uploadCalendarLabel.setText("Upload a Google Calendar:");
        uploadCalendarButton.setText("Upload");
        uploadCalendarButton.addActionListener(this);
        
        //Other Settings
        otherSettingsLabel.setText("Other Settings");
        refreshLabel.setText("Change Refresh Rate (Minutes)");
        saveSettingsButton.setText("Save Settings");
        saveSettingsButton.addActionListener(this);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(settingTab);
        settingTab.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(weatherURLField))
                    .addComponent(settingSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(settingSeparator1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(warningLabel2))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(warningLabel1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(weatherORLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(weatherSettingsLabel)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(enterUrlLabel)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(getWeatherLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(weatherDataButton))))))
                            .addComponent(calendarSettingsLabel)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(uploadCalendarLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uploadCalendarButton))
                            .addComponent(otherSettingsLabel)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(refreshLabel))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                            		.addContainerGap()
                            		.addComponent(refreshBox))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(settingLabel)))
                        .addGap(0, 76, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(saveSettingsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(settingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(weatherSettingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterUrlLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weatherURLField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(weatherORLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getWeatherLabel)
                    .addComponent(weatherDataButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendarSettingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uploadCalendarLabel)
                    .addComponent(uploadCalendarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otherSettingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(saveSettingsButton)
                .addContainerGap())
        );

        tabbedPane.addTab("Settings", settingTab);

        javax.swing.GroupLayout tabContainerLayout = new javax.swing.GroupLayout(tabContainer);
        tabContainer.setLayout(tabContainerLayout);
        tabContainerLayout.setHorizontalGroup(
            tabContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        tabContainerLayout.setVerticalGroup(
            tabContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );

        topMenu1.setText("File");
        topMenuBar.add(topMenu1);

        topMenu2.setText("Edit");
        
        menuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        menuItem.setText("Copy");
        menuItem.setMnemonic(KeyEvent.VK_C);
        topMenu2.add(menuItem);
        
        menuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        menuItem.setText("Paste");
        menuItem.setMnemonic(KeyEvent.VK_P);
        topMenu2.add(menuItem);
        
        topMenuBar.add(topMenu2);

        setJMenuBar(topMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        
        getContentPane().setPreferredSize(new Dimension(350,554));

        //Process URL when press "Get Weather" button
        /*weatherDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProcessUrl usrWeatherData = null;
                try {
                    usrWeatherData = new ProcessUrl(weatherURLField.getText());
                    JOptionPane.showMessageDialog(null,
                            usrWeatherData.getWeatherId(),
                            "Notification",
                            JOptionPane.INFORMATION_MESSAGE,
                            usrWeatherData.getWeatherIcon());
                } catch (Exception exception) {
                    System.err.println("Problem processing weather url");
                    JOptionPane.showMessageDialog(null,
                            "Problem processing Weather URL",
                            "alert",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });*/
        
        pack();
    }// </editor-fold>


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiUserInterface().setVisible(true);
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if (source == weatherDataButton) {
			if (!(weatherURLField.getText().equals(""))) {
				System.out.println(weatherURLField.getText());
				try{
					usrWeatherData = new ProcessUrl(weatherURLField.getText());
					
					//Start the refreshing of ambient part of the User Interface
					int refreshInMinutes = 60000; // 60000 milliseconds == 1 minute
					
					System.out.println(refreshBox.getSelectedItem().toString());
			        refreshInMinutes *= Integer.parseInt(refreshBox.getSelectedItem().toString());
			        
			        Timer refreshTimer = new Timer();
			        refreshTimer.scheduleAtFixedRate(new TimerTask(){
			        	public void run() {
			        		try{
			        			usrWeatherData.showWeatherIcon();
			        		} catch (IOException e){
			        			e.printStackTrace();
			        		}
			        	}
			        }, 0, refreshInMinutes);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

               
}
