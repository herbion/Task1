package view.menu;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import model.aircompany.AirplaneCompany;
import contoller.util.input.UserInput;
import exceptions.view.menu.NoMenuWithIndexSignal;
import exceptions.view.menu.WrongIndexSignal;

public abstract class AbstractMenu implements MenuEntry {

    private static final int FIRST_MENU_INDEX = 0;
    private int lastItemIndex = FIRST_MENU_INDEX;
    Map<Integer, MenuEntry> subMenu = new HashMap<Integer, MenuEntry>();

    public void addMenu(MenuEntry menu) {
	if (menu == null)
	    throw new NullPointerException("Menu cannot be empty");
	this.subMenu.put(lastItemIndex++, menu);
    }

    @Override
    public void execCommand(AirplaneCompany company) {
	startEventCycle(company);
    }

    public void showSubMenu() {
	// FIXME: Make if independent from 0
	for (int menuIndex = 0; menuIndex < subMenu.size(); menuIndex++)
	    System.out.println(MessageFormat.format("[{0}] {1}", menuIndex,
		    subMenu.get(menuIndex).getTitle()));
    }

    private void startEventCycle(AirplaneCompany company) {
	System.out.println(this.getTitle()); 
	if (subMenu.size() > 0) {
	    String userChoice = null;
	    showSubMenu();
	    userChoice = UserInput.getChoice("Your choise is: ");
	    if (userChoice.toLowerCase().startsWith("q")) {
		throw new WrongIndexSignal("Back to previous menu.");
	    }
	    Integer menuIndex;
	    try {
		menuIndex = Integer.parseInt(userChoice);
	    } catch (Exception e) {
		throw new WrongIndexSignal("Wrong argument " + userChoice);
	    }
	    if (menuIndex >= FIRST_MENU_INDEX && menuIndex < subMenu.size())
		subMenu.get(menuIndex).execCommand(company);
	    else {
		throw new NoMenuWithIndexSignal("Wrong index: " + menuIndex);
	    }
	}
    }
}
