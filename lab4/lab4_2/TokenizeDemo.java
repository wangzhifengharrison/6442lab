import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by wang on 2018/4/23.
 */
public class TokenizeDemo {
    static String e1 = "(3+4+9)";
    public static void main(String[] args) throws ParseException {
        Tokenizer t = new MathTokenizer(e1);
        ArrayList exptwo_list = new ArrayList();
      //Expression expression_1 = Expression.parse(t);
        while (t.hasNext()){
            Parser aa =new Parser();
            exptwo_list.add(aa.Parser(t).get(0).toString());
            System.out.print(t.current()+",");
            t.next();
        }

        StringBuilder sb = new StringBuilder();
        for (Object s : exptwo_list)
        {
            sb.append(s);
        }

        stack s = new stack();
        String expression = sb.toString();
        int data = s.evaluateExpression(expression);
        System.out.println(expression+" = "+data);


    }
}
