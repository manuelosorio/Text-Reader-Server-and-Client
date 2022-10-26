package cop2805.server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.HashMap;
import java.util.List;

public class Server {
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    private boolean shutdown = false;

    public static void main(String[] args) {
        Server server = new Server();
        server.await();
    }
    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress
                    .getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!shutdown) {
            Socket socket;
            InputStreamReader input;
            OutputStream output;
            try {
                socket = serverSocket.accept();
                input = new InputStreamReader(socket.getInputStream());
                output = socket.getOutputStream();

                BufferedReader bufferedReader = new BufferedReader(input);
                String request = bufferedReader.readLine();

                WorldSearcher worldSearcher = new WorldSearcher();
                List<Integer> results = worldSearcher.search(request);
                HashMap<Integer, String> map = worldSearcher.getLines(results);
                output.write(map.toString().getBytes());
                socket.close();
                shutdown = request.contains(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

        }
    }
}
