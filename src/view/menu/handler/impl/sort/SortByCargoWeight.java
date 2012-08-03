package view.menu.handler.impl.sort;

import java.util.Comparator;
import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.MenuEntry;
import view.menu.handler.SortMenu;

final class SortByCargoWeight implements MenuEntry {
    private final SortMenu menuRef;

    SortByCargoWeight(SortMenu menuRef) {
	this.menuRef = menuRef;
    }

    @Override
    public void execCommand(AirplaneCompany company) {
	menuRef.setComparator(new Comparator<Entry<Long, Raise>>() {
	    @Override
	    public int compare(Entry<Long, Raise> o1, Entry<Long, Raise> o2) {
		return o1.getValue().getAirplane().getCargoWeight()
			- o2.getValue().getAirplane().getCargoWeight();
	    }
	});
    }

    @Override
    public String getTitle() {
	return " ... Cargo Weight.";
    }
}