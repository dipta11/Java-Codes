import java.util.*;
import java.io.*;
public class FileReading {
    static void UsingBufferedReader(){
        try{
        File file = new File("Example.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String message;
        while((message = br.readLine())!=null){
            System.out.println(message);
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    static void UsingScanner(){
        try{
            File file = new File("Example.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static void usingStream(){
        try{
        DataInputStream dis = new DataInputStream(new FileInputStream("Example.txt"));
        byte [] b = new byte[1024];
        int v  = dis.read(b);

        byte [] sb = new byte[v];
        for(int i=0;i<v;i++){
            sb[i] = b[i];
        }
        
        String sp = new String(sb);
        System.out.println(sp);
        dis.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}


    public static void main(String args[]){
        //UsingBufferedReader();
        //UsingScanner();
        Thread t = Thread.currentThread();
        System.out.println(t);
        usingStream();
    }
}
