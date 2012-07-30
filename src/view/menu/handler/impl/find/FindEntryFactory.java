package view.menu.handler.impl.find;

import contoller.functools.Predicate;
import contoller.util.input.enums.SupportedInputTypesEnum;
import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.MenuEntry;
import view.menu.handler.FindMenu;

public class FindEntryFactory {
    public static MenuEntry getInstance(final FindMenu menuRef,
	    SupportedFindOperationsEnum type) {
	switch (type) {
	case FIND_BY_CARGO:
	    return new MenuEntry() {
		@Override
		public String getTitle() {
		    return "... with cargo weight in range [from,to]";
		}
		@Override
		public void execCommand(AirplaneCompany airCompany) {
		    menuRef.updateRangeParameters("cargo weight", SupportedInputTypesEnum.INT);
		    menuRef.setRangePredicate(new Predicate<Raise>() {
			@Override
			public Boolean apply(Raise arg) {
			    int weight = arg.getAirplane().getCargoWeight();
			    return weight > menuRef.getFrom()
				    && weight < menuRef.getTo();
			}
		    });
		}
	    };
	case FIND_BY_FUEL_CONSUMPTION:
	    return new FindByFuelConsumption(menuRef);
	}

	return null;

    }

}
