import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * Tokenizer - this uses the StreamTokenizer class to make a simpler tokenizer
 * which provides a stream of tokens which are either Integer, Double, or
 * String.
 * 
 * @author Eric McCreath
 * 
 */

public class MathTokenizer extends Tokenizer {

	private Object current;
	private StreamTokenizer st;

	public enum TokenType {
		INTLIT, PLUS, MINUS, MULT, DIV, LBRA, RBRA
	}

	TokenType intlit= TokenType.INTLIT;
	TokenType plus = TokenType.PLUS;
	TokenType minus = TokenType.MINUS;
	TokenType mult = TokenType.MULT;
	TokenType div = TokenType.DIV;
	TokenType lbra = TokenType.LBRA;
	TokenType rbra = TokenType.RBRA;

	public MathTokenizer(String data) {
		st = new StreamTokenizer(new StringReader(data));
		st.ordinaryChar('-');  // Don't parse minus as part of numbers.
		st.ordinaryChar('/');  // Don't treat slash as a comment start.
		st.ordinaryChar('(');  // Don't parse minus as part of numbers.
		st.ordinaryChar(')');  // Don't treat slash as a comment start.
		next();
	}

	boolean hasNext() {
		return current != null;
	}

	Object current() {
		return current;
	}

	// next - moves onto the next token, thus the current token should be
	// consumed. 把字符串变成对应的整数和字符串类型的文字。
	void next() {
		int ttype;
		try {
			ttype = st.nextToken();
		} catch (IOException e) {
			current = null;
			return;
		}

		////nextToken方法读取下一个Token.
		//TT_EOF指示已读到流末尾的常量。
		if (ttype == StreamTokenizer.TT_EOF) {
			current = null;
		} else if (ttype == StreamTokenizer.TT_WORD) { //TT_WORD指示已读到一个文字标记的常量
			current = st.sval;// 如果当前标记是一个文字标记，sval字段包含一个给出该文字标记的字符的字符串
		} else if (ttype == StreamTokenizer.TT_NUMBER ) {//如果当前标记是一个数字，nval字段将包含该数字的值
			current = intlit.toString()+" "+(int) Math.floor(st.nval);
		} else {
			if((char)ttype=='*'){current=mult.toString();}//如果以上3中类型都不是，则为英文的标点符号
			if((char)ttype=='+'){current=plus.toString();}
			if((char)ttype=='-'){current=minus.toString();}
			if((char)ttype=='/'){current=div.toString();}
			if((char)ttype=='('){current=lbra.toString();}
			if((char)ttype==')'){current=rbra.toString();}
		}
	}
}
