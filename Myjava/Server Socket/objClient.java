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
public class objClient{
    public static void main(String args[]) throws IOException , ClassNotFoundException
    {
        Socket socket = new Socket("localhost" , 12345) ;
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        Myobj recievedObj  = (Myobj)in.readObject() ;
        System.out.println("Recieved Object : "+ recievedObj.getId() + " , "+ recievedObj.getName()) ;
        
        in.close() ;
        socket.close() ;

    }
}