
import java.io.*;
import java.net.*;
public class Client{
    public static void main(String args[]) throws Exception{
    Socket socket = new Socket("localhost",12345);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String message = in.readLine();
    System.out.println("Server's message "+message);
    in.close();
    socket.close();
    }
}
