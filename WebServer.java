// WebServer.java
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class WebServer {
    private final int port;
    private final PageProvider pageProvider;

    public WebServer(int port, PageProvider pageProvider) {
        this.port = port;
        this.pageProvider = pageProvider;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Sunucu çalışıyor: http://localhost:" + port);
            while (true) {
                Socket client = serverSocket.accept();
                handle(client);
            }
        }
    }

    private void handle(Socket client) {
        try (client;
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(client.getInputStream()));
             OutputStream out = client.getOutputStream()) {

            // İsteği oku (başlıkların sonuna kadar)
            String line;
            while ((line = in.readLine()) != null && !line.isEmpty()) {
                System.out.println(line);
            }

            byte[] body = pageProvider.getHtml().getBytes(StandardCharsets.UTF_8);
            String header = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html; charset=UTF-8\r\n"
                    + "Content-Length: " + body.length + "\r\n"
                    + "Connection: close\r\n\r\n";

            out.write(header.getBytes(StandardCharsets.UTF_8));
            out.write(body);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}