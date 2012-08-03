package view.menu.handler.impl.sort;

import java.util.Comparator;
import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.MenuEntry;
import view.menu.handler.SortMenu;

final class SortByFlightRange implements MenuEntry {
    private final SortMenu menuRef;

    SortByFlightRange(SortMenu menuRef) {
	this.menuRef = menuRef;
    }

    @Override
    public void execCommand(AirplaneCompany company) {
	menuRef.setComparator(new Comparator<Entry<Long, Raise>>() {
	    @Override
	    public int compare(Entry<Long, Raise> o1, Entry<Long, Raise> o2) {
		return (int) (o1.getValue().getAirplane().getMaximumRange() - o2
			.getValue().getAirplane().getMaximumRange());
	    }
	});
    }

    @Override
    public String getTitle() {
	return " ... Flight Range.";
    }
}