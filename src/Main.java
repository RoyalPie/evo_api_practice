import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;


class httpUrlRequest {
    public static String sendGET(String urlToSend) throws Exception{
        StringBuilder res = new StringBuilder();
        URL url = new URL(urlToSend);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                res.append(line);
            }
        }
        return res.toString();
    }
    public static String[] display(String jsonString){
        jsonString = jsonString.trim().substring(1, jsonString.length() - 1);
        String[] items = jsonString.split("},\\s*\\{");

        for (String item : items) {
            System.out.println(item);
        }
        return items;
    }
    public static void export(String jsonString){
        try {
            String dirName = "C:\\Users\\Hello\\IdeaProjects\\API_Java_Test";

            String fileName = "albumsURL.txt";
            File dir = new File (dirName);
            File actualFile = new File (dir, fileName);
            FileWriter myWriter = new FileWriter(actualFile);

            String[] items = httpUrlRequest.display(jsonString);
            for(String i : items){
                myWriter.append(i+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

class httpClient{
    public static HttpResponse<String> sendGET(String urlToSend) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlToSend))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response body: " + response.body());
        return response;
    }

    public static void export(HttpResponse<String> response){
        try {
            String dirName = "C:\\Users\\Hello\\IdeaProjects\\API_Java_Test";

            String fileName = "albumsClient.txt";
            File dir = new File (dirName);
            File actualFile = new File (dir, fileName);
            FileWriter myWriter = new FileWriter(actualFile);
            myWriter.write(response.body());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
interface Test {
    public String sayHello();
}

public class Main {
    public static void main(String[] args) throws Exception {
//        String json = httpUrlRequest.sendGET("https://jsonplaceholder.typicode.com/albums");
//        httpUrlRequest.export(json);
//        HttpResponse<String> res = httpClient.sendGET("https://jsonplaceholder.typicode.com/albums");
//        httpClient.export(res);
        Duration threeHours = Duration.ofHours(3);
        Time time = Time.valueOf("09/01/2012");
        System.out.println(time);

    }
}