package contoller.functools;

import java.util.Collection;

/**
 * @author me
 * 
 *         I'm ugly Reduce class, because of poor java generic system. :'(
 * 
 */
public class Reduce {
    public static <F extends Number, T> Double reduce(Collection<T> raises,
	    Function<F, T> func) {
	Double result = 0d;
	// FIXME: smells like overflow can be here
	for (T raise : raises)
	    result += ((Number) func.invoke(raise)).doubleValue();
	return result;
    }
}