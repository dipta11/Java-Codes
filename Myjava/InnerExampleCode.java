 public interface InnerExampleCode {
    static int x;
    final int y;
    void demo ();

  //public void addDemo ();

}

class Defi implements InnerExampleCode{

   public  void demo () {
        //x = 67;
        System.out.println("demo function here " + x);
    }

   void newFunc() {
     int z = x + y;
   }
}
public class Example{

  public static void main (String[] args) {
       InnerExampleCode inExp = new Defi(); 
       inExp.demo();
  }
} 