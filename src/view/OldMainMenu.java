package view;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.aircompany.AirplaneCompany;
import view.menu.MenuEntry;
import view.menu.handler.OldFindMenu;
import view.menu.handler.PrintMenu;
import view.menu.handler.SortMenu;
import view.menu.handler.SummaryMenu;

@Deprecated
public class OldMainMenu {
    private static Scanner scanner = new Scanner(System.in);
    
    Map<Integer, MenuEntry> mainMenu = new HashMap<Integer, MenuEntry>();
    private static int id = 0;
    
    public OldMainMenu() {
	addMenu(new PrintMenu());
	addMenu(new OldFindMenu());
	addMenu(new SortMenu());
	addMenu(new SummaryMenu());
    }
    public void addMenu(MenuEntry menu) {
	if (menu == null ) 
	    throw new NullPointerException("Menu cannot be empty");
	this.mainMenu.put(id++, menu);
    }
    public static String getUserChoise(String greeting) {
	System.out.print(greeting);
	return scanner.next();
    }

    public void showMainMenu() {
	for (int i = 0; i < mainMenu.size(); i++)
	    System.out.println(MessageFormat.format("[{0}] {1}", i, mainMenu.get(i).getTitle()));
    }

    public void startDialog(AirplaneCompany airCompany) {
	System.out.println("Greetings, user. This is company " + airCompany.AirCompanyName);
	String userChoice = null;
	while (true) {
	    showMainMenu();
	    userChoice = getUserChoise("Your choise is: ");
	    if (userChoice.toLowerCase().startsWith("q")) {
		System.out.println("Bye.");
		break;
	    }
	    Integer menuIndex;
	    try {
		menuIndex = Integer.parseInt(userChoice);
	    } catch (Exception e) {
//	    } catch (NumberFormatException e) {
		System.out.println("Wrong argument " + userChoice
			+ "\nTry again.");
		continue;
	    }
	    mainMenu.get(menuIndex).execCommand(airCompany);
//	    
//	    try {
//		switch (Integer.parseInt(user_choice)) {
//		case 1:
//		    airCompany.printAvaliableAirplanes();
//		    break;
//		case 2:
//		    airCompany.printAvaliableAirplanesSortedByMaximumRange();
//		    break;
//		case 3: {
//		    try {
//			double from = Double.parseDouble(ud
//				.getUserChoise("With fuel consumption from: "));
//			double to = Double.parseDouble(ud
//				.getUserChoise("With fuel consumption to: "));
//			airCompany.findAirplanesWithFuelConsumptionInRange(
//				from, to);
//		    } catch (NumberFormatException e) {
//			System.out
//				.println("Bad number format. "
//					+ "Must be Double [use \".\" instead of \",\"]");
//		    }
//		    break;
//		}
//		case 4: {
//		    try {
//			System.out.println(airCompany.getAirplaneById(Long
//				.parseLong(ud.getUserChoise("Enter id: "))));
//		    } catch (NumberFormatException e) {
//			System.out
//				.println("Horrible mistake happens. Id must be Integer.");
//		    }
//		    break;
//		}
//		case 5:
//		    System.out.println("Summary cargo weight: "
//			    + airCompany.countSummaryCargoWeight() + "kg");
//		    break;
//		case 6:
//		    System.out.println("Summary takeoff weight: "
//			    + airCompany.countSummaryTakeoffWeight() + "kg");
//		    break;
//		default:
//		    System.out.println("Wrong argument " + user_choice
//			    + "\nTry again.");
//		}
//	    } catch (NumberFormatException e) {
//		System.out.println("Wrong argument " + user_choice
//			+ "\nTry again.");
//	    }
	}
    }
}