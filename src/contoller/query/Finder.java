package contoller.query;

import java.util.Collection;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import model.airplane.Airplane;
import contoller.functools.Filter;
import contoller.functools.Predicate;
// TODO: Think about it.
@Deprecated // Use contoller.functools.Filter
public class Finder  {

    public Collection<Raise> find(AirplaneCompany aircompany, final Double from, final Double to) {
	if (from < 0 || to < 0 || from > to)
	    throw new IllegalArgumentException("Wrong arguments."); // throw new IllegalStateException()
	return Filter.filter(aircompany, new Predicate<Raise>() {
	    @Override
	    public Boolean apply(Raise raise) {
		Airplane air = raise.getAirplane();
		double fuelConsumption = air.getMaximumFuelCapacity()
			/ (double) air.getMaximumRange();
		return fuelConsumption >= from && fuelConsumption <= to;
	    }
	});
    }
    
}
