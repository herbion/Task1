package view.menu.handler;

import contoller.functools.Function;
import contoller.query.Summator;
import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.AbstractMenu;
import view.menu.MenuEntry;
import view.menu.handler.impl.sum.SumByMaxTakeOff;

public class SummaryMenu extends AbstractMenu {
    private Function<Number, Raise> getterFunction;

    public SummaryMenu() {
	addMenu(new SumByMaxTakeOff(this));
	addMenu(new MenuEntry() {
	    @Override
	    public String getTitle() {
		return " ... Cargo Weght";
	    }

	    @Override
	    public void execCommand(AirplaneCompany arg) {
		setGetterFunc(new Function<Number, Raise>() {
		    @Override
		    public Number invoke(Raise arg) {
			return arg.getAirplane().getCargoWeight();
		    }
		});
	    }
	});
    }

    @Override
    public void execCommand(AirplaneCompany company) {
	super.execCommand(company);
	if (getGetterFunc() != null)
	    System.out.println(Summator.sum(company, getGetterFunc()));
    }

    @Override
    public String getTitle() {
	return "Calculate summary ... ";
    }

    public void setGetterFunc(Function<Number, Raise> sumByField) {
	this.getterFunction = sumByField;
    }

    public Function<Number, Raise> getGetterFunc() {
	return getterFunction;
    }

}
