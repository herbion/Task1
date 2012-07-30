package contoller.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;

public class Sorter {
    public static Collection<Raise> sort(AirplaneCompany company,
	    Comparator<Raise> customComparator) {
	List<Raise> list = new ArrayList<Raise>(company.getRaiseDataBase());
	Collections.sort(list, customComparator);
	return list;
    }
}
