package view.menu.handler.impl.find;

import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.MenuEntry;
import view.menu.handler.FindMenu;
import contoller.functools.Predicate;
import contoller.util.input.enums.SupportedInputTypesEnum;

final class FindByCargo implements MenuEntry {
    private final FindMenu menuRef;

    FindByCargo(FindMenu menuRef) {
	this.menuRef = menuRef;
    }

    @Override
    public void execCommand(AirplaneCompany airCompany) {
	menuRef.updateRangeParameters("cargo weight",
		SupportedInputTypesEnum.INT);
	menuRef.setRangePredicate(new Predicate<Entry<Long, Raise>>() {
	    @Override
	    public Boolean apply(Entry<Long, Raise> arg) {
		int weight = arg.getValue().getAirplane().getCargoWeight();
		return weight > menuRef.getFrom() && weight < menuRef.getTo();
	    }
	});
    }

    @Override
    public String getTitle() {
	return "... with cargo weight in range [from,to]";
    }
}
