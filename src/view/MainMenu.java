package view;

import model.aircompany.AirplaneCompany;
import view.menu.AbstractMenu;
import view.menu.handler.AddMenu;
import view.menu.handler.FindMenu;
import view.menu.handler.PrintMenu;
import view.menu.handler.QuitMenu;
import view.menu.handler.SortMenu;
import view.menu.handler.SumMenu;
import exceptions.view.menu.NoMenuWithIndexSignal;
import exceptions.view.menu.QuitSignal;
import exceptions.view.menu.WrongIndexSignal;

public class MainMenu extends AbstractMenu {
    public MainMenu() {
	addMenu(new PrintMenu());
	addMenu(new AddMenu());
	addMenu(new FindMenu());
	addMenu(new SortMenu());
	addMenu(new SumMenu());
	addMenu(new QuitMenu());
    }

    @Override
    public void execCommand(AirplaneCompany airCompany) {
	System.out.println("Greetings, user. This is company "
		+ airCompany.AirCompanyName);
	try {
	    while (true) {
		try {
		    super.execCommand(airCompany);
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		} catch (IllegalStateException e) {
		    System.out.println(e);
		} catch (NoMenuWithIndexSignal e) {
		    System.out.println(e.getMessage());
		} catch (WrongIndexSignal e) {
		    System.out.println(e.getMessage());
		} catch (Exception e) {
		    throw e;
		}
	    }
	} catch (QuitSignal e) {
	    System.out.println("Exit with code: " + e.getMessage());
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public String getTitle() {
	return "~~ Main menu ~~";
    }
}