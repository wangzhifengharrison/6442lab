import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by wang on 2018/4/24.
 */
public class Parser {
    private StreamTokenizer st;
    public enum TokenType {
        INTLIT, PLUS, MINUS, MULT, DIV, LBRA, RBRA
    }

    static TokenType intlit= TokenType.INTLIT;
    TokenType plus = TokenType.PLUS;
    TokenType minus = TokenType.MINUS;
    TokenType mult = TokenType.MULT;
    TokenType div = TokenType.DIV;
    TokenType lbra = TokenType.LBRA;
    TokenType rbra = TokenType.RBRA;
    int ttype;
    String stream_exp;
    ArrayList stream_array= new ArrayList();


public ArrayList Parser(Tokenizer tok){
    // 每个只传送一个字母
    Object t = tok.current();
    if(t.toString()==lbra.toString()){stream_array.add("(");}
    if(t.toString()==plus.toString()){stream_array.add("+");}
    if(t.toString()==mult.toString()){stream_array.add("*");}
    if(t.toString()==minus.toString()){stream_array.add("-");}
    if(t.toString()==div.toString()){stream_array.add("/");}
    if(t.toString()==rbra.toString()){stream_array.add(")");}
    // 得到传送过来的数字
    try{
        StreamTokenizer st = new StreamTokenizer(new StringReader(t.toString()));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            switch (st.ttype){
                case StreamTokenizer.TT_NUMBER:
                    //如果当前标记是一个数字，nval字段将包含该数字的值
                   // stream_array.add((int) Math.floor(st.nval));
                    stream_array.add(String.valueOf((int) Math.floor(st.nval)));
                    break;
            }

        }

    }catch (Exception e) {
        e.printStackTrace();
    }

        return stream_array;
}


}
