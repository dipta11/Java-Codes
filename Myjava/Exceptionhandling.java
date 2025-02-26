import java.io.*;
import java.util.*;
class GhashkataException extends Exception{
    @Override
    public String toString() {
        return "I am Ghashkata Exception";
    }

    @Override
    public String getMessage() {
        return "I am getMessage of Ghashkata Exception";
    }
}
class MaldaException extends Exception{
    @Override
    public String toString() {
        return "I am Malda Exception";
    }

    @Override
    public String getMessage() {
        return "I am getMessage of Malda Excetion";
    }

   
}
class Testing{
    static void test() throws MaldaException{
        //MaldaException me = new MaldaException();
        MaldaExceeption.initCause(GhashkataException);
       // me.initCause(new GhashkataException());
        System.out.println("No exception");
        throw new MaldaException();
    }
    static void nest(){
        try{
           throw new MaldaException();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getCause());;
        }
    }
}

public class Exceptionhandling {
    public static void main(String[] args) {
        try {
            Testing.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
