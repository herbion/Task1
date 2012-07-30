package view.menu.handler;

import java.util.Collection;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.AbstractMenu;
import view.menu.MenuEntry;
import view.util.Printer;
import contoller.functools.Filter;
import contoller.functools.Predicate;
import contoller.query.Finder;
import contoller.util.input.UserInput;

// TODO: Think about how to extend from AbstractMenu 
// TODO: sleep ZZzzzz.
// TODO: add field Filter, and just specify predicate for it; Forget about Finder
@Deprecated
public class OldFindMenu extends AbstractMenu {

    @SuppressWarnings("unused")
    private static final String DATA_FORMAT = "%-5d%-20s%.3f l/km\n";
    @SuppressWarnings("unused")
    private static final String TITLE_FORMAT = "%-5s%-20s%s\n";
    static double from = 0.1, to = 0.7;

    public OldFindMenu() {
	addMenu(new MenuEntry() {
	    @Override
	    public String getTitle() {
		return "... with fuel consumption in range [from,to]";
	    }

	    @Override
	    public void execCommand(AirplaneCompany airCompany) {
		OldFindMenu.updateRangeParameters();
		Collection<Raise> found = new Finder().find(airCompany, from,
			to);
		if (found.size() > 0)
		    Printer.print(found);
		else
		    System.out
			    .println("Sorry, i can\'t find here such airplanes.");
	    }
	});
	addMenu(new MenuEntry() {
	    @Override
	    public String getTitle() {
		return "... with cargo weight in range [from,to]";
	    }

	    @Override
	    public void execCommand(AirplaneCompany airCompany) {
		OldFindMenu.updateRangeParameters();
		Collection<Raise> found = Filter.filter(airCompany,
			new Predicate<Raise>() {
			    @Override
			    public Boolean apply(Raise arg) {
				int weight = arg.getAirplane().getCargoWeight();
				return weight > from && weight < to;
			    }
			});
		if (found.size() > 0)
		    Printer.print(found);
		else
		    System.out
			    .println("Sorry, i can\'t find here such airplanes.");
	    }
	});
    }

    // TODO: Watch for exceptions.
    static void updateRangeParameters() {
	from = Double.parseDouble(UserInput
		.getChoise("With fuel consumption from: "));
	to = Double.parseDouble(UserInput
		.getChoise("With fuel consumption to: "));
	// } catch (NumberFormatException e) {
	// System.out.println("Bad number format. "
	// + "Must be Double [use \".\" instead of \",\"]");
	// }
    }

    @Override
    public void execCommand(AirplaneCompany airCompany) {
	super.execCommand(airCompany);
	System.out
		.printf(
			"Searching for airplanes with fuel consumption in range: [%f, %f]\n",
			from, to);
	// updateRangeParameters();
	// Collection<Raise> found = new Finder().find(airCompany, from, to);
	//	
	// if (found.size() < 1)
	// System.out.println("Sorry, i can\'t find here such airplanes.");
	// else {
	// System.out.printf(TITLE_FORMAT, "#id", "#model",
	// "#fuel consumption");
	// for (Raise raise: found) {
	// Airplane airplane = raise.getAirplane();
	// double fuelConsumption = airplane.getMaximumFuelCapacity() / (double)
	// airplane.getMaximumRange();
	// System.out.printf(DATA_FORMAT, raise.getAirplaneCode(),
	// airplane.getModelTitle(), fuelConsumption);
	// }
	// System.out.println("Summary count: " + found.size());
	// }
    }

    @Override
    public String getTitle() {
	return "Find Airplanes ...";
    }

}
