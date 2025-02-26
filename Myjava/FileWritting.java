import java.io.*;
import java.util.*;

public class FileWritting {
    static void usingFileWriter() {
        try{
        File file = new File("Example.txt");
        FileWriter fw = new FileWriter(file, true);
        
        Scanner sc = new Scanner(System.in);
        
        //String a = sc.nextLine();
        //String b = sc.nextLine();

        fw.write("Hello!\n");
        fw.write("Ghashkata\n");
        fw.write("Dance deo\n");
        //fw.write(a+" " + b);
        fw.close();
        sc.close();
        }catch(IOException e){
            e.printStackTrace();
        }
       
    }
    

    static void UsingBufferedWriter(){
        try{
        BufferedWriter bf = new BufferedWriter(new FileWriter("Example.txt",true));
        
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        
        bf.write(message);
        bf.close();
        sc.close();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        //usingFileWriter();
        UsingBufferedWriter();

    }
}
