import java.text.ParseException;

public abstract class Tokenizer {

	abstract boolean hasNext();

	abstract Object current();

	abstract void next();

	public void parse(Object o) throws ParseException {
		if (current() == null || !current().equals(o))
			throw new ParseException("1",1);
		next();
	}

}
