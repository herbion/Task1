package view.menu.handler;

import java.util.Comparator;
import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import view.menu.AbstractMenu;
import view.menu.handler.impl.sort.SortEntryFactory;
import view.menu.handler.impl.sort.SupportedSortOperationsEnum;
import view.util.Printer;
import contoller.query.Sorter;

public class SortMenu extends AbstractMenu {
    private Comparator<Entry<Long, Raise>> COMPARATOR;

    public SortMenu() {
	addMenu(SortEntryFactory.getInstance(this,
		SupportedSortOperationsEnum.BY_SPEED));
	addMenu(SortEntryFactory.getInstance(this,
		SupportedSortOperationsEnum.BY_CARGO_WEIGHT));
	addMenu(SortEntryFactory.getInstance(this,
		SupportedSortOperationsEnum.BY_FLIGHT_RANGE));
    }

    @Override
    public void execCommand(AirplaneCompany airCompany) {
	super.execCommand(airCompany);
	Printer.print(Sorter.sort(airCompany, getComparator()));
    }

    public Comparator<Entry<Long, Raise>> getComparator() {
	return COMPARATOR;
    }

    @Override
    public String getTitle() {
	return "Sort airplanes by...";
    }

    public void setComparator(Comparator<Entry<Long, Raise>> RAISE_COMPARATOR) {
	this.COMPARATOR = RAISE_COMPARATOR;
    }

}
