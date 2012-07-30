/**
 * 
 */
package view.menu.handler.impl.find;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import model.airplane.Airplane;
import view.menu.MenuEntry;
import view.menu.handler.FindMenu;
import contoller.functools.Predicate;

final public class FindByFuelConsumption implements MenuEntry {
    /**
     * 
     */
    private final FindMenu menuRef;

    /**
     * @param newFindMenu
     */
    public FindByFuelConsumption(FindMenu newFindMenu) {
	menuRef = newFindMenu;
    }

    @Override
    public String getTitle() {
	return "... with fuel consumption in range [from,to]";
    }

    @Override
    public void execCommand(AirplaneCompany airCompany) {
	menuRef.updateRangeParameters("fuel consumption");
	menuRef.setRangePredicate(new Predicate<Raise>() {
	    @Override
	    public Boolean apply(Raise raise) {
		Airplane air = raise.getAirplane();
		double fuelConsumption = air.getMaximumFuelCapacity()
			/ (double) air.getMaximumRange();
		return fuelConsumption >= menuRef.getFrom()
			&& fuelConsumption <= menuRef.getTo();
	    }
	});
    }
}