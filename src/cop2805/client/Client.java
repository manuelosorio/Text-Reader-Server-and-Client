package cop2805.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    //main method
    public static void main(String[] args) {
        Gui gui = new Gui();
    }

    public static List<Integer> request(String search) {
        List<Integer> list = new ArrayList<>();
        try {
            Socket socket = new Socket("localhost", 8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(search);
            out.flush();

            InputStreamReader input = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(input);
            String response = bufferedReader.readLine();

            String[] results = response.substring(1, response.length() - 1).split(", ");
            for(String result : results) {
                list.add(Integer.parseInt(result));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
