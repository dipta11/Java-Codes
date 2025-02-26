
import java.io.*;
import java.net.*;
public class ServerByte {
    public static void main(String[] args) throws Exception {
        ServerSocket serversocket = new ServerSocket(12345);
        System.out.println("Waiting for Client.......");

        Socket socket =  serversocket.accept();
        System.out.println("Client is connected");
        
        String message = "Hello From Server";
        byte[]bytemessage = message.getBytes("UTF-8");
        
        OutputStream out = socket.getOutputStream();
        out.write(bytemessage);
        out.close();
        socket.close();
        serversocket.close();
    }
}
