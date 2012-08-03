package view.menu.handler.impl.find;

import view.menu.MenuEntry;
import view.menu.handler.FindMenu;

public class FindEntryFactory {

    public static MenuEntry getInstance(final FindMenu menuRef,
	    SupportedFindOperationsEnum type) {
	switch (type) {
	case FIND_BY_CARGO:
	    return new FindByCargo(menuRef);
	case FIND_BY_FUEL_CONSUMPTION:
	    return new FindByFuelConsumption(menuRef);
	}

	return null;

    }

}
