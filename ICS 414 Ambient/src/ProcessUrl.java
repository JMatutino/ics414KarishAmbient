import javax.swing.*;
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

    public static void main(String[] args) throws Exception {
        System.out.println("This is a test:");
        ProcessUrl weatherData = new ProcessUrl("http://api.openweathermap.org/data/2.5/weather?q=Honolulu%2Cus&appid=2de143494c0b295cca9337e1e96b00e0");

        System.out.println("Weather ID: " + weatherData.getWeatherId());
        System.out.println("Starting GUI");

        String usrUrl = JOptionPane.showInputDialog("Url for data");
        System.out.println("User input: " + usrUrl);
        String freq = JOptionPane.showInputDialog("Frequency");

        ProcessUrl usrWeatherData = new ProcessUrl(usrUrl);
        String output = "Output from your URL: " + usrWeatherData.getWeatherId();
        JOptionPane.showMessageDialog(null,output);
    }

}
