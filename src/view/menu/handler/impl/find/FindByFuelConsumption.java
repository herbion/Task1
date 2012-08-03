/**
 * 
 */
package view.menu.handler.impl.find;

import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import model.airplane.Airplane;
import view.menu.MenuEntry;
import view.menu.handler.FindMenu;
import contoller.functools.Predicate;

final class FindByFuelConsumption implements MenuEntry {
    /**
     * 
     */
    private final FindMenu menuRef;

    /**
     * @param newFindMenu
     */
    FindByFuelConsumption(FindMenu newFindMenu) {
	menuRef = newFindMenu;
    }

    @Override
    public void execCommand(AirplaneCompany airCompany) {
	menuRef.updateRangeParameters("fuel consumption");
	menuRef.setRangePredicate(new Predicate<Entry<Long, Raise>>() {
	    @Override
	    public Boolean apply(Entry<Long, Raise> arg) {
		Airplane air = arg.getValue().getAirplane();
		double fuelConsumption = air.getMaximumFuelCapacity()
			/ (double) air.getMaximumRange();
		return fuelConsumption >= menuRef.getFrom()
			&& fuelConsumption <= menuRef.getTo();
	    }
	});
    }

    @Override
    public String getTitle() {
	return "... with fuel consumption in range [from,to]";
    }
}