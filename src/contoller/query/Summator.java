package contoller.query;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import contoller.functools.Function;
import contoller.functools.Reduce;

public class Summator {
    public static Long sum(AirplaneCompany air, Function<? extends Number, Raise> func) {
	return Reduce.reduce(air.getRaiseDataBase(), func).longValue();
    }
}
