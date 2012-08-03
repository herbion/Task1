package view.menu.handler;

import model.aircompany.AirplaneCompany;
import view.menu.AbstractMenu;
import view.menu.MenuEntry;
import view.util.Printer;
import contoller.util.input.UserInput;
import contoller.util.input.enums.SupportedInputTypesEnum;

public class PrintMenu extends AbstractMenu {
    public PrintMenu() {
	addMenu(new MenuEntry() {

	    @Override
	    public void execCommand(AirplaneCompany company) {
		Printer.print(company.getRaiseDataBase());
	    }

	    @Override
	    public String getTitle() {
		return "... all avaliable airplanes as table.";
	    }
	});
	addMenu(new MenuEntry() {

	    @Override
	    public void execCommand(AirplaneCompany company) {
		Long id = UserInput.getChoice("Enter ID of airplane.",
			SupportedInputTypesEnum.INT).longValue();
		System.out.println(id);
		if (id < 0 || id > company.getRaiseDataBase().size())
		    throw new IllegalArgumentException("Wrong id specified: "
			    + id);
		Printer.printById(company, id);
	    }

	    @Override
	    public String getTitle() {
		return "... full info about airplane with {id}.";
	    }
	});
    }

    @Override
    public void execCommand(AirplaneCompany company) {
	super.execCommand(company);
    }

    @Override
    public String getTitle() {
	return "Print ...";
    }

}
