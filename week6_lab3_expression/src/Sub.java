/**
 * Created by wang on 2018/4/15.
 */
public class Sub extends Expression {

    Expression left, right;

    public Sub(Expression l,Expression r){
        left = l;
        right = r;
    }

    @Override
    public String show() {
        return "( "+left.show()+"- "+"("+right.show()+")"+" )";
    }

    @Override
    public int evaluate() {
        return left.evaluate()-right.evaluate();
    }


}
