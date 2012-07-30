package view.menu.handler;

import model.aircompany.AirplaneCompany;
import model.airplane.Airplane;
import model.airplane.factory.BoeingFactory;
import view.menu.AbstractMenu;
import view.menu.MenuEntry;

public class AddMenu extends AbstractMenu {

    public AddMenu() {
	addMenu(new MenuEntry() {
	    
	    @Override
	    public String getTitle() {
		return "... random Airplane";
	    }
	    
	    @Override
	    public void execCommand(AirplaneCompany arg) {
		System.out.println("Generating random airplane:");
		BoeingFactory factory = new BoeingFactory();
		Airplane airplane = factory.createRandomPassagerAirplane();
		System.out.println(airplane);
//		arg.addAirplane(airplane);
		System.out.println("Added");
	    }
	});
    }
    @Override
    public String getTitle() {
	return "Add ...";
    }

}
