package view.menu.handler;

import java.util.Map;
import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.AbstractMenu;
import view.menu.MenuEntry;
import view.menu.handler.impl.find.FindEntryFactory;
import view.menu.handler.impl.find.SupportedFindOperationsEnum;
import view.util.Printer;
import contoller.functools.Filter;
import contoller.functools.Predicate;
import contoller.util.input.UserInput;
import contoller.util.input.enums.SupportedInputTypesEnum;

public class FindMenu extends AbstractMenu {

    private double to;
    private double from;

    private Predicate<Entry<Long, Raise>> rangePredicate;

    public FindMenu() {
	addMenu(FindEntryFactory.getInstance(this,
		SupportedFindOperationsEnum.FIND_BY_FUEL_CONSUMPTION));
	addMenu(FindEntryFactory.getInstance(this,
		SupportedFindOperationsEnum.FIND_BY_CARGO));
	addMenu(new MenuEntry() {
	    @Override
	    public void execCommand(AirplaneCompany arg) {
		updateRangeParameters("passengers");
		setRangePredicate(new Predicate<Entry<Long, Raise>>() {
		    @Override
		    public Boolean apply(Entry<Long, Raise> arg) {
			int pass = arg.getValue().getAirplane()
				.getPassengersCount();
			return pass > getFrom() && pass < getTo();
		    }
		});
	    }

	    @Override
	    public String getTitle() {
		return "... with passengers count in range (from, to)";
	    }
	});
    }

    @Override
    public void execCommand(AirplaneCompany airCompany) {
	super.execCommand(airCompany);
	System.out
		.printf("Searching range: [%.3f, %.3f]\n", getFrom(), getTo());
	Map<Long, Raise> found = Filter.filter(airCompany, getRangePredicate());
	if (found.size() > 0)
	    Printer.print(found);
	else
	    System.out.println("Sorry, i can\'t find here such airplanes.");
    }

    public double getFrom() {
	return from;
    }

    public Predicate<Entry<Long, Raise>> getRangePredicate() {
	return rangePredicate;
    }

    @Override
    public String getTitle() {
	return "Find Airplanes ...";
    }

    public double getTo() {
	return to;
    }

    public void setFrom(double from) {
	this.from = from;
    }

    public void setRangePredicate(Predicate<Entry<Long, Raise>> rangePredicate) {
	this.rangePredicate = rangePredicate;
    }

    public void setTo(double to) {
	this.to = to;
    }

    public void updateRangeParameters(String parameterName) {
	updateRangeParameters(parameterName, SupportedInputTypesEnum.DOUBLE);
    }

    public void updateRangeParameters(String parameterName,
	    SupportedInputTypesEnum typeOfInput) {
	Number from = UserInput.getChoice("With " + parameterName + " from: ",
		typeOfInput);
	Number to = UserInput.getChoice("With " + parameterName + " to: ",
		typeOfInput);
	if (from == null || to == null)
	    throw new IllegalArgumentException(
		    "One of args is not initialized.");
	if (from.doubleValue() > to.doubleValue())
	    throw new IllegalStateException("Range start > end. How it can be?");

	setFrom(from.doubleValue());
	setTo(to.doubleValue());
	// setFrom(Double.parseDouble(UserInput.getChoise("With " +
	// parameterName + " from: ")));
	// setTo(Double.parseDouble(UserInput.getChoise("With " + parameterName
	// + " to: ")));
    }

}