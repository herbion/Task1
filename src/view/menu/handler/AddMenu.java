package view.menu.handler;

import contoller.util.input.UserInput;
import contoller.util.input.enums.SupportedInputTypesEnum;
import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import model.airplane.Airplane;
import model.airplane.factory.BoeingFactory;
import view.menu.AbstractMenu;
import view.menu.MenuEntry;

public class AddMenu extends AbstractMenu {

    public AddMenu() {
	addMenu(new MenuEntry() {

	    @Override
	    public void execCommand(AirplaneCompany arg) {
		System.out.println("Generating random airplane:");
		BoeingFactory factory = new BoeingFactory();
		Airplane airplane = factory.createRandomPassagerAirplane();
		arg.addRaise(new Raise(airplane));
		System.out.println("Added:\n" + airplane);
	    }

	    @Override
	    public String getTitle() {
		return "... add random Airplane";
	    }
	});
	addMenu(new MenuEntry() {
	    
	    @Override
	    public String getTitle() {
		return "... remove Airplane with {id}";
	    }
	    
	    @Override
	    public void execCommand(AirplaneCompany arg) {
		Long choice = UserInput.getChoice("Enter id.", SupportedInputTypesEnum.INT).longValue();
		try {
		    arg.getRaiseDataBase().remove(choice);
		    System.out.println("Removed data with id: " + choice);
		} catch (Exception e) {
		    System.out.println("[!] Error occured while removing: " + e.getMessage());
		}
		
	    }
	});
    }

    @Override
    public String getTitle() {
	return "Add/Remove airplanes ...";
    }

}
