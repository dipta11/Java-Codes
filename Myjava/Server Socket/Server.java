
import java.io.*;
import java.net.*;
public class Server{
    public static void main(String args[]) throws Exception{
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Waiting for Client..................");
        Socket socket = serverSocket.accept();
        System.out.println("The Client has been Connected..");
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println("Hello from Server.");
        out.close();
        socket.close();
        serverSocket.close();
    }
}