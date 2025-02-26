
import java.io.*;
import java.util.Scanner;

 public class Filehandling {
    public static void main(String[] args) {
        File file = new File("Demo.txt");
        File file2 = new File("C:/Users/ACER/Documents/teach.txt");
        File dir = new File("C:/Users/ACER/Documents/Newdirectoey");
        dir.mkdir();
        try {
            file.createNewFile();
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = dir.getAbsolutePath();
        System.out.println(path);
        System.out.println(file.getName());
        if (file.exists()) {
            System.out.println("exists");
        } else {
            System.out.println("not exists");
        }
////////////Filewriter
//        try {
//            FileWriter fw = new FileWriter(file, true);
//            int a, b, c, d;
//            Scanner sc = new Scanner(System.in);
//            a = sc.nextInt();
//            b = sc.nextInt();
//            c = sc.nextInt();
//            d = sc.nextInt();
//            fw.write(a + " " + b + " " + c + " " + d + "\n");
//            fw.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        ////Buffered writer////////////
try{
    BufferedWriter bfw = new BufferedWriter( new FileWriter(file,true));
    int a,b,c,d;
    Scanner sc = new Scanner(System.in);
     a = sc.nextInt();
     b = sc.nextInt();
    c  = sc.nextInt();
     d = sc.nextInt();
     bfw.write("Ghashkata");
     bfw.newLine();
     bfw.close();
}catch(Exception e){
    e.printStackTrace();
}



//////// Scanner////////
//        try{
//            int sum = 0;
//            Scanner sc = new Scanner(file);
//            while(sc.hasNext()){
//                sum += sc.nextInt();
//            }
//            System.out.println(sum);
//        }catch(
//                FileNotFoundException e){
//            e.printStackTrace();
//        }

////BUffered reader    //////////////////
        try{
            int sum = 0;
            String line;
            BufferedReader bf = new BufferedReader(new FileReader(file));
            while((line = bf.readLine())!=null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        file2.delete();
        dir.delete();
    }


//         Stream////////////////
//        try (DataInputStream dis = new DataInputStream(new FileInputStream("demo.txt"))) {
//            while(true){
//                byte b [] = new byte[1024];
//                int v  = dis.read(b);  //// Rturns  the value of total number of characters
//                System.out.println("v = " + v);
//                if(v == -1) break;
//                String s = new String(b);     //converts byte array to string but unncecessary null characters come out
//                System.out.println(s);
//
//                byte sb[] = new byte[v];
//                for(int i=0; i<v; i++){
//                    sb[i] = b[i];      ///new array created just for the valid characters
//                }
//                String ns = new String(sb);
//                System.out.println(ns);         /// Printed without extra nulls.
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
