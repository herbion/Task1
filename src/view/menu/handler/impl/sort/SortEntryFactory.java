package view.menu.handler.impl.sort;

import view.menu.MenuEntry;
import view.menu.handler.SortMenu;

public class SortEntryFactory {

    public static MenuEntry getInstance(final SortMenu menuRef,
	    SupportedSortOperationsEnum type) {
	switch (type) {
	case BY_CARGO_WEIGHT:
	    return new SortByCargoWeight(menuRef);
	case BY_FLIGHT_RANGE:
	    return new SortByFlightRange(menuRef);
	case BY_SPEED:
	    return new SortBySpeed(menuRef);
	}

	return null;

    }

}
