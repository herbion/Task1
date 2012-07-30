/**
 * 
 */
package view.menu.handler.impl.sum;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.MenuEntry;
import view.menu.handler.SummaryMenu;
import contoller.functools.Function;

final public class SumByMaxTakeOff implements MenuEntry {
    /**
     * 
     */
    private final SummaryMenu menuRef;

    /**
     * @param summaryMenu
     */
    public SumByMaxTakeOff(SummaryMenu summaryMenu) {
	menuRef = summaryMenu;
    }

    @Override
    public String getTitle() {
	return " ... Takeoff Weight";
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
}