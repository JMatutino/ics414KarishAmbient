import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ProcessUrl {
    private String urlString;
    private URL url;
    public ProcessUrl(String url) throws MalformedURLException {
        this.urlString = url;
        this.url = new URL(urlString);
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

        return content.toString();
    }

    public static void main(String[] args) throws Exception {
        ProcessUrl weatherData = new ProcessUrl("http://api.openweathermap.org/data/2.5/weather?q=Honolulu%2Cus&appid=2de143494c0b295cca9337e1e96b00e0");
        String content = weatherData.getContents();

        System.out.print(content);
    }

}
