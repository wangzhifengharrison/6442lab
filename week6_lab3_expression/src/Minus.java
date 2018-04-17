/**
 * Created by wang on 2018/4/15.
 */
public class Minus extends Expression {

    Expression left;

    public Minus(Expression l){
        left = l;

    }

    @Override
    public String show() {
        return "( "+"-"+"("+left.show()+")"+" )";
    }

    @Override
    public int evaluate() {
        return -left.evaluate();
    }
}
