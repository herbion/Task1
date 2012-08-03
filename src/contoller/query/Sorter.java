package contoller.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;

public class Sorter {
    public static List<Entry<Long, Raise>> sort(AirplaneCompany company,
	    Comparator<Entry<Long, Raise>> comparator) {
	List<Entry<Long, Raise>> list = new ArrayList<Entry<Long, Raise>>(
		company.getRaiseDataBase().entrySet());
	Collections.sort(list, comparator);

	return list;
    }
}
