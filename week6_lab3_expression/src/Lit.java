/**
 * Created by wang on 2018/4/15.
 */
public class Lit extends Expression {
    int value;

    public Lit(int v){
        value=v;
    }

     public String show(){
         return " "+value;
     }

     public int evaluate(){
         return value;
     }

}
