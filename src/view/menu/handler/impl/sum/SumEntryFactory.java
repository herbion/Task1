package view.menu.handler.impl.sum;

import view.menu.MenuEntry;
import view.menu.handler.SumMenu;

public class SumEntryFactory {
    public static MenuEntry getInstance(final SumMenu menuRef,
	    SupportedSumOperationsEnum type) {
	switch (type) {
	case SUM_BY_CARGO_WEIGHT:
	    return new SumByCargoWeight(menuRef);
	case SUM_BY_MAX_TAKE_OFF:
	    return new SumByMaxTakeOff(menuRef);
	}

	return null;

    }
}
