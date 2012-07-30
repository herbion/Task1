package view.menu.handler;

import java.util.Comparator;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.AbstractMenu;
import view.menu.MenuEntry;
import view.menu.handler.impl.sort.SortBySpeed;
import view.util.Printer;
import contoller.query.Sorter;

public class SortMenu extends AbstractMenu {
    private Comparator<Raise> COMPARATOR;

    public SortMenu() {
	addMenu(new SortBySpeed(this));
	addMenu(new MenuEntry() {
	    @Override
	    public String getTitle() {
		return " ... Flight Range.";
	    }

	    @Override
	    public void execCommand(AirplaneCompany company) {
		setComparator(Raise.COMPARE_BY_FLIGHT_RANGE);
	    }
	});
	addMenu(new MenuEntry() {
	    @Override
	    public String getTitle() {
		return " ... Cargo Weight.";
	    }

	    @Override
	    public void execCommand(AirplaneCompany company) {
		setComparator(new Comparator<Raise>() {
		    @Override
		    public int compare(Raise o1, Raise o2) {
			return o1.getAirplane().getCargoWeight()
				- o2.getAirplane().getCargoWeight();
		    }
		});
	    }
	});
    }

    @Override
    public void execCommand(AirplaneCompany airCompany) {
	super.execCommand(airCompany);
	Printer.print(Sorter.sort(airCompany, getComparator()));
    }

    @Override
    public String getTitle() {
	return "Sort airplanes by...";
    }

    public void setComparator(Comparator<Raise> RAISE_COMPARATOR) {
	this.COMPARATOR = RAISE_COMPARATOR;
    }

    public Comparator<Raise> getComparator() {
	return COMPARATOR;
    }

}
