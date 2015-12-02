package ics414;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ProcessUrl {
    private String urlString;
    private URL url;
    private String content;

    public ProcessUrl(String url) throws Exception {
        this.urlString = url;
        this.url = new URL(urlString);
        getContents();
    }

    public String getContents() throws IOException {
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder content = new StringBuilder();

        String input;
        while ((input = in.readLine()) != null) {
            //System.out.println(input);
            content.append(input);
        }
        in.close();

        this.content = content.toString();

        if(this.content.length() <= 0 || this.content == null) {
            System.err.println("ERROR: Did NOT get data from URL");
        }
        else {
            System.out.println(this.content);
        }

        return this.content;
    }

    public int getWeatherId() {
        int location = content.indexOf("id");

        String weatherId = content.substring(location+4,location+7);
        return Integer.parseInt(weatherId);
    }

    public ImageIcon getWeatherIcon() throws IOException {
        int location = content.indexOf("icon");

        String weatherIcon = content.substring(location+7,location+10);

        URL url = new URL("http://openweathermap.org/img/w/"+ weatherIcon +".png");
        BufferedImage img = ImageIO.read(url);
        return new ImageIcon(img);
    }
    
    public void showWeatherIcon() throws IOException {
    	JFrame frame = new JFrame("Transparent Window");
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setAlwaysOnTop(true);
        // Without this, the window is draggable from any non transparent
        // point, including points  inside textboxes.
        frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);

        frame.getContentPane().setLayout(new java.awt.BorderLayout());
        frame.getContentPane().add(new JLabel(getWeatherIcon()), java.awt.BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
        
        javax.swing.Timer timer = new Timer(1000, new ActionListener(){
        	int counter = 0;
        	@Override
        	public void actionPerformed(ActionEvent ae){
        		if(counter > 5) {
        			((Timer) ae.getSource()).stop();
        			frame.dispose();
        		} else {
        			counter++;
        		}
        	}

        });
        timer.start();
    }

    public static void main(String[] args) throws Exception {
    	
        System.out.println("This is a test:");
        ProcessUrl weatherData = new ProcessUrl("http://api.openweathermap.org/data/2.5/weather?q=Honolulu%2Cus&appid=2de143494c0b295cca9337e1e96b00e0");

        System.out.println("Weather ID: " + weatherData.getWeatherId());
        System.out.println("Starting GUI");

        String usrUrl = JOptionPane.showInputDialog("Url for data");
        System.out.println("User input: " + usrUrl);
        String[] choices = {"1", "3", "5", "10", "15", "30", "60"};
        String freq = (String) JOptionPane.showInputDialog(null,
                "Frequency (Minutes): ",
                "Choose frequency ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                choices,
                choices[0]);

        ProcessUrl usrWeatherData = new ProcessUrl(usrUrl);

        String output = "Weather ID: " + usrWeatherData.getWeatherId();

        JOptionPane.showMessageDialog(null,
                output,
                "Output",
                JOptionPane.INFORMATION_MESSAGE,
                usrWeatherData.getWeatherIcon());
        
        usrWeatherData.showWeatherIcon();
        
        javax.swing.Timer refreshTimer = null;
        refreshTimer = new Timer(1000, new ActionListener(){
        	int refreshCounter = 0;
        	@Override
        	public void actionPerformed(ActionEvent ae) {
        		if(refreshCounter > 10) {
        			((Timer) ae.getSource()).stop();
        			try{
        				usrWeatherData.showWeatherIcon();
        			}catch(IOException e){
        				e.printStackTrace();
        			}
        		} else {
        			refreshCounter++;
        		}
        	}
        });
        
        refreshTimer.start();
        
    }
    
    

}
