package contoller.functools;

import java.util.Collection;
import java.util.LinkedList;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;


public abstract class Filter {
    public static Collection<Raise> filter(AirplaneCompany aircompany, Predicate<Raise> predicate) {
	Collection<Raise> filtered = new LinkedList<Raise>();
	for (Raise raise : aircompany.getRaiseDataBase())
	    if (predicate.apply(raise))
		filtered.add(raise);
	return filtered;
    }
}
