/**
 * Created by wang on 2018/4/23.
 */
public class TokenizeDemo {
    static String e1 = "(2*-4)/3+2";
    public static void main(String[] args) {
        Tokenizer t = new MathTokenizer(e1);
        System.out.print(e1+": " );
        while (t.hasNext()){
            System.out.print(" "+t.current()+", ");
            t.next();
        }
    }
}
