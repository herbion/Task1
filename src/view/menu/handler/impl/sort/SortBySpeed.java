/**
 * 
 */
package view.menu.handler.impl.sort;

import java.util.Comparator;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.MenuEntry;
import view.menu.handler.SortMenu;

final public class SortBySpeed implements MenuEntry {
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
    public String getTitle() {
	return " ... Cruise Speed.";
    }

    @Override
    public void execCommand(AirplaneCompany arg) {
	menuRef.setComparator(new Comparator<Raise>() {
	    @Override
	    public int compare(Raise o1, Raise o2) {
		return o1.getAirplane().getTypicalCruiseSpeed()
			- o2.getAirplane().getTypicalCruiseSpeed();
	    }
	});
    }
}