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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class GuiUserInterface extends javax.swing.JFrame implements ActionListener {
	
    // Variables declaration - do not modify  
	private String startURL = "http://api.openweathermap.org/data/2.5/weather?";
	private String endURL = "&appid=2de143494c0b295cca9337e1e96b00e0";
	private String locWeatherURL = new String();
	private String location = new String();
	private String humidity = new String();
	private Double temperature = null;
	
	//Menu Bar at the top
	private JMenuBar topMenuBar;
    private JMenu topMenu1, topMenu2;
    //Tabs in the Interface
    private JPanel tabContainer, forecastTab, settingTab, legendTab;
    private JTabbedPane tabbedPane;
    
    //Forecast Pane
    private JLabel forecastLabel, currentWeatherLabel, weatherImage, humidityLabel,
    	temperatureLabel;
    private JLabel humidityValue, temperatureValue;
    private boolean hasWeatherForCity = false;
    
    //Legend Pane
    private JLabel weatherIconLegendLabel, forecastDescriptionLabel, dayLabel, nightLabel, clearSkiesLabel, fewCloudsLabel, scatteredLabel,
    	brokenCloudLabel, showerLabel, rainLabel, thunderLabel, snowLabel, mistLabel, clearSkiesNightIcon, clearSkiesDayIcon,
    	fewCloudsDayIcon, fewCloudsNightIcon, scatteredDayIcon, scatteredNightIcon, brokenCloudsDayIcon, brokenCloudsNightIcon, showerDayIcon, showerNightIcon,
    	rainDayIcon, rainNightIcon, thunderDayIcon, thunderNightIcon, snowDayIcon, snowNightIcon, mistDayIcon, mistNightIcon;
    
    // Settings Pane
    private JSeparator settingSeparator1;
    private JButton weatherZipButton, weatherCityButton,saveSettingsButton;
    private JLabel settingLabel, weatherSettingsLabel, otherSettingsLabel, enterCityLabel,
    	refreshLabel, zipcodeLabel, weatherORLabel, getWeatherLabel;
    private JTextField weatherCityField, zipcodeField;
    private JComboBox<Integer> refreshBox;
    private boolean hasForecastPane = false;
    private boolean hasLegendPane = false;
    
    private JMenuItem menuItem;
    
    
    private ProcessUrl usrWeatherData;
    // End of variables declaration    
    
    /**
     * Creates new form GuiUserInterface
     */
    public GuiUserInterface() {
        initComponents();
    }
    
    private double toFarenheit(String fromKelvin) {
    	double answer = Double.parseDouble(fromKelvin);
    	answer -= 273.15;
    	answer *= 1.8;
    	answer += 32;
    	
    	return answer;
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
        forecastTab = new JPanel();
        settingTab = new JPanel();
        legendTab = new JPanel();
        
        //Initializing Menu Bar + menu Items
        topMenuBar = new JMenuBar();
        topMenu1 = new JMenu();
        topMenu2 = new JMenu();
        
        //Forecast Labels
        forecastLabel = new JLabel();
        currentWeatherLabel  = new JLabel();
        humidityLabel = new JLabel();
        temperatureLabel = new JLabel();
        humidityValue = new JLabel();
        temperatureValue = new JLabel();
        
        //Initializing Settings buttons/Labels
        settingLabel = new JLabel();
        enterCityLabel = new JLabel();
        refreshLabel = new JLabel();
        weatherCityField = new JTextField();
        weatherZipButton = new JButton();
        weatherCityButton = new JButton();
        zipcodeLabel = new JLabel();
        weatherORLabel = new JLabel();
        zipcodeField = new JTextField();
        getWeatherLabel = new JLabel();
        settingSeparator1 = new JSeparator();
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
        
        //Weather Settings
        weatherSettingsLabel.setText("Weather Settings");
        enterCityLabel.setText("Enter City for Weather (No Spaces): ");
        getWeatherLabel.setText("Get Weather Data: ");
        weatherORLabel.setText("Get Weather Data: ");
        zipcodeLabel.setText("Enter Zip Code: (US Only)");
        weatherCityButton.setText("Using City");
        weatherCityButton.addActionListener(this);
        weatherZipButton.setText("Using Zipcode");
        weatherZipButton.addActionListener(this);

        //Other Settings
        otherSettingsLabel.setText("Other Settings");
        refreshLabel.setText("Change Refresh Rate (Minutes)");
        saveSettingsButton.setText("Save Settings");
        saveSettingsButton.addActionListener(this);
        
        javax.swing.GroupLayout settingTabLayout = new javax.swing.GroupLayout(settingTab);
        settingTab.setLayout(settingTabLayout);
        settingTabLayout.setHorizontalGroup(
            settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingTabLayout.createSequentialGroup()
                .addGroup(settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingSeparator1)
                    .addGroup(settingTabLayout.createSequentialGroup()
                        .addGroup(settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(weatherSettingsLabel)
                                    .addGroup(settingTabLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(zipcodeLabel)
                                            .addComponent(enterCityLabel)
                                            .addGroup(settingTabLayout.createSequentialGroup()
                                                .addComponent(getWeatherLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(weatherZipButton))
                                            .addComponent(weatherCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(settingTabLayout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(settingLabel))
                            .addGroup(settingTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(zipcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(weatherORLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(weatherCityButton)))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(settingTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingTabLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(refreshLabel))
                    .addGroup(settingTabLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(refreshBox))
                    .addComponent(otherSettingsLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        settingTabLayout.setVerticalGroup(
            settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingTabLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(settingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(weatherSettingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterCityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weatherCityField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weatherORLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weatherCityButton))
                .addGap(18, 18, 18)
                .addComponent(zipcodeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zipcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getWeatherLabel)
                    .addComponent(weatherZipButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otherSettingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshBox)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Setup", settingTab);

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
        
        
        getContentPane().setPreferredSize(new Dimension(340,554));
        
        pack();
    }// </editor-fold>
    
    private void createForecastTab() {
    	if (hasWeatherForCity) {
    		try{
    			forecastLabel.setText("Forecast");
            	currentWeatherLabel.setText("Current Forecast for " + location + ":" );
            	humidityLabel.setText("Humidity:");
            	temperatureLabel.setText("Temperature (degree Farenheit): ");
            	humidityValue.setText(humidity);
            	
            	String sTemp = temperature.toString();
            	sTemp = sTemp.substring(0, 4);
            	temperatureValue.setText(sTemp);
            	weatherImage = new JLabel(usrWeatherData.getWeatherIcon());

                javax.swing.GroupLayout forecastTabLayout = new javax.swing.GroupLayout(forecastTab);
                forecastTab.setLayout(forecastTabLayout);
                forecastTabLayout.setHorizontalGroup(
                    forecastTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(forecastTabLayout.createSequentialGroup()
                        .addGroup(forecastTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(forecastTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(currentWeatherLabel))
                            .addGroup(forecastTabLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(forecastTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forecastTabLayout.createSequentialGroup()
                                        .addComponent(humidityLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(humidityValue))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forecastTabLayout.createSequentialGroup()
                                        .addComponent(temperatureLabel)
                                        .addGap(20, 20, 20)
                                        .addComponent(temperatureValue))))
                            .addGroup(forecastTabLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(forecastTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(weatherImage)
                                    .addComponent(forecastLabel))))
                        .addContainerGap(95, Short.MAX_VALUE))
                );
                forecastTabLayout.setVerticalGroup(
                    forecastTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(forecastTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(forecastLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentWeatherLabel)
                        .addGap(58, 58, 58)
                        .addComponent(weatherImage)
                        .addGap(120, 120, 120)
                        .addGroup(forecastTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temperatureLabel)
                            .addComponent(temperatureValue))
                        .addGap(28, 28, 28)
                        .addGroup(forecastTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(humidityLabel)
                            .addComponent(humidityValue))
                        .addGap(27, 27, 27)
                        .addContainerGap(234, Short.MAX_VALUE))
                );
                
                tabbedPane.addTab("Forecast", forecastTab);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        	

            
        } 
    }
    
    private void updateForecastTab() {
    	try {
    		currentWeatherLabel.setText("Current Forecast for " + location + ":" );
        	humidityValue.setText(humidity);
        	
        	String sTemp = temperature.toString();
        	sTemp = sTemp.substring(0, 4);
        	temperatureValue.setText(sTemp);
        	weatherImage = new JLabel(usrWeatherData.getWeatherIcon());
        	
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    private void createForecastLegend() {
        weatherIconLegendLabel = new JLabel();
    	forecastDescriptionLabel = new JLabel();
    	dayLabel = new JLabel();
    	nightLabel = new JLabel();
    	clearSkiesLabel = new JLabel();
    	fewCloudsLabel = new JLabel();
    	scatteredLabel = new JLabel();
    	brokenCloudLabel = new JLabel();
    	showerLabel = new JLabel();
    	rainLabel = new JLabel();
    	thunderLabel = new JLabel();
    	snowLabel = new JLabel();
    	mistLabel = new JLabel();
    	try {
    		clearSkiesNightIcon = new JLabel(usrWeatherData.getLegendIcon("01n"));
        	clearSkiesDayIcon = new JLabel(usrWeatherData.getLegendIcon("01d"));
        	fewCloudsDayIcon = new JLabel(usrWeatherData.getLegendIcon("02d"));
        	fewCloudsNightIcon = new JLabel(usrWeatherData.getLegendIcon("02n"));
        	scatteredDayIcon = new JLabel(usrWeatherData.getLegendIcon("03d"));
        	scatteredNightIcon = new JLabel(usrWeatherData.getLegendIcon("03n"));
        	brokenCloudsDayIcon = new JLabel(usrWeatherData.getLegendIcon("04d"));
        	brokenCloudsNightIcon = new JLabel(usrWeatherData.getLegendIcon("04n"));
        	showerDayIcon = new JLabel(usrWeatherData.getLegendIcon("09d"));
        	showerNightIcon = new JLabel(usrWeatherData.getLegendIcon("09n"));
        	rainDayIcon = new JLabel(usrWeatherData.getLegendIcon("10d"));
        	rainNightIcon = new JLabel(usrWeatherData.getLegendIcon("10n"));
        	thunderDayIcon = new JLabel(usrWeatherData.getLegendIcon("11d"));
        	thunderNightIcon = new JLabel(usrWeatherData.getLegendIcon("11n"));
        	snowDayIcon = new JLabel(usrWeatherData.getLegendIcon("13d"));
        	snowNightIcon = new JLabel(usrWeatherData.getLegendIcon("13n"));
        	mistDayIcon = new JLabel(usrWeatherData.getLegendIcon("50d"));
        	mistNightIcon = new JLabel(usrWeatherData.getLegendIcon("50n"));
    	} catch(Exception e) {
    		e.printStackTrace();;
    	}
    	
    	weatherIconLegendLabel.setText("Weather Icon Legend");
        forecastDescriptionLabel.setText("Forecast Description");
        dayLabel.setText("Day");
        nightLabel.setText("Night");
        clearSkiesLabel.setText("Clear Skies");
        fewCloudsLabel.setText("Few Clouds");
        scatteredLabel.setText("Scattered Clouds");
        brokenCloudLabel.setText("Broken Clouds");
        showerLabel.setText("Shower Rain");
        rainLabel.setText("Rain");
        thunderLabel.setText("Thunderstorm");
        snowLabel.setText("Snow");
        mistLabel.setText("Mist");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(legendTab);
        legendTab.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(forecastDescriptionLabel)
                        .addGap(30, 30, 30)
                        .addComponent(dayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nightLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mistLabel)
                                    .addComponent(snowLabel)
                                    .addComponent(thunderLabel)
                                    .addComponent(rainLabel)
                                    .addComponent(showerLabel)
                                    .addComponent(brokenCloudLabel)
                                    .addComponent(scatteredLabel)
                                    .addComponent(fewCloudsLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fewCloudsDayIcon)
                                    .addComponent(scatteredDayIcon)
                                    .addComponent(brokenCloudsDayIcon)
                                    .addComponent(showerDayIcon)
                                    .addComponent(rainDayIcon)
                                    .addComponent(thunderDayIcon)
                                    .addComponent(snowDayIcon)
                                    .addComponent(mistDayIcon)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(clearSkiesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearSkiesDayIcon)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(clearSkiesNightIcon))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fewCloudsNightIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(scatteredNightIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(brokenCloudsNightIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(showerNightIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rainNightIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(thunderNightIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(snowNightIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mistNightIcon, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(weatherIconLegendLabel)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(weatherIconLegendLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forecastDescriptionLabel)
                    .addComponent(dayLabel)
                    .addComponent(nightLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearSkiesLabel)
                    .addComponent(clearSkiesNightIcon)
                    .addComponent(clearSkiesDayIcon))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fewCloudsLabel)
                    .addComponent(fewCloudsDayIcon)
                    .addComponent(fewCloudsNightIcon))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scatteredLabel)
                    .addComponent(scatteredDayIcon)
                    .addComponent(scatteredNightIcon))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brokenCloudLabel)
                    .addComponent(brokenCloudsDayIcon)
                    .addComponent(brokenCloudsNightIcon))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showerLabel)
                    .addComponent(showerDayIcon)
                    .addComponent(showerNightIcon))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rainLabel)
                    .addComponent(rainDayIcon)
                    .addComponent(rainNightIcon))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thunderLabel)
                    .addComponent(thunderDayIcon)
                    .addComponent(thunderNightIcon))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(snowLabel)
                    .addComponent(snowDayIcon)
                    .addComponent(snowNightIcon))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mistLabel)
                    .addComponent(mistDayIcon)
                    .addComponent(mistNightIcon))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Forecast Legend", legendTab);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
		
		if (source == weatherCityButton) {
			if(hasForecastPane) {
				//Forecast Pane up
				updateForecastTab();
			} else {
				//Forecast Pane not up
				if (!(weatherCityField.getText().equals(""))){
					try {
						locWeatherURL = startURL + "q=" + weatherCityField.getText() + endURL;
						//System.out.println(locWeatherURL);
						usrWeatherData = new ProcessUrl(locWeatherURL);		
						hasWeatherForCity = true;
						location = weatherCityField.getText();
						temperature = toFarenheit(usrWeatherData.getWeatherTemperature());
						humidity = usrWeatherData.getWeatherHumidity();
						
						createForecastLegend();
						createForecastTab();
						//Start the refreshing of ambient part of the User Interface
						int refreshInMinutes = 60000; // 60000 milliseconds == 1 minute
								
						refreshInMinutes *= Integer.parseInt(refreshBox.getSelectedItem().toString());
							        
						Timer refreshTimer = new Timer();
						refreshTimer.scheduleAtFixedRate(new TimerTask(){
							public void run() {
								try{
									usrWeatherData = new ProcessUrl(locWeatherURL);
									usrWeatherData.showWeatherIcon();
									location = weatherCityField.getText();
									temperature = toFarenheit(usrWeatherData.getWeatherTemperature());
									humidity = usrWeatherData.getWeatherHumidity();
									updateForecastTab();
								} catch (Exception e){
						        	e.printStackTrace();
						        	System.err.println("Error with Timer");
						        	JOptionPane.showMessageDialog(null,
						        			"Error with refresh timer",
							        		"alert",
							        		JOptionPane.ERROR_MESSAGE);
								}
							}
						}, 0, refreshInMinutes);
					} catch(Exception e) {
						//e.printStackTrace();
						JOptionPane.showMessageDialog(null,
								"You entered an invalid city!",
								"alert",
								JOptionPane.ERROR_MESSAGE);
					}
				}	
			}	
		}
		
		if (source == weatherZipButton){
			if (hasForecastPane) {
				updateForecastTab();
			} else {
				if (!(zipcodeField.getText().equals("") )) {
					try{
						locWeatherURL = startURL + "zip=" + zipcodeField.getText() + ",us" + endURL;
						//System.out.println(locWeatherURL);
						usrWeatherData = new ProcessUrl(locWeatherURL);
						hasWeatherForCity = true;
						location = weatherCityField.getText();
						temperature = toFarenheit(usrWeatherData.getWeatherTemperature());
						humidity = usrWeatherData.getWeatherHumidity();

                        createForecastLegend();
						createForecastTab();
						//Start the refreshing of ambient part of the User Interface
						int refreshInMinutes = 60000; // 60000 milliseconds == 1 minute
						
				        refreshInMinutes *= Integer.parseInt(refreshBox.getSelectedItem().toString());
				        
				        Timer refreshTimer = new Timer();
				        refreshTimer.scheduleAtFixedRate(new TimerTask(){
				        	public void run() {
				        		try{
				        			usrWeatherData = new ProcessUrl(locWeatherURL);
				        			usrWeatherData.showWeatherIcon();
				        			location = weatherCityField.getText();
									temperature = toFarenheit(usrWeatherData.getWeatherTemperature());
									humidity = usrWeatherData.getWeatherHumidity();
				        			updateForecastTab();
				        		} catch (Exception e){
				        			e.printStackTrace();
		                  System.err.println("Error with Timer");
		                  JOptionPane.showMessageDialog(null,
		                      "Error with refresh timer",
		                      "alert",
		                      JOptionPane.ERROR_MESSAGE);
				        		}
				        	}
				        }, 0, refreshInMinutes);
					} catch(Exception e) {
						//e.printStackTrace();
						JOptionPane.showMessageDialog(null,
								"You entered an invalid zipcode!",
								"alert",
								JOptionPane.ERROR_MESSAGE);
					}
				}			
			}
		}	
	}          
}
