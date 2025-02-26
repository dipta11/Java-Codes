import java.io.*;
import java.net.*;
public class ClientByte {
    public static void main(String args[]) throws Exception{
        Socket socket = new Socket("localhost",12345);
        InputStream in = socket.getInputStream();

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nread;
        
        byte[] data = new byte[1024];
        while ((nread = in.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nread);
        }

        buffer.flush();
        byte[] bytemessage = buffer.toByteArray();
        
        String textMessage = new String(bytemessage, "UTF-8");
        System.out.println("The message form Server = "+textMessage);
        socket.close();
    }
}
