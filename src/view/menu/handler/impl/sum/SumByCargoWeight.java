package view.menu.handler.impl.sum;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.MenuEntry;
import view.menu.handler.SumMenu;
import contoller.functools.Function;

final class SumByCargoWeight implements MenuEntry {
    private SumMenu menuRef;

    public SumByCargoWeight(SumMenu summaryMenu) {
	menuRef = summaryMenu;
    }

    @Override
    public void execCommand(AirplaneCompany arg) {
	menuRef.setGetterFunc(new Function<Number, Raise>() {
	    @Override
	    public Number invoke(Raise arg) {
		return arg.getAirplane().getCargoWeight();
	    }
	});
    }

    @Override
    public String getTitle() {
	return " ... Cargo Weght";
    }
}