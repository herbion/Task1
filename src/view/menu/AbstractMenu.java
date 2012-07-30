package view.menu;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import contoller.util.input.UserInput;
import exceptions.view.menu.NoMenuWithIndex;

import model.aircompany.AirplaneCompany;

public abstract class AbstractMenu implements MenuEntry {

    private static final int FIRST_MENU_INDEX = 0;
    private int lastItemIndex = FIRST_MENU_INDEX;
    Map<Integer, MenuEntry> subMenu = new HashMap<Integer, MenuEntry>();

    public void addMenu(MenuEntry menu) {
	if (menu == null)
	    throw new NullPointerException("Menu cannot be empty");
	this.subMenu.put(lastItemIndex++, menu);
    }

    public void showSubMenu() {
	// FIXME: Make if independent from 0
	for (int menuIndex = 0; menuIndex < subMenu.size(); menuIndex++)
	    System.out.println(MessageFormat.format("[{0}] {1}", menuIndex, subMenu.get(menuIndex).getTitle()));
    }

    @Override
    public void execCommand(AirplaneCompany airCompany) {
	startEventCycle(airCompany);
    }

    private void startEventCycle(AirplaneCompany airCompany) {
	System.out.println(this.getTitle()); // FIXME
	if (subMenu.size() > 0) {
//	    while (true) {
	    	// TODO: Change UserInput(String) to UserInput(String, Type)
		String userChoice = null;
		showSubMenu();
		userChoice = UserInput.getChoise("Your choise is: ");
		if (userChoice.toLowerCase().startsWith("q")) {
		    System.out.println("Back to previous menu.");
		    return;
		}
		Integer menuIndex;
		try {
		    menuIndex = Integer.parseInt(userChoice);
		} catch (Exception e) {
		    // } catch (NumberFormatException e) {
		    System.out.println("Wrong argument " + userChoice);
		    // No try again, only hardcore. 
		    //			+ "\nTry again.");
		    return;
		}
		if (menuIndex >= FIRST_MENU_INDEX && menuIndex < subMenu.size())
		    subMenu.get(menuIndex).execCommand(airCompany);
		else {
//		    System.out.println("There is no menu with index: " + menuIndex);
		    throw new NoMenuWithIndex("Wrong index: " + menuIndex);
		}
		    
//	    }
	}
    }
}
