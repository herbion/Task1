package view.menu.handler;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.AbstractMenu;
import view.menu.handler.impl.sum.SumEntryFactory;
import view.menu.handler.impl.sum.SupportedSumOperationsEnum;
import contoller.functools.Function;
import contoller.query.Summator;

public class SumMenu extends AbstractMenu {
    private Function<Number, Raise> getterFunction;

    public SumMenu() {
	addMenu(SumEntryFactory.getInstance(this,
		SupportedSumOperationsEnum.SUM_BY_CARGO_WEIGHT));
	addMenu(SumEntryFactory.getInstance(this,
		SupportedSumOperationsEnum.SUM_BY_MAX_TAKE_OFF));
    }

    @Override
    public void execCommand(AirplaneCompany company) {
	super.execCommand(company);
	if (getGetterFunc() != null)
	    System.out.println(">>> Summary: "
		    + Summator.sum(company, getGetterFunc()));
    }

    public Function<Number, Raise> getGetterFunc() {
	return getterFunction;
    }

    @Override
    public String getTitle() {
	return "Calculate summary ... ";
    }

    public void setGetterFunc(Function<Number, Raise> sumByField) {
	this.getterFunction = sumByField;
    }

}
