class Outer{
    int y;
    Outer(int m){
        y = m;
    }
    void print(){
        System.out.println(y);
        System.out.println(x);
    }
    class Inner{
        int x;
        Inner(int val){
            x = val;
        }
        void printTwo(){
            System.out.println(y);
            System.out.println(x);
        }
    }
}