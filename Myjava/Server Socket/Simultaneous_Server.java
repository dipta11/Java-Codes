import java.io.*;
import java.net.*;
import java.util.*;
class SendingThread extends Thread{
    Socket socket;
  SendingThread(Socket socket, String name){
    super(name);
    this.socket = socket;
    start();
  }
  public void run(){
    try{
    PrintWriter out = new PrintWriter(socket.getOutputStream(),true); 
    Scanner sc = new Scanner(System.in);
    while(true){
    String sendmessage = sc.nextLine();
    // if(sendmessage.equals("exit")){
    //     socket.close();
    // }
    out.println("From Server : "+sendmessage);
 } 
}catch(Exception e){
    e.printStackTrace();
 }
} 
}

class ReceivingThread extends Thread{
    Socket socket;
    ReceivingThread( Socket socket,String name){
        super(name);
        this.socket = socket;
        start();
    }
    public void run(){
        try{
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
        while(true){
            String message = in.readLine();
            System.out.println(" Receiving message from Client :"+message);
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
}

}
public class Simultaneous_Server{
    public static void main(String args[]) throws Exception{
        ServerSocket ssk = new ServerSocket(9999);
        System.out.println("Waiting for Client");

        Socket socket = ssk.accept();
        System.out.println("Cilent conneccted");
        
         new SendingThread(socket,"sending");
         new ReceivingThread(socket,"receiving");   
         ssk.close();
        }
}
  