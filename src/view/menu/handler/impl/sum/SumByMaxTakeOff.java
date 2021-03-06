/**
 * 
 */
package view.menu.handler.impl.sum;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.MenuEntry;
import view.menu.handler.SumMenu;
import contoller.functools.Function;

final public class SumByMaxTakeOff implements MenuEntry {
    private final SumMenu menuRef;

    public SumByMaxTakeOff(SumMenu summaryMenu) {
	menuRef = summaryMenu;
    }

    @Override
    public void execCommand(AirplaneCompany arg) {
	menuRef.setGetterFunc(new Function<Number, Raise>() {
	    @Override
	    public Number invoke(Raise arg) {
		return arg.getAirplane().getMaximumTakeoffWeight();
	    }
	});
    }

    @Override
    public String getTitle() {
	return " ... Takeoff Weight";
    }
}