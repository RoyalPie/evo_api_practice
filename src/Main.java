import java.io.*;
import java.net.*;

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

}
public class Main {
    public static void main(String[] args) throws Exception {
        String json = httpUrlRequest.sendGET("https://jsonplaceholder.typicode.com/albums");
        httpUrlRequest.export(json);

    }
}