/**
 * Created by wang on 2018/4/15.
 */
public class Mult extends Expression {

    Expression left, right;

    public Mult(Expression l,Expression r){
        left= l;
        right=r;
    }

    public String show(){

        return "( "+left.show()+"* "+right.show()+" )";

    }

    @Override
    public int evaluate() {
        return left.evaluate()*right.evaluate();
    }
}
