package cop2805.client;

import cop2805.helper.Bits;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        new Gui();
    }

    public static HashMap<Integer, String> request(String search) {
        HashMap<Integer, String> map = new HashMap<>();
        try {
            Socket socket = new Socket("localhost", 8080);
            PrintWriter output = new PrintWriter(socket.getOutputStream());
                output.println(search);
                output.flush();

            InputStreamReader input = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(input);

            String response = bufferedReader.readLine();

            String[] pairs = response.replace("{", "").replace("}", "").split(",");
            for (String pair : pairs) {
                if (pair.length() > 0) {
                    String[] split2 = pair.split("=");
                    Integer key = Integer.parseInt(split2[0].trim());
                    String value = split2[1].replace((char) Bits.COMMA, ',').trim();
                    map.put(key, value);
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
