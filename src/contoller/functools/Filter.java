package contoller.functools;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;

public abstract class Filter {
    // public static Collection<Raise> filter(AirplaneCompany aircompany,
    // Predicate<Raise> predicate) {
    // Collection<Raise> filtered = new LinkedList<Raise>();
    // for (Raise raise : aircompany.getRaiseDataBase())
    // if (predicate.apply(raise))
    // filtered.add(raise);
    // return filtered;
    // }
    public static Map<Long, Raise> filter(AirplaneCompany aircompany,
	    Predicate<Map.Entry<Long, Raise>> predicate) {
	Map<Long, Raise> filtered = new LinkedHashMap<Long, Raise>();

	for (Entry<Long, Raise> raise : aircompany.getRaiseDataBase()
		.entrySet())
	    if (predicate.apply(raise))
		filtered.put(raise.getKey(), raise.getValue());
	return filtered;
    }
}
