// Main.java
public class Main {
    public static void main(String[] args) throws Exception {
        PageProvider page = new BioPageProvider();
        WebServer server = new WebServer(1989, page);
        server.start();
    }
}