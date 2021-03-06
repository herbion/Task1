/**
 * 
 */
package view.menu.handler.impl.sort;

import java.util.Comparator;
import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.MenuEntry;
import view.menu.handler.SortMenu;

final class SortBySpeed implements MenuEntry {
    /**
     * 
     */
    private final SortMenu menuRef;

    /**
     * @param sortMenu
     */
    public SortBySpeed(SortMenu sortMenu) {
	menuRef = sortMenu;
    }

    @Override
    public void execCommand(AirplaneCompany arg) {
	menuRef.setComparator(new Comparator<Entry<Long, Raise>>() {

	    @Override
	    public int compare(Entry<Long, Raise> o1, Entry<Long, Raise> o2) {
		return o1.getValue().getAirplane().getTypicalCruiseSpeed()
			- o2.getValue().getAirplane().getTypicalCruiseSpeed();
	    }
	});
    }

    @Override
    public String getTitle() {
	return " ... Cruise Speed.";
    }
}