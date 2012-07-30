package view.menu.handler;

import model.aircompany.AirplaneCompany;
import view.menu.MenuEntry;
import view.util.Printer;

public class PrintMenu implements MenuEntry {

    @Override
    public void execCommand(AirplaneCompany company) {
	Printer.print(company.getRaiseDataBase(),
		Printer.RAISE_DETAILED_DATA_FORMAT);
    }

    @Override
    public String getTitle() {
	return "Print avaliable airplanes.";
    }

}
