import java.io.*;
import java.net.* ;

class Myobj implements Serializable{
    private int id ;
    private String name ;
    public Myobj(int id , String name)
    {
        this.id = id ;
        this.name = name ;
    }
    public int getId(){
        return this.id ;
    }
    public String getName()
    {
        return this.name ;
    }
}
public class ServerObj{
    public static void main(String args[]) throws IOException 
    {
    ServerSocket serversocket = new  ServerSocket(12345) ;
    Socket socket = serversocket.accept() ;
        System.out.println("Client connected ") ;

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        Myobj objtosend = new Myobj(10,"Malda");
        out.writeObject(objtosend) ;
        //out.flush();
        out.close() ;
        socket.close() ;
        serversocket.close() ;
        
    }
}