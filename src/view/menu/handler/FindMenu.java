package view.menu.handler;

import java.util.Collection;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.AbstractMenu;
import view.menu.MenuEntry;
import view.menu.handler.impl.find.FindByFuelConsumption;
import view.menu.handler.impl.find.FindEntryFactory;
import view.menu.handler.impl.find.SupportedFindOperationsEnum;
import view.util.Printer;
import contoller.functools.Filter;
import contoller.functools.Predicate;
import contoller.util.input.UserInput;
import contoller.util.input.enums.SupportedInputTypesEnum;

// TODO: Think about how to extend from AbstractMenu 
// TODO: sleep ZZzzzz.
// TODO: add field Filter, and just specify predicate for it; Forget about Finder
public class FindMenu extends AbstractMenu {

    private double to;
    private double from;

    private Predicate<Raise> rangePredicate;

    public FindMenu() {
	// #1
	addMenu(new FindByFuelConsumption(this));
	// #2
	addMenu(FindEntryFactory.getInstance(this, SupportedFindOperationsEnum.FIND_BY_CARGO));
	// #3
	addMenu(new MenuEntry() {
	    @Override
	    public String getTitle() {
		return "... with passengers count in range";
	    }

	    @Override
	    public void execCommand(AirplaneCompany arg) {
		updateRangeParameters("passengers");
		setRangePredicate(new Predicate<Raise>() {
		    @Override
		    public Boolean apply(Raise arg) {
			int pass = arg.getAirplane().getPassengersCount();
			return pass > getFrom() && pass < getTo();
		    }
		});
	    }
	});
    }

    // TODO: Watch for exceptions.
    public void updateRangeParameters(String parameterName, SupportedInputTypesEnum typeOfInput) {
	 Number from = UserInput.getChoise("With " + parameterName
		+ " from: ", typeOfInput);
	 Number to = UserInput.getChoise("With " + parameterName
			+ " to: ", typeOfInput);
	 if (from == null || to == null)
	     throw new IllegalArgumentException("One of args is not initialized.");
	 if (from.doubleValue() > to.doubleValue())
	     throw new IllegalStateException("Range start > end. How it can be?");
	 
	setFrom(from.doubleValue());
	setTo(to.doubleValue());
//	setFrom(Double.parseDouble(UserInput.getChoise("With " + parameterName + " from: ")));
//	setTo(Double.parseDouble(UserInput.getChoise("With " + parameterName + " to: ")));
    }
    public void updateRangeParameters(String parameterName) {
	updateRangeParameters(parameterName, SupportedInputTypesEnum.DOUBLE);
    }
    @Override
    public void execCommand(AirplaneCompany airCompany) {
	super.execCommand(airCompany);
	System.out.printf("Searching range: [%.3f, %.3f]\n", getFrom(), getTo());
	Collection<Raise> found = Filter.filter(airCompany, getRangePredicate());
	if (found.size() > 0)
	    Printer.print(found);
	else
	    System.out.println("Sorry, i can\'t find here such airplanes.");
    }

    @Override
    public String getTitle() {
	return "Find Airplanes ...";
    }

    public void setTo(double to) {
	this.to = to;
    }

    public double getTo() {
	return to;
    }

    public void setFrom(double from) {
	this.from = from;
    }

    public double getFrom() {
	return from;
    }

    public void setRangePredicate(Predicate<Raise> rangePredicate) {
	this.rangePredicate = rangePredicate;
    }

    public Predicate<Raise> getRangePredicate() {
	return rangePredicate;
    }

}