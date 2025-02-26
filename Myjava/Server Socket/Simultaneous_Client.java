import java.net.*;
import java.io.*;
import java.util.*;
class SendingClient extends Thread {
    Socket socket;

    SendingClient(Socket socket, String name) {
        super(name);
        this.socket = socket;
        start();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            while(true){
            String sendmessage = sc.nextLine();
            // if(sendmessage.equals("Exit")){
            //     socket.close();
            // }
            out.println("From Client : "+sendmessage);
            // try {
            //     Thread.sleep(500);
            // } catch (Exception e) {
            //     e.printStackTrace();
            // }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ReceivingClient extends Thread{
    Socket socket;
    ReceivingClient( Socket socket,String name){
        super(name);
        this.socket = socket;
        start();
    }
    public void run(){
        try{
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while(true){
            String message = in.readLine();
            System.out.println("Receiving message from Server :: "+message);
        }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
public class Simultaneous_Client {
 public static void main(String args[]) throws Exception {
    Socket socket = new Socket("localhost",9999);
    
     new SendingClient(socket, "sending");
     new ReceivingClient( socket,"receiving");
 }
}
